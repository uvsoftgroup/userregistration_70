package com.uvsoftgroup.userregistration.controller;

import com.uvsoftgroup.userregistration.config.ConfigurationTags;
import com.uvsoftgroup.userregistration.model.UserRegistration;
import com.uvsoftgroup.userregistration.service.UserRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/userRegistration")
@Tag(name = ConfigurationTags.USER_REGISTRATION_TAG,
        description =ConfigurationTags.USER_REGISTRATION_DES)
public class UserRegistrationController {
    private @Autowired
    UserRegistrationService userRegistrationService;

    @Operation(summary = "view a list of available registered user",description ="List of registered user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Successfully retrieved list"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/getAllUserRegistration")
    public Page<UserRegistration> getAllUserRegistration(Pageable pageable) {
        return userRegistrationService.getAllUserRegistration(pageable);
    }
    @GetMapping("/getAllUserRegistrationByContent")
    public List<UserRegistration> getAllUserRegistrationByContent(Pageable pageable) {
        return userRegistrationService.getAllUserRegistrationByContent(pageable);
    }

    @PostMapping("/createUserRegistration")
    public UserRegistration createUserRegistration(@Valid @RequestBody UserRegistration userRegistration) {
        return userRegistrationService.createUserRegistration(userRegistration);
    }

    @Operation(summary = "Update an existing registered user", description = "",
            tags = { "userregistration" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Contact not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @PutMapping("/updateUserRegistration/{userRegistrationId}")
    public UserRegistration updateUserRegistration(@PathVariable(name ="userRegistrationId", required =true) Long userRegistrationId, @Valid @RequestBody UserRegistration userRegistrationRequest) {
        return userRegistrationService.updateUserRegistration(userRegistrationId, userRegistrationRequest);
    }

    @DeleteMapping("/deleteUserRegistration/{userRegistrationId}")
    public ResponseEntity<?> deleteUserRegistration(@PathVariable(name ="userRegistrationId", required =true) Long userRegistrationId) {
        return userRegistrationService.deleteUserRegistration(userRegistrationId);
    }



}
