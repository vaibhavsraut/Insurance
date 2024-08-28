package com.insurance.service;

import com.insurance.entity.Nominee;
import java.util.List;

/**
 * Service interface for managing Nominees.
 */
public interface NomineeService {
    List<Nominee> getAllNominees();
    Nominee getNomineeById(Long id);
    Nominee saveNominee(Nominee nominee);
    void deleteNominee(Long id);
}
