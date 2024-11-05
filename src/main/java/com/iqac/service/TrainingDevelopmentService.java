package com.iqac.service;

import com.iqac.model.TrainingDevelopment;
import com.iqac.repository.TrainingDevelopmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingDevelopmentService {
    @Autowired
    private TrainingDevelopmentRepository trainingDevelopmentRepository;

    public List<TrainingDevelopment> getAllTrainings() {
        return trainingDevelopmentRepository.findAll();
    }

    public TrainingDevelopment getTrainingById(Long id) {
        return trainingDevelopmentRepository.findById(id).orElse(null);
    }

    public TrainingDevelopment saveTraining(TrainingDevelopment trainingDevelopment) {
        return trainingDevelopmentRepository.save(trainingDevelopment);
    }

    public void deleteTraining(Long id) {
        trainingDevelopmentRepository.deleteById(id);
    }
}
