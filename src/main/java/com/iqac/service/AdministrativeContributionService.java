package com.iqac.service;

import com.iqac.model.AdministrativeContribution;
import com.iqac.repository.AdministrativeContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativeContributionService {
    @Autowired
    private AdministrativeContributionRepository administrativeContributionRepository;

    public List<AdministrativeContribution> getAllContributions() {
        return administrativeContributionRepository.findAll();
    }

    public AdministrativeContribution getContributionById(Long id) {
        return administrativeContributionRepository.findById(id).orElse(null);
    }

    public AdministrativeContribution saveContribution(AdministrativeContribution administrativeContribution) {
        return administrativeContributionRepository.save(administrativeContribution);
    }

    public void deleteContribution(Long id) {
        administrativeContributionRepository.deleteById(id);
    }
}
