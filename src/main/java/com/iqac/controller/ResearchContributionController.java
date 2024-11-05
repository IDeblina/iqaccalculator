package com.iqac.controller;


import com.iqac.model.ResearchContribution;
import com.iqac.service.ResearchContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/research-contributions")
public class ResearchContributionController {
    @Autowired
    private ResearchContributionService researchContributionService;

    @GetMapping
    public List<ResearchContribution> getAllContributions() {
        return researchContributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResearchContribution> getContributionById(@PathVariable Long id) {
        ResearchContribution contribution = researchContributionService.getContributionById(id);
        return contribution != null ? ResponseEntity.ok(contribution) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResearchContribution createContribution(@RequestBody ResearchContribution researchContribution) {
        return researchContributionService.saveContribution(researchContribution);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContribution(@PathVariable Long id) {
        researchContributionService.deleteContribution(id);
        return ResponseEntity.noContent().build();
    }
}
