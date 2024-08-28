package com.insurance.repository;

import com.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Policy entity.
 */
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
