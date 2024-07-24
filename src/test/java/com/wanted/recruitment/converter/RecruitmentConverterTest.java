package com.wanted.recruitment.converter;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.persistence.repository.entity.CompanyEntity;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RecruitmentConverterImpl.class})
class RecruitmentConverterTest {

    @Autowired
    private RecruitmentConverter recruitmentConverter;

    @Test
    @DisplayName("[RecruitmentConverter][convert][Success]")
    void convertTest() {
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

        RecruitmentEntity result = recruitmentConverter.convert(model);
        assertNull(result.getId());
        assertEquals(position, result.getPosition());
        assertEquals(compensation, result.getCompensation());
        assertEquals(technology, result.getTechnology());
        assertEquals(contents, result.getContents());
    }

    @Test
    @DisplayName("[RecruitmentConverter][convert][Success]")
    void convertDetailTest() {
        long recruitmentId = 1L;
        long companyId = 3L;
        String position = "백엔드 주니어 개발자";
        BigDecimal compensation = new BigDecimal("1000000");
        String technology = "Spring";
        String contents = "원티드랩에서 백엔드 주니어 개발자를 채용합니다.";
        String name = "원티드랩";
        String country = "서울";
        String region = "한국";

        RecruitmentEntity recruitment = RecruitmentEntity.builder()
                .id(recruitmentId)
                .position(position)
                .compensation(compensation)
                .technology(technology)
                .contents(contents)
                .build();

        CompanyEntity company = CompanyEntity.builder()
                .id(companyId)
                .name(name)
                .country(country)
                .region(region)
                .build();

        List<Long> recruitmentIds = Arrays.asList(5L, 6L, 7L);

        RecruitmentDetailResponseModel result = recruitmentConverter.convert(recruitment, company, recruitmentIds);

        assertEquals(recruitmentId, result.getRecruitmentId());
        assertEquals(name, result.getName());
        assertEquals(country, result.getCountry());
        assertEquals(region, result.getRegion());
        assertEquals(position, result.getPosition());
        assertEquals(compensation.longValue(), result.getCompensation());
        assertEquals(technology, result.getTechnology());
        assertEquals(contents, result.getContents());
        assertEquals(recruitmentIds, result.getRecruitmentIds());
    }
}