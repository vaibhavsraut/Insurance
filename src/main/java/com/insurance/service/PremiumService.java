package com.insurance.service;

import com.insurance.entity.Premium;
import java.util.List;

/**
 * Service interface for managing Premiums.
 */
public interface PremiumService {
    List<Premium> getAllPremiums();
    Premium getPremiumById(Long id);
    Premium savePremium(Premium premium);
    void deletePremium(Long id);
}
