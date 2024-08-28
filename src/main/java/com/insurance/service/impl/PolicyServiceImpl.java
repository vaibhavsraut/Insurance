package com.insurance.service.impl;

import com.insurance.entity.Policy;
import com.insurance.repository.PolicyRepository;
import com.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Policies.
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    @Override
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }
}
