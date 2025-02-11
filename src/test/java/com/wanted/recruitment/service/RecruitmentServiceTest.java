package com.wanted.recruitment.service;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;
import com.wanted.recruitment.converter.RecruitmentConverter;
import com.wanted.recruitment.persistence.repository.CompanyRepository;
import com.wanted.recruitment.persistence.repository.JobApplicationsRepository;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.CompanyEntity;
import com.wanted.recruitment.persistence.repository.entity.JobApplicationsEntity;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import com.wanted.recruitment.service.validate.CompanyValidator;
import com.wanted.recruitment.service.validate.JobApplicationValidator;
import com.wanted.recruitment.service.validate.RecruitmentValidator;
import com.wanted.recruitment.service.validate.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecruitmentServiceTest {

    @Mock
    private RecruitmentValidator recruitmentValidator;

    @Mock
    private CompanyValidator companyValidator;

    @Mock
    private RecruitmentConverter recruitmentConverter;

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private UserValidator userValidator;

    @Mock
    private JobApplicationValidator jobApplicationValidator;

    @Mock
    private JobApplicationsRepository jobApplicationsRepository;

    @InjectMocks
    private RecruitmentService recruitmentService;

    @Test
    @DisplayName("[RecruitmentServiceTest][add][Success]")
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
                .companyId(companyId)
                .build();

        doNothing().when(companyValidator).validate(any(Long.class));
        when(recruitmentConverter.convert(any(RecruitmentRequestModel.class))).thenReturn(entity);
        when(recruitmentRepository.save(any(RecruitmentEntity.class))).thenReturn(entity);

        recruitmentService.add(model);

        verify(companyValidator, times(1)).validate(eq(companyId));
        verify(recruitmentConverter, times(1)).convert(any(RecruitmentRequestModel.class));
        verify(recruitmentRepository, times(1)).save(entity);
    }

    @Test
    @DisplayName("[RecruitmentServiceTest][update][Success]")
    public void update() {
        long recruitmentId = 1L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String technology = "Spring";
        String newTechnology = "Django";
        String contents = "원티드랩에서 백엔드 주니어 개발자를 채용합니다.";

        RecruitmentUpdateRequestModel model = RecruitmentUpdateRequestModel.builder()
                .position(position)
                .compensation(compensation)
                .technology(newTechnology)
                .contents(contents)
                .build();

        RecruitmentEntity entity = RecruitmentEntity.builder()
                .id(recruitmentId)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .build();

        when(recruitmentValidator.validate(recruitmentId)).thenReturn(entity);

        recruitmentService.update(recruitmentId, model);

        verify(recruitmentValidator).validate(eq(recruitmentId));
        verify(recruitmentRepository).save(entity);

        assertEquals(model.getPosition(), entity.getPosition());
        assertEquals(model.getCompensation(), entity.getCompensation());
        assertEquals(model.getTechnology(), entity.getTechnology());
        assertEquals(model.getContents(), entity.getContents());
    }

    @Test
    @DisplayName("[RecruitmentServiceTest][remove][Success]")
    public void remove() {
        Long recruitmentId = 1L;
        when(recruitmentValidator.validate(recruitmentId)).thenReturn(new RecruitmentEntity());
        recruitmentService.remove(recruitmentId);
        verify(recruitmentValidator, times(1)).validate(recruitmentId);
        verify(recruitmentRepository, times(1)).deleteById(recruitmentId);
    }

    @Test
    @DisplayName("[RecruitmentServiceTest][getAllRecruitments][Success]")
    public void getAllRecruitments() {
        Long recruitmentId = 1L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String technology = "Django";
        String name = "원티드랩";
        String country = "한국";
        String region = "서울";

        Long recruitmentId2 = 2L;
        BigDecimal compensation2 = new BigDecimal("1500000");
        String position2 = "백엔드 주니어 개발자";
        String technology2 = "Spring";
        String name2 = "네이버";
        String region2 = "판교";

        Long recruitmentId3 = 3L;
        String position3 = "프론트 주니어 개발자";
        String technology3 = "React";

        RecruitmentResponseModel model1 = RecruitmentResponseModel.builder()
                .recruitmentId(recruitmentId)
                .name(name)
                .country(country)
                .region(region)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .build();

        RecruitmentResponseModel model2 = RecruitmentResponseModel.builder()
                .recruitmentId(recruitmentId2)
                .name(name2)
                .country(country)
                .region(region2)
                .position(position2)
                .compensation(compensation2)
                .technology(technology2)
                .build();

        RecruitmentResponseModel model3 = RecruitmentResponseModel.builder()
                .recruitmentId(recruitmentId3)
                .name(name)
                .country(country)
                .region(region)
                .position(position3)
                .compensation(compensation)
                .technology(technology3)
                .build();

        List<RecruitmentResponseModel> list = Arrays.asList(model1, model2, model3);

        when(recruitmentRepository.selectAllRecruitments()).thenReturn(list);
        List<RecruitmentResponseModel> result = recruitmentService.getAllRecruitments();
        assertSame(list, result);
    }

    @Test
    @DisplayName("[RecruitmentServiceTest][selectAllRecruitments][Success]")
    public void selectAllRecruitments() {
        Long recruitmentId = 1L;
        Long companyId = 3L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String technology = "Django";
        String name = "원티드랩";
        String country = "한국";
        String region = "서울";
        String contents = "원티드랩에서 백엔드 주니어 개발자를 채용합니다.";
        List<Long> recruitmentIds = Arrays.asList(5L, 6L, 7L);

        RecruitmentEntity recruitment = RecruitmentEntity.builder()
                .id(recruitmentId)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .companyId(companyId)
                .build();


        RecruitmentDetailResponseModel model = RecruitmentDetailResponseModel.builder()
                .recruitmentId(recruitmentId)
                .compensation(compensation)
                .technology(technology)
                .position(position)
                .name(name)
                .country(country)
                .region(region)
                .recruitmentIds(recruitmentIds)
                .build();

        CompanyEntity company = CompanyEntity.builder()
                .id(companyId)
                .name(name)
                .country(country)
                .region(region)
                .build();

        when(recruitmentRepository.findById(anyLong())).thenReturn(Optional.of(recruitment));
        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));
        when(recruitmentRepository.selectAllRecruitments(anyLong(), anyLong())).thenReturn(recruitmentIds);
        when(recruitmentConverter.convert(any(RecruitmentEntity.class), any(CompanyEntity.class), anyList()))
                .thenReturn(model);

        RecruitmentDetailResponseModel result = recruitmentService.getRecruitment(recruitmentId);

        verify(recruitmentRepository, times(1)).findById(recruitmentId);
        verify(companyRepository, times(1)).findById(companyId);
        verify(recruitmentRepository, times(1)).selectAllRecruitments(recruitmentId, companyId);
        verify(recruitmentConverter, times(1)).convert(recruitment, company, recruitmentIds);

        assertEquals(model.getRecruitmentId(), result.getRecruitmentId());
        assertEquals(model.getCompensation(), result.getCompensation());
        assertEquals(model.getTechnology(), result.getTechnology());
        assertEquals(model.getPosition(), result.getPosition());
        assertEquals(model.getName(), result.getName());
        assertEquals(model.getCountry(), result.getCountry());
        assertEquals(model.getRegion(), result.getRegion());
        assertEquals(model.getRecruitmentIds(), result.getRecruitmentIds());
    }

    @Test
    @DisplayName("[RecruitmentServiceTest][search][Success]")
    public void search() {
        String searchText = "Django";

        Long recruitmentId = 1L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String position2 = "Django 백엔드 개발자";
        String technology = "Django";
        String name = "원티드랩";
        String country = "한국";
        String region = "서울";

        RecruitmentResponseModel recruitment = RecruitmentResponseModel.builder()
                .recruitmentId(recruitmentId)
                .name(name)
                .country(country)
                .region(region)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .build();

        RecruitmentResponseModel recruitment2 = RecruitmentResponseModel.builder()
                .recruitmentId(recruitmentId)
                .name(name)
                .country(country)
                .region(region)
                .position(position2)
                .compensation(compensation)
                .technology(technology)
                .build();

        List<RecruitmentResponseModel> list = List.of(recruitment, recruitment2);
        when(recruitmentRepository.selectAllRecruitments(searchText)).thenReturn(list);
        List<RecruitmentResponseModel> result = recruitmentService.search(searchText);
        verify(recruitmentRepository, times(1)).selectAllRecruitments(searchText);
        assertSame(list, result);
    }


    @Test
    @DisplayName("[RecruitmentServiceTest][apply][Success]")
    public void apply() {
        Long id = 32L;
        Long recruitId = 77L;
        String userId = "test";
        Long recruitmentId = 1L;
        Long companyId = 3L;
        BigDecimal compensation = new BigDecimal("1000000");
        String position = "백엔드 주니어 개발자";
        String technology = "Django";
        String contents = "원티드랩에서 백엔드 주니어 개발자를 채용합니다.";

        RecruitmentEntity recruitment = RecruitmentEntity.builder()
                .id(recruitmentId)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .companyId(companyId)
                .build();

        JobApplicationsEntity entity = JobApplicationsEntity.builder()
                .recruitmentId(recruitId)
                .userId(userId)
                .build();


        JobApplicationsEntity jobApplications = JobApplicationsEntity.builder()
                .id(id)
                .recruitmentId(recruitId)
                .userId(userId)
                .build();

        doNothing().when(userValidator).validate(anyString());
        doNothing().when(jobApplicationValidator).validate(anyString());
        when(recruitmentValidator.validate(anyLong())).thenReturn(recruitment);
        when(recruitmentConverter.convert(anyLong(), anyString())).thenReturn(entity);
        when(jobApplicationsRepository.save(any(JobApplicationsEntity.class))).thenReturn(jobApplications);

        recruitmentService.apply(recruitId, userId);

        assertNotNull(jobApplications);
        assertEquals(id, jobApplications.getId());
        assertEquals(recruitId, jobApplications.getRecruitmentId());
        assertEquals(userId, jobApplications.getUserId());

        verify(userValidator, times(1)).validate(userId);
        verify(recruitmentValidator, times(1)).validate(recruitId);
        verify(jobApplicationValidator, times(1)).validate(userId);
        verify(recruitmentConverter, times(1)).convert(recruitId, userId);
        verify(jobApplicationsRepository, times(1)).save(entity);
    }
}