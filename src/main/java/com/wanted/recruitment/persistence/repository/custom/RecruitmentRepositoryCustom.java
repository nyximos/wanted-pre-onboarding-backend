package com.wanted.recruitment.persistence.repository.custom;

import com.wanted.recruitment.controller.model.response.RecruitmentResponseModel;

import java.util.List;

public interface RecruitmentRepositoryCustom {
    List<RecruitmentResponseModel> selectAllRecruitments();

    List<Long> selectAllRecruitments(Long id, Long companyId);
}
