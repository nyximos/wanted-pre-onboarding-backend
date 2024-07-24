package com.wanted.recruitment.persistence.repository;

import com.wanted.core.config.DefaultJpaRepository;
import com.wanted.recruitment.persistence.repository.entity.UserEntity;

public interface UserRepository extends DefaultJpaRepository<UserEntity, String> {
}
