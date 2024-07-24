package com.wanted.recruitment.converter;

import com.wanted.recruitment.controller.model.request.RecruitmentRequestModel;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecruitmentConverter {

    @Mapping(target = "id", ignore = true)
    RecruitmentEntity convert(RecruitmentRequestModel source);
}
