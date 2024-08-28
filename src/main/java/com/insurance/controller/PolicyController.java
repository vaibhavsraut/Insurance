package com.insurance.controller;

import com.insurance.entity.Policy;
import com.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Policies.
 */
@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        if (policies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(policies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(policy);
    }

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        if (policy == null || policy.getPremium() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Policy createdPolicy = policyService.savePolicy(policy);
        return ResponseEntity.ok(createdPolicy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable Long id) {
        try {
            policyService.deletePolicy(id);
            return ResponseEntity.ok("Policy deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the policy: " + e.getMessage());
        }
    }
}
