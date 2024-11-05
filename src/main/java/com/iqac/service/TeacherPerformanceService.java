package com.iqac.service;


import com.iqac.model.TeacherPerformance;
import com.iqac.repository.TeacherPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherPerformanceService {
    @Autowired
    private TeacherPerformanceRepository teacherPerformanceRepository;

    public List<TeacherPerformance> getAllPerformances() {
        return teacherPerformanceRepository.findAll();
    }

    public TeacherPerformance getPerformanceById(Long id) {
        return teacherPerformanceRepository.findById(id).orElse(null);
    }

    public TeacherPerformance savePerformance(TeacherPerformance teacherPerformance) {
        return teacherPerformanceRepository.save(teacherPerformance);
    }

    public void deletePerformance(Long id) {
        teacherPerformanceRepository.deleteById(id);
    }
}
