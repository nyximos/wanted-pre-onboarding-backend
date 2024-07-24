package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.UserNotFoundException;
import com.wanted.recruitment.persistence.repository.UserRepository;
import com.wanted.recruitment.persistence.repository.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserValidator userValidator;

    @Test
    @DisplayName("[UserValidator][validate][Success]")
    public void validateSuccess() {
        String id = "test";
        when(userRepository.findById(id)).thenReturn(Optional.of(new UserEntity()));
        userValidator.validate(id);
    }

    @Test
    @DisplayName("[UserValidator][validate][Success]")
    public void validateFailure() {
        String id = "test";
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> {
            userValidator.validate(id);
        });
    }

}