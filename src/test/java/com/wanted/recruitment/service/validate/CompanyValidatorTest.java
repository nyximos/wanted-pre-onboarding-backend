package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.CompanyNotFoundException;
import com.wanted.recruitment.persistence.repository.CompanyRepository;
import com.wanted.recruitment.persistence.repository.entity.CompanyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyValidatorTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyValidator companyValidator;

    @Test
    @DisplayName("[CompanyValidator][validate][Success]")
    public void validateSuccess() {
        Long companyId = 1L;
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new CompanyEntity()));
        companyValidator.validate(companyId);
    }

    @Test
    @DisplayName("[CompanyValidator][validate][CompanyNotFoundException]")
    public void validateFailure() {
        Long companyId = 8888L;
        when(companyRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(CompanyNotFoundException.class, () -> {
            companyValidator.validate(companyId);
        });
    }
}