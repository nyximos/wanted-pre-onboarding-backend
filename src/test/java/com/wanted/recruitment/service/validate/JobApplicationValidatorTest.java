package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.AlreadyAppliedException;
import com.wanted.recruitment.persistence.repository.JobApplicationsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobApplicationValidatorTest {

    @Mock
    private JobApplicationsRepository jobApplicationsRepository;

    @InjectMocks
    private JobApplicationValidator jobApplicationValidator;

    @Test
    @DisplayName("[JobApplicationValidator][validate][Success]")
    public void validateSuccess() {
        String id = "test";
        when(jobApplicationsRepository.existsByUserId(id)).thenReturn(false);
        jobApplicationValidator.validate(id);
    }

    @Test
    @DisplayName("[JobApplicationValidator][validate][Success]")
    public void validateFailure() {
        String id = "test";
        when(jobApplicationsRepository.existsByUserId(id)).thenReturn(true);
        assertThrows(AlreadyAppliedException.class, () -> {
            jobApplicationValidator.validate(id);
        });
    }
}