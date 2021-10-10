package com.uvsoftgroup.userregistration.controller;

import com.uvsoftgroup.userregistration.config.ConfigurationTags;
import com.uvsoftgroup.userregistration.model.UserRole;
import com.uvsoftgroup.userregistration.service.UserRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/userRole")
@Tag(name = ConfigurationTags.USER_ROLE_TAG, description = ConfigurationTags.USER_ROLE_DES)
public class UserRoleController {
    private @Autowired UserRoleService userRoleService;

    @GetMapping("/getAllUserRole")
    public Page<UserRole> getAllUserRole(Pageable pageable) {

        return userRoleService.getAllUserRole(pageable);
    }

    @GetMapping("/getAllUserRoleByContent")
    public List<UserRole> getAllUserRoleByContent(Pageable pageable) {
        return userRoleService.getAllUserRoleByContent(pageable);
    }

    @PostMapping("/createUserRole/{userRegistrationId}/userRole")
    public UserRole createUserRole(@PathVariable(value = "userRegistrationId") Long userRegistrationId,
                                 @Valid @RequestBody UserRole userRole) {
        return userRoleService.createUserRole(userRegistrationId, userRole);
    }

    @PutMapping("/updateUserRole/{userRegistrationId}/userRole/{userRoleId}")
    public UserRole updateUserRole(@PathVariable (value = "userRegistrationId") Long userRegistrationId,
                                 @PathVariable (value = "userRoleId") Long userRoleId,
                                 @Valid @RequestBody UserRole userRole) {
         return userRoleService.updateUserRole(userRegistrationId, userRoleId,userRole);
    }

    @DeleteMapping("/deleteUserRole/{userRegistrationId}/userRole/{userRoleId}")
    public ResponseEntity<?> deleteUserRole(@PathVariable (value = "userRegistrationId") Long userRegistrationId,
                                           @PathVariable (value = "userRoleId") Long userRoleId) {
        return userRoleService.deleteUserRole(userRegistrationId, userRoleId);
    }

    @DeleteMapping("/deleteUserRoleById/{userRoleId}")
    public ResponseEntity<?> deleteUserRoleById(@PathVariable (value = "userRoleId") Long userRoleId) {
        return userRoleService.deleteUserRoleById(userRoleId);
    }

}
