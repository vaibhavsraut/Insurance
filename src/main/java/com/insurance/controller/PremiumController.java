package com.insurance.controller;

import com.insurance.entity.Premium;
import com.insurance.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Premiums.
 */
@RestController
@RequestMapping("/api/premiums")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    @GetMapping
    public ResponseEntity<List<Premium>> getAllPremiums() {
        List<Premium> premiums = premiumService.getAllPremiums();
        if (premiums.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(premiums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Premium> getPremiumById(@PathVariable Long id) {
        Premium premium = premiumService.getPremiumById(id);
        if (premium == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(premium);
    }

    @PostMapping
    public ResponseEntity<Premium> createPremium(@RequestBody Premium premium) {
        if (premium == null || premium.getPrice() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Premium createdPremium = premiumService.savePremium(premium);
        return ResponseEntity.ok(createdPremium);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePremium(@PathVariable Long id) {
        try {
            premiumService.deletePremium(id);
            return ResponseEntity.ok("Premium deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the premium: " + e.getMessage());
        }
    }
}
