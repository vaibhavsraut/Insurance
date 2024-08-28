package com.insurance.service.impl;

import com.insurance.entity.Premium;
import com.insurance.repository.PremiumRepository;
import com.insurance.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Premiums.
 */
@Service
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    private PremiumRepository premiumRepository;

    @Override
    public List<Premium> getAllPremiums() {
        return premiumRepository.findAll();
    }

    @Override
    public Premium getPremiumById(Long id) {
        return premiumRepository.findById(id).orElse(null);
    }

    @Override
    public Premium savePremium(Premium premium) {
        return premiumRepository.save(premium);
    }

    @Override
    public void deletePremium(Long id) {
        premiumRepository.deleteById(id);
    }
}
