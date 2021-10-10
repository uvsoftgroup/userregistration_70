package com.uvsoftgroup.userregistration.service;

import com.uvsoftgroup.userregistration.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRoleService {
    Page<UserRole> getAllUserRole(Pageable pageable);
    List<UserRole> getAllUserRoleByContent(Pageable pageable);
    UserRole createUserRole(Long userRegistrationId, UserRole userRole);
    Page<UserRole> getAllUserRoleByUserRegistrationId(Long userRegistrationId,
                                                      Pageable pageable);
    UserRole updateUserRole(Long userRegistrationId, Long userRoleId,
                            UserRole userRoleRequest);
    ResponseEntity<?> deleteUserRole(Long userRegistrationId, Long userRoleId);
    ResponseEntity<?> deleteUserRoleById(Long userRoleId);

}
