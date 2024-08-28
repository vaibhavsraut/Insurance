package com.insurance.controller;

import com.insurance.entity.Nominee;
import com.insurance.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Nominees.
 */
@RestController
@RequestMapping("/api/nominees")
public class NomineeController {

    @Autowired
    private NomineeService nomineeService;

    @GetMapping
    public ResponseEntity<List<Nominee>> getAllNominees() {
        List<Nominee> nominees = nomineeService.getAllNominees();
        if (nominees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(nominees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nominee> getNomineeById(@PathVariable Long id) {
        Nominee nominee = nomineeService.getNomineeById(id);
        if (nominee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nominee);
    }

    @PostMapping
    public ResponseEntity<Nominee> createNominee(@RequestBody Nominee nominee) {
        if (nominee == null || nominee.getPercentage() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Nominee createdNominee = nomineeService.saveNominee(nominee);
        return ResponseEntity.ok(createdNominee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNominee(@PathVariable Long id) {
        try {
            nomineeService.deleteNominee(id);
            return ResponseEntity.ok("Nominee deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the nominee: " + e.getMessage());
        }
    }
}
