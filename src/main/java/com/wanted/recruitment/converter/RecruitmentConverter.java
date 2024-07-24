package com.wanted.recruitment.converter;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.controller.model.response.RecruitmentDetailResponseModel;
import com.wanted.recruitment.persistence.repository.entity.CompanyEntity;
import com.wanted.recruitment.persistence.repository.entity.JobApplicationsEntity;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecruitmentConverter {

    @Mapping(target = "id", ignore = true)
    RecruitmentEntity convert(RecruitmentRequestModel source);

    @Mapping(target = "recruitmentId", source = "recruitment.id")
    RecruitmentDetailResponseModel convert(RecruitmentEntity recruitment, CompanyEntity company, List<Long> recruitmentIds);

    @Mapping(target = "id", ignore = true)
    JobApplicationsEntity convert(Long recruitmentId, String userId);
}
