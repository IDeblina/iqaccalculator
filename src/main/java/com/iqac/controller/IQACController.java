package com.iqac.controller;

import com.iqac.model.FacultyDetails;
import com.iqac.model.IQACEntity;
import com.iqac.service.FacultyDetailsService;
import com.iqac.service.IQACScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/iqac")
public class IQACController {
    @Autowired
    private IQACScoreService iqacScoreService;

    @Autowired
    private FacultyDetailsService facultyDetailsService;

    @GetMapping(value = "/calculatescore/{facultyId}", produces = "application/json")
    public ResponseEntity<IQACEntity> calculateIQACScore(@PathVariable Long facultyId) {
        Double score = iqacScoreService.calculateIQACScore(facultyId);
        FacultyDetails faculty = facultyDetailsService.getFacultyById(facultyId);
        IQACEntity iqacEntity = new IQACEntity(faculty, score);
        return ResponseEntity.ok(iqacEntity);
    }
}
