package com.insurance.controller;

import com.insurance.entity.Bill;
import com.insurance.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Bills.
 */
@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        List<Bill> bills = billService.getAllBills();
        if (bills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        Bill bill = billService.getBillById(id);
        if (bill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        if (bill == null || bill.getPaymentAmount() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Bill createdBill = billService.saveBill(bill);
        return ResponseEntity.ok(createdBill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        try {
            billService.deleteBill(id);
            return ResponseEntity.ok("Bill deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the bill: " + e.getMessage());
        }
    }
}
