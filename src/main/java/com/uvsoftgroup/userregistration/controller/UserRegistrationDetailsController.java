package com.uvsoftgroup.userregistration.controller;

import com.uvsoftgroup.userregistration.config.ConfigurationTags;
import com.uvsoftgroup.userregistration.model.UserRegistrationDetails;
import com.uvsoftgroup.userregistration.model.UserRole;
import com.uvsoftgroup.userregistration.service.UserRegistrationDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/urd")
@Tag(name = ConfigurationTags.USER_REGISTRATION_PROFILE_TAG,
        description =ConfigurationTags.USER_REGISTRATION_PROFILE_DES)
public class UserRegistrationDetailsController {
    private @Autowired
    UserRegistrationDetailsService userRegistrationDetailsService;

    @PostMapping("/createUserRegistrationDetails/{userRegistrationId}/userRegistrationDetails")
    public UserRegistrationDetails createUserRegistrationDetails(@PathVariable(value = "userRegistrationId") Long userRegistrationId,
                                                                 @Valid @RequestBody UserRegistrationDetails urd) {
        return userRegistrationDetailsService.createUserRegistrationDetails(userRegistrationId, urd);
    }


}
