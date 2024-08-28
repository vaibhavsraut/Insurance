package com.insurance.service;

import com.insurance.entity.Bill;
import java.util.List;

/**
 * Service interface for managing Bills.
 */
public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    Bill saveBill(Bill bill);
    void deleteBill(Long id);
}
