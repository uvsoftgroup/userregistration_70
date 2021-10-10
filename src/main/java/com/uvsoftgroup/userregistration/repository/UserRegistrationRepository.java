package com.uvsoftgroup.userregistration.repository;

import com.uvsoftgroup.userregistration.model.UserRegistration;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRegistrationRepository extends PagingAndSortingRepository<UserRegistration, Long> {

}
