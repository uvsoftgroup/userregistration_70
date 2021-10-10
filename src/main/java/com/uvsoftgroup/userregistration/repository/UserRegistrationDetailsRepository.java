package com.uvsoftgroup.userregistration.repository;

import com.uvsoftgroup.userregistration.model.UserRegistrationDetails;
import com.uvsoftgroup.userregistration.model.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRegistrationDetailsRepository extends PagingAndSortingRepository<UserRegistrationDetails, Long> {
}
