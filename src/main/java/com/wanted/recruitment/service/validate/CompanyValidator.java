package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.CompanyNotFoundException;
import com.wanted.recruitment.persistence.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyValidator {
    
    private final CompanyRepository companyRepository;
    
    public void validate(Long id) {
        companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }
}
