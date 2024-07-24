package com.wanted.recruitment.persistence.repository;

import com.wanted.core.config.DefaultJpaRepository;
import com.wanted.recruitment.persistence.repository.entity.JobApplicationsEntity;

public interface JobApplicationsRepository extends DefaultJpaRepository<JobApplicationsEntity, Long> {
    boolean existsByUserId(String userId);
}
