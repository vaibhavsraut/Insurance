package com.insurance.controller;

import com.insurance.entity.Claim;
import com.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Claims.
 */
@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.getAllClaims();
        if (claims.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        if (claim == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(claim);
    }

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        if (claim == null || claim.getClaimAmount() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Claim createdClaim = claimService.saveClaim(claim);
        return ResponseEntity.ok(createdClaim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable Long id) {
        try {
            claimService.deleteClaim(id);
            return ResponseEntity.ok("Claim deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the claim: " + e.getMessage());
        }
    }
}
