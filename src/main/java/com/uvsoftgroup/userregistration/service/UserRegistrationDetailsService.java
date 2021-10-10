package com.uvsoftgroup.userregistration.service;

import com.uvsoftgroup.userregistration.model.UserRegistrationDetails;
import com.uvsoftgroup.userregistration.model.UserRole;

public interface UserRegistrationDetailsService {
    UserRegistrationDetails createUserRegistrationDetails(Long userRegistrationId, UserRegistrationDetails urd);
}
