package com.wanted.recruitment.service;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.converter.RecruitmentConverter;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import com.wanted.recruitment.service.validate.CompanyValidator;
import com.wanted.recruitment.service.validate.RecruitmentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecruitmentServiceTest {
    @Mock
    private CompanyValidator companyValidator;

    @Mock
    private RecruitmentConverter recruitmentConverter;

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @InjectMocks
    private RecruitmentService recruitmentService;

    @Test
    @DisplayName("[RecruitmentConverter][convert][Success]")
    public void addTest() {
        long companyId = 1L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String technology = "Python";
        String contents = "원티드랩에서 백엔드 주니어 개발자를 채용합니다.";

        RecruitmentRequestModel model = RecruitmentRequestModel.builder()
                .companyId(companyId)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .build();

        RecruitmentEntity entity = RecruitmentEntity.builder()
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .build();

        doNothing().when(companyValidator).validate(any(Long.class));
        when(recruitmentConverter.convert(any(RecruitmentRequestModel.class))).thenReturn(entity);
        when(recruitmentRepository.save(any(RecruitmentEntity.class))).thenReturn(entity);

        recruitmentService.add(model);

        verify(companyValidator).validate(eq(companyId));
        verify(recruitmentConverter).convert(any(RecruitmentRequestModel.class));
        verify(recruitmentRepository).save(entity);
    }
}