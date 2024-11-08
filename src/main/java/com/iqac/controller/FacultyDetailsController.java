package com.iqac.controller;

import com.iqac.model.FacultyDetails;
import com.iqac.service.FacultyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin
public class FacultyDetailsController {
    @Autowired
    private FacultyDetailsService facultyDetailsService;

    @GetMapping
    public List<FacultyDetails> getAllFaculties() {
        return facultyDetailsService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDetails> getFacultyById(@PathVariable Long id) {
        FacultyDetails faculty = facultyDetailsService.getFacultyById(id);
        return faculty != null ? ResponseEntity.ok(faculty) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public FacultyDetails createFaculty(@RequestBody FacultyDetails facultyDetails) {
        return facultyDetailsService.saveFaculty(facultyDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyDetailsService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
