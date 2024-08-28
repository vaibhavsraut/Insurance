package com.insurance.repository;

import com.insurance.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Claim entity.
 */
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
