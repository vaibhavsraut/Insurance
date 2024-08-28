package com.insurance.repository;

import com.insurance.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Bill entity.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {
}
