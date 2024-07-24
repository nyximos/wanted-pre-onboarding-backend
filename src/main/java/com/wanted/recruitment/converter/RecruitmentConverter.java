package com.wanted.recruitment.converter;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruitmentConverter {

    RecruitmentEntity convert(RecruitmentRequestModel source);
}
