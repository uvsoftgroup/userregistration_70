package com.uvsoftgroup.userregistration;

import com.uvsoftgroup.userregistration.model.UserRegistration;
import com.uvsoftgroup.userregistration.model.UserRegistrationProfile;
import com.uvsoftgroup.userregistration.repository.UserRegistrationProfileRepository;
import com.uvsoftgroup.userregistration.repository.UserRegistrationRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRegistrationProfileTest {

    private @Autowired
    UserRegistrationProfileRepository userRegistrationProfileRepository;
    private @Autowired
    UserRegistrationRepository userRegistrationRepository;

    @Test
    @Ignore
    public void saveUserRegistrationProfile() {
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setUserRegistrationName("testing");

        UserRegistrationProfile userRegistrationProfile= new UserRegistrationProfile();

        userRegistrationProfile.setCity("KA");
        // Set child reference(UserRegistrationProfile) in parent entity(UserRegistration)
        userRegistration.setUserRegistrationProfile(userRegistrationProfile);

        // Set parent reference(UserRegistration) in child entity(UserRegistrationProfile)
        userRegistrationProfile.setUserRegistration(userRegistration);

        // Save Parent Reference (which will save the child as well)
        userRegistrationRepository.save(userRegistration);



    }

}
