package com.iqac.controller;

import com.iqac.model.TrainingDevelopment;
import com.iqac.service.TrainingDevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-developments")
public class TrainingDevelopmentController {
    @Autowired
    private TrainingDevelopmentService trainingDevelopmentService;

    @GetMapping
    public List<TrainingDevelopment> getAllTrainings() {
        return trainingDevelopmentService.getAllTrainings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDevelopment> getTrainingById(@PathVariable Long id) {
        TrainingDevelopment training = trainingDevelopmentService.getTrainingById(id);
        return training != null ? ResponseEntity.ok(training) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TrainingDevelopment createTraining(@RequestBody TrainingDevelopment trainingDevelopment) {
        return trainingDevelopmentService.saveTraining(trainingDevelopment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingDevelopmentService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}
