package com.iqac.service;

import com.iqac.model.CommunityService;
import com.iqac.repository.CommunityServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceService {
    @Autowired
    private CommunityServiceRepository communityServiceRepository;

    public List<CommunityService> getAllServices() {
        return communityServiceRepository.findAll();
    }

    public CommunityService getServiceById(Long id) {
        return communityServiceRepository.findById(id).orElse(null);
    }

    public CommunityService saveService(CommunityService communityService) {
        return communityServiceRepository.save(communityService);
    }

    public void deleteService(Long id) {
        communityServiceRepository.deleteById(id);
    }
}
