package com.uvsoftgroup.userregistration.service;

import com.uvsoftgroup.userregistration.model.UserRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRegistrationService {
    UserRegistration createUserRegistration(UserRegistration userRegistration);
    Page<UserRegistration> getAllUserRegistration(Pageable pageable);
    List<UserRegistration> getAllUserRegistrationByContent(Pageable pageable);
    UserRegistration updateUserRegistration(Long userRegistrationId, UserRegistration userRegistrationRequest);
    ResponseEntity<?> deleteUserRegistration(Long userRegistrationId);
}
