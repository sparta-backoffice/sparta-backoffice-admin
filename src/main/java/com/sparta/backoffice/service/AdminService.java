package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.AdminDto;
import com.sparta.backoffice.domain.entity.Admin;
import com.sparta.backoffice.domain.entity.Authority;
import com.sparta.backoffice.domain.entity.Department;
import com.sparta.backoffice.repository.AdminRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional
    public void createAdmin(@Valid AdminDto requestDto) {

        Admin admin = Admin.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .department(requestDto.getDepartment())
                .authority(requestDto.getAuthority())
                .build();
        adminRepository.save(admin);
    }
}
