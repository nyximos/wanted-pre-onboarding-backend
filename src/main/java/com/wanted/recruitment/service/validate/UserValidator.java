package com.wanted.recruitment.service.validate;

import com.wanted.core.exception.UserNotFoundException;
import com.wanted.recruitment.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidator {
    
    private final UserRepository userRepository;
    
    public void validate(String id) {
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
