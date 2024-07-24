package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.RecruitmentNotFoundException;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecruitmentValidatorTest {

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @InjectMocks
    private RecruitmentValidator recruitmentValidator;

    @Test
    @DisplayName("[RecruitmentValidator][validate][Success]")
    public void validateSuccess() {
        Long id = 1L;
        when(recruitmentRepository.findById(id)).thenReturn(Optional.of(new RecruitmentEntity()));
        recruitmentValidator.validate(id);
    }

    @Test
    @DisplayName("[RecruitmentValidator][validate][Success]")
    public void validateFailure() {
        Long id = 8888L;
        when(recruitmentRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RecruitmentNotFoundException.class, () -> {
            recruitmentValidator.validate(id);
        });
    }

}