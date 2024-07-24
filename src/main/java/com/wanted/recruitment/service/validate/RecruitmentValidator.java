package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.RecruitmentNotFoundException;
import com.wanted.recruitment.persistence.repository.RecruitmentRepository;
import com.wanted.recruitment.persistence.repository.entity.RecruitmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentValidator {

    private final RecruitmentRepository recruitmentRepository;
    
    public RecruitmentEntity validate(Long id) {
        return recruitmentRepository.findById(id).orElseThrow(RecruitmentNotFoundException::new);
    }
}
