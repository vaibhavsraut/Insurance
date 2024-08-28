package com.insurance.service;

import com.insurance.entity.Policy;
import java.util.List;

/**
 * Service interface for managing Policies.
 */
public interface PolicyService {
    List<Policy> getAllPolicies();
    Policy getPolicyById(Long id);
    Policy savePolicy(Policy policy);
    void deletePolicy(Long id);
}
