package com.insurance.repository;

import com.insurance.entity.Premium;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Premium entity.
 */
public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
