package com.uvsoftgroup.userregistration.serviceimpl;

import com.uvsoftgroup.userregistration.exception.ResourceNotFoundException;
import com.uvsoftgroup.userregistration.model.UserRegistration;
import com.uvsoftgroup.userregistration.repository.UserRegistrationRepository;
import com.uvsoftgroup.userregistration.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private @Autowired UserRegistrationRepository userRegistrationRepository;

    @Override
    public Page<UserRegistration> getAllUserRegistration(Pageable pageable){
        return userRegistrationRepository.findAll(pageable);
    }
    @Override
    public List<UserRegistration> getAllUserRegistrationByContent(Pageable pageable){
        Page<UserRegistration> pList=userRegistrationRepository.findAll(pageable);
        return pList.getContent();
    }


    @Override
    public UserRegistration createUserRegistration(UserRegistration userRegistration) {
        return userRegistrationRepository.save(userRegistration);
    }
    @Override
    public UserRegistration updateUserRegistration(Long userRegistrationId, UserRegistration userRegistrationRequest) {
        return userRegistrationRepository.findById(userRegistrationId).map(userRegistration -> {
            userRegistration.setUserAddressId(userRegistrationRequest.getUserAddressId());
            userRegistration.setUserMail(userRegistrationRequest.getUserMail());
            userRegistration.setUserMobileNr(userRegistrationRequest.getUserMobileNr());
            userRegistration.setUserPhoneNr(userRegistrationRequest.getUserPhoneNr());
            userRegistration.setUserRegistrationFName(userRegistrationRequest.getUserRegistrationFName());
            userRegistration.setUserRegistrationLName(userRegistrationRequest.getUserRegistrationLName());
            userRegistration.setUserRegistrationMName(userRegistrationRequest.getUserRegistrationMName());
            userRegistration.setUserRegistrationName(userRegistrationRequest.getUserRegistrationName());
            userRegistration.setUserRegistrationPassword(userRegistrationRequest.getUserRegistrationPassword());
            userRegistration.setUserWww(userRegistrationRequest.getUserWww());

            return userRegistrationRepository.save(userRegistration);
        }).orElseThrow(() -> new ResourceNotFoundException("UserRegistrationId " + userRegistrationId + " not found"));
    }

    @Override
    public ResponseEntity<?> deleteUserRegistration(Long userRegistrationId) {
        return userRegistrationRepository.findById(userRegistrationId).map(userRegistration -> {
            userRegistrationRepository.delete(userRegistration);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserRegistrationId " + userRegistrationId + " not found"));
    }


    private UserRegistration setUserRegistration(UserRegistration userRegistrationRequest){
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setUserAddressId(userRegistrationRequest.getUserAddressId());
        userRegistration.setUserMail(userRegistrationRequest.getUserMail());
        userRegistration.setUserMobileNr(userRegistrationRequest.getUserMobileNr());
        userRegistration.setUserPhoneNr(userRegistrationRequest.getUserPhoneNr());
        userRegistration.setUserRegistrationFName(userRegistrationRequest.getUserRegistrationFName());
        userRegistration.setUserRegistrationLName(userRegistrationRequest.getUserRegistrationLName());
        userRegistration.setUserRegistrationMName(userRegistrationRequest.getUserRegistrationMName());
        userRegistration.setUserRegistrationName(userRegistrationRequest.getUserRegistrationName());
        userRegistration.setUserRegistrationPassword(userRegistrationRequest.getUserRegistrationPassword());
        userRegistration.setUserWww(userRegistrationRequest.getUserWww());
        return userRegistration;
    }

}
