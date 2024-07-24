package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.AlreadyAppliedException;
import com.wanted.recruitment.persistence.repository.JobApplicationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobApplicationValidator {
    
    private final JobApplicationsRepository jobApplicationsRepository;
    
    public void validate(String userId) {
        if (jobApplicationsRepository.existsByUserId(userId)) {
            throw new AlreadyAppliedException();
        }
    }
}
