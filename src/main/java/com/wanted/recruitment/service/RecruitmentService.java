package com.wanted.recruitment.service;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.converter.RecruitmentConverter;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import com.wanted.recruitment.service.validate.CompanyValidator;
import com.wanted.recruitment.service.validate.RecruitmentValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final CompanyValidator companyValidator;
    private final RecruitmentValidator recruitmentValidator;
    private final RecruitmentConverter recruitmentConverter;
    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public void add(RecruitmentRequestModel recruitmentRequestModel) {
        companyValidator.validate(recruitmentRequestModel.getCompanyId());
        recruitmentRepository.save(recruitmentConverter.convert(recruitmentRequestModel));
    }

    @Transactional
    public void update(Long id, RecruitmentUpdateRequestModel recruitmentRequestModel) {
        RecruitmentEntity recruitment = recruitmentValidator.validate(id);
        recruitment.update(recruitmentRequestModel);
        recruitmentRepository.save(recruitment);
    }
}
