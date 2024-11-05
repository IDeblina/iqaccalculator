package com.iqac.controller;

import com.iqac.model.CommunityService;
import com.iqac.service.CommunityServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/community-services")
public class CommunityServiceController {

    @Autowired
    private CommunityServiceService communityServiceService;

    @GetMapping
    public List<CommunityService> getAllServices() {
        return communityServiceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityService> getServiceById(@PathVariable Long id) {
        CommunityService service = communityServiceService.getServiceById(id);
        return service != null ? ResponseEntity.ok(service) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CommunityService createService(@RequestBody CommunityService communityService) {
        return communityServiceService.saveService(communityService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        communityServiceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
