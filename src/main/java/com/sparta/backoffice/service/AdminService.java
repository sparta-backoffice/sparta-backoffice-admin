package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.AdminDto;
import com.sparta.backoffice.domain.entity.Admin;
import com.sparta.backoffice.domain.entity.Authority;
import com.sparta.backoffice.domain.entity.Department;
import com.sparta.backoffice.repository.AdminRepository;
import com.sparta.backoffice.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtUtil jwtUtil;
    @Transactional
    public void createAdmin(@Valid AdminDto requestDto) {
        Authority authority = requestDto.getAuthority();
        Department department = requestDto.getDepartment();

        if (Department.MARKETING.equals(department) && Authority.MANAGER.equals(authority)) {
            requestDto.setAuthority(Authority.STAFF);
        }

        Admin admin = Admin.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .department(requestDto.getDepartment())
                .authority(requestDto.getAuthority())
                .build();
        adminRepository.save(admin);
    }

    public void login(AdminDto requestDto, HttpServletResponse response) {

        String adminEmail = requestDto.getEmail();
        Admin admin = adminRepository.findByEmail(adminEmail).orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다."));
        String token = jwtUtil.createToken(admin.getEmail(), admin.getAuthority());

        jwtUtil.addJwtToCookie(token,response);
    }
}
