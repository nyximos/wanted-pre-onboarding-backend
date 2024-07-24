package com.wanted.recruitment.service;

import com.wanted.core.exception.CompanyNotFoundException;
import com.wanted.core.exception.RecruitmentNotFoundException;
import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.request.RecruitmentUpdateRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;
import com.wanted.recruitment.converter.RecruitmentConverter;
import com.wanted.recruitment.persistence.repository.CompanyRepository;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.CompanyEntity;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import com.wanted.recruitment.service.validate.CompanyValidator;
import com.wanted.recruitment.service.validate.RecruitmentValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final CompanyRepository companyRepository;
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

    @Transactional
    public void remove(Long id) {
        recruitmentValidator.validate(id);
        recruitmentRepository.deleteById(id);
    }

    public List<RecruitmentResponseModel> getAllRecruitments() {
        return recruitmentRepository.selectAllRecruitments();
    }

    public RecruitmentDetailResponseModel getRecruitment(Long id) {
        RecruitmentEntity recruitment = recruitmentRepository.findById(id).orElseThrow(RecruitmentNotFoundException::new);
        CompanyEntity company = companyRepository.findById(recruitment.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        List<Long> recruitmentIds = recruitmentRepository.selectAllRecruitments(recruitment.getId(), company.getId());
        return recruitmentConverter.convert(recruitment, company, recruitmentIds);
    }
}
