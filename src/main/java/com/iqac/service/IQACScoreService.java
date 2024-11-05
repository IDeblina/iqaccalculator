package com.iqac.service;

import com.iqac.model.*;
import com.iqac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IQACScoreService {
    @Autowired
    private FacultyDetailsRepository facultyDetailsRepository;
    @Autowired
    private TeacherPerformanceRepository teacherPerformanceRepository;
    @Autowired
    private ResearchContributionRepository researchContributionRepository;
    @Autowired
    private PhDPapersRepository phdPapersRepository;
    @Autowired
    private CommunityServiceRepository communityServiceRepository;
    @Autowired
    private TrainingDevelopmentRepository trainingDevelopmentRepository;

    public Double calculateIQACScore(Long facultyId) {
        Double totalScore = 0.0;

        // 1. Calculate Teacher Performance Score
        TeacherPerformance performance = teacherPerformanceRepository.findById(facultyId).orElse(null);
        if (performance != null) {
            Double performanceScore = (performance.getPerformanceScore() / 10)
                    + (performance.getTeachingExperienceYears() * 1.5)
                    + (performance.getFeedbackScore() != null ? performance.getFeedbackScore() * 0.5 : 0);
            totalScore += performanceScore;
        }

        // 2. Calculate Research Contribution Score
        ResearchContribution research = researchContributionRepository.findById(facultyId).orElse(null);
        if (research != null) {
            Double researchScore = (double) ((research.getPapersPublished() * 2)
                                + (research.getConferencesAttended() != null ? research.getConferencesAttended() * 3 : 0)
                                + (research.getProjectsCompleted() * 4)
                                + (research.getPapersPublished() * 5));
            totalScore += researchScore;
        }

        // 3. Calculate PhD Supervision Score
        PhDPapers phdPapers = phdPapersRepository.findById(facultyId).orElse(null);
        if (phdPapers != null) {
            Double phdScore = (double) ((phdPapers.getPapersSupervised() * 4)
                                + (phdPapers.getThesesGuided() * 2));
            totalScore += phdScore;
        }

        // 4. Calculate Community Service Score
        CommunityService communityService = communityServiceRepository.findById(facultyId).orElse(null);
        if (communityService != null) {
            Double communityScore = (communityService.getServiceHours() * 1.2)
                    + (communityService.getProjectsParticipated() * 2)
                    + (communityService.getEventsOrganized() * 3)
                    + (communityService.getForeignParticipation() ? 5 : 0);
            totalScore += communityScore;
        }

        // 5. Calculate Training & Development Score
        TrainingDevelopment training = trainingDevelopmentRepository.findById(facultyId).orElse(null);
        if (training != null) {
            Double trainingScore = (training.getTrainingsAttended() * 1.5)
                    + (training.getCertificationsObtained() * 3)
                    + (training.getWorkshopsConducted() * 4)
                    + (training.getOnlineCoursesCompleted() * 2);
            totalScore += trainingScore;
        }

        return totalScore;
    }
}
