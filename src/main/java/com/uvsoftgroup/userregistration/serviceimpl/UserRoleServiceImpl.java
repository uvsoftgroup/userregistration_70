package com.uvsoftgroup.userregistration.serviceimpl;

import com.uvsoftgroup.userregistration.exception.ResourceNotFoundException;
import com.uvsoftgroup.userregistration.model.UserRole;
import com.uvsoftgroup.userregistration.repository.UserRegistrationRepository;
import com.uvsoftgroup.userregistration.repository.UserRoleRepository;
import com.uvsoftgroup.userregistration.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private @Autowired UserRoleRepository userRoleRepository;
    private @Autowired UserRegistrationRepository userRegistrationRepository;

    /**
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<UserRole> getAllUserRole(Pageable pageable){
        return userRoleRepository.findAll(pageable);
    }

    /**
     *
     * @param pageable
     * @return
     */
    @Override
    public List<UserRole> getAllUserRoleByContent(Pageable pageable){
        Page<UserRole> pList=userRoleRepository.findAll(pageable);
        return pList.getContent();
    }

    /**
     *
     * @param userRegistrationId
     * @param pageable
     * @return
     */
    @Override
    public Page<UserRole> getAllUserRoleByUserRegistrationId(Long userRegistrationId,
                                                Pageable pageable) {
        return userRoleRepository.findByUserRegistrationId(userRegistrationId, pageable);
    }

    /**
     *
     * @param userRegistrationId
     * @param userRole
     * @return
     */
    @Override
    public UserRole createUserRole(Long userRegistrationId, UserRole userRole) {
        return userRegistrationRepository.findById(userRegistrationId).map(userRegistration -> {
            userRole.setUserRegistration(userRegistration);
            return userRoleRepository.save(userRole);
        }).orElseThrow(() -> new ResourceNotFoundException("UserRegistrationId " + userRegistrationId + " not found"));
    }

    /**
     *
     * @param userRegistrationId
     * @param userRoleId
     * @param userRoleRequest
     * @return
     */
    @Override
    public UserRole updateUserRole(Long userRegistrationId, Long userRoleId,
                                   UserRole userRoleRequest) {
        if(!userRegistrationRepository.existsById(userRegistrationId)) {
            throw new ResourceNotFoundException("UserRegistrationId " + userRegistrationId + " not found");
        }

        return userRoleRepository.findById(userRoleId).map(userRole -> {

            if(userRoleRequest.getUserRefNrId()!=null && userRoleRequest.getUserRefNrId()!=0) {
                userRole.setUserRefNrId(userRoleRequest.getUserRefNrId());
            }
            else{
                userRole.getUserRefNrId();
            }
            if(!userRoleRequest.getUserRoleName().isEmpty()) {
                userRole.setUserRoleName(userRoleRequest.getUserRoleName());
            }
            else{
                userRole.getUserRoleName();
            }
            if(!userRoleRequest.getUserRoleType().isEmpty()){
                userRole.setUserRoleType(userRoleRequest.getUserRoleType());
            }
            else{
                userRole.getUserRoleType();
            }
            return userRoleRepository.save(userRole);

        }).orElseThrow(() -> new ResourceNotFoundException("UserRoleId " + userRoleId + "not found"));
    }

    /**
     *
     * @param userRegistrationId
     * @param userRoleId
     * @return
     */
    @Override
    public ResponseEntity<?> deleteUserRole(Long userRegistrationId, Long userRoleId) {
        return userRoleRepository.findByIdAndUserRegistrationId(userRoleId, userRegistrationId).map(userRole -> {
            userRoleRepository.delete(userRole);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserRoleId not found with id " + userRoleId + " and UserRegistrationId " + userRegistrationId));
    }

    @Override
    public ResponseEntity<?> deleteUserRoleById(Long userRoleId) {
        return userRoleRepository.findById(userRoleId).map(userRole -> {
            userRoleRepository.delete(userRole);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserRoleId not found with id " + userRoleId));
    }

}
