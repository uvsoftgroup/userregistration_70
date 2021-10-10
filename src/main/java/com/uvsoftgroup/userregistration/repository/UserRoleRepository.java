package com.uvsoftgroup.userregistration.repository;

import com.uvsoftgroup.userregistration.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
    Page<UserRole> findById(Long id, Pageable pageable);
    Optional<UserRole> findByIdAndUserRegistrationId(Long userRoleId, Long id);
    Page<UserRole> findByUserRegistrationId(Long userRegistrationId, Pageable pageable);

}
