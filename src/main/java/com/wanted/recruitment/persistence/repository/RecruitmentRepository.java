package com.wanted.recruitment.persistence.repository;

import com.wanted.core.config.DefaultJpaRepository;
import com.wanted.recruitment.persistence.repository.custom.RecruitmentRepositoryCustom;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;

public interface RecruitmentRepository extends DefaultJpaRepository<RecruitmentEntity, Long>, RecruitmentRepositoryCustom {
}
