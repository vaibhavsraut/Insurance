package com.insurance.service.impl;

import com.insurance.entity.Nominee;
import com.insurance.repository.NomineeRepository;
import com.insurance.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Nominees.
 */
@Service
public class NomineeServiceImpl implements NomineeService {

    @Autowired
    private NomineeRepository nomineeRepository;

    @Override
    public List<Nominee> getAllNominees() {
        return nomineeRepository.findAll();
    }

    @Override
    public Nominee getNomineeById(Long id) {
        return nomineeRepository.findById(id).orElse(null);
    }

    @Override
    public Nominee saveNominee(Nominee nominee) {
        return nomineeRepository.save(nominee);
    }

    @Override
    public void deleteNominee(Long id) {
        nomineeRepository.deleteById(id);
    }
}
