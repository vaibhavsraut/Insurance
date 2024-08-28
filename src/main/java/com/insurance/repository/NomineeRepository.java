package com.insurance.repository;

import com.insurance.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Nominee entity.
 */
public interface NomineeRepository extends JpaRepository<Nominee, Long> {
}
