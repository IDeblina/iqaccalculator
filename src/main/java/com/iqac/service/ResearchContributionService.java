package com.iqac.service;

import com.iqac.model.ResearchContribution;
import com.iqac.repository.ResearchContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchContributionService {
    @Autowired
    private ResearchContributionRepository researchContributionRepository;


    public List<ResearchContribution> getAllContributions() {
        return researchContributionRepository.findAll();
    }

    public ResearchContribution getContributionById(Long id) {
        return researchContributionRepository.findById(id).orElse(null);
    }

    public ResearchContribution saveContribution(ResearchContribution researchContribution) {
        return researchContributionRepository.save(researchContribution);
    }

    public void deleteContribution(Long id) {
        researchContributionRepository.deleteById(id);
    }
}
