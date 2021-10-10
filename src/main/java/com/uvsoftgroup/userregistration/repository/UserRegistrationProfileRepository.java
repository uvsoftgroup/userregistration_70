package com.uvsoftgroup.userregistration.repository;

import com.uvsoftgroup.userregistration.model.UserRegistrationProfile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRegistrationProfileRepository extends PagingAndSortingRepository<UserRegistrationProfile,Long> {
}
