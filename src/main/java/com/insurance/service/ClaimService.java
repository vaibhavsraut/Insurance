package com.insurance.service;

import com.insurance.entity.Claim;
import java.util.List;

/**
 * Service interface for managing Claims.
 */
public interface ClaimService {
    List<Claim> getAllClaims();
    Claim getClaimById(Long id);
    Claim saveClaim(Claim claim);
    void deleteClaim(Long id);
}
