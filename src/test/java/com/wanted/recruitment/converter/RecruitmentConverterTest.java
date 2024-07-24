package com.wanted.recruitment.converter;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

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
}