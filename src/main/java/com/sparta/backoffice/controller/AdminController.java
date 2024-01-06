package com.sparta.backoffice.controller;


import com.sparta.backoffice.domain.dto.AdminDto;
import com.sparta.backoffice.domain.entity.Admin;
import com.sparta.backoffice.domain.entity.Authority;
import com.sparta.backoffice.service.AdminService;
import com.sparta.backoffice.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody AdminDto requestDto) {
        adminService.createAdmin(requestDto);
    }

    @PostMapping("/sign")
    public String login(@RequestBody AdminDto requestDto, HttpServletResponse response) {
        try {
            adminService.login(requestDto, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Ok";
    }
}

