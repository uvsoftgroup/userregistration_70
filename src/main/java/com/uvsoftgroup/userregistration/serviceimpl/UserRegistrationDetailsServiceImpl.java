package com.uvsoftgroup.userregistration.serviceimpl;

import com.uvsoftgroup.userregistration.exception.ResourceNotFoundException;
import com.uvsoftgroup.userregistration.model.UserRegistrationDetails;
import com.uvsoftgroup.userregistration.repository.UserRegistrationDetailsRepository;
import com.uvsoftgroup.userregistration.repository.UserRegistrationRepository;
import com.uvsoftgroup.userregistration.service.UserRegistrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDetailsServiceImpl implements UserRegistrationDetailsService {
    private @Autowired
    UserRegistrationRepository userRegistrationRepository;
    private @Autowired
    UserRegistrationDetailsRepository userRegistrationDetailsRepository;
    @Override
    public UserRegistrationDetails createUserRegistrationDetails(Long userRegistrationId, UserRegistrationDetails urd) {
        return userRegistrationRepository.findById(userRegistrationId).map(userRegistration -> {
            urd.setUserRegistration(userRegistration);
            return userRegistrationDetailsRepository.save(urd);
        }).orElseThrow(() -> new ResourceNotFoundException("UserRegistrationId " + userRegistrationId + " not found"));
    }
}
