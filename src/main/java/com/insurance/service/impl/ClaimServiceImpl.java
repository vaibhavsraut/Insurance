package com.insurance.service.impl;

import com.insurance.entity.Claim;
import com.insurance.repository.ClaimRepository;
import com.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Claims.
 */
@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getClaimById(Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    @Override
    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}
