package com.sparta.backoffice.controller;


import com.sparta.backoffice.domain.dto.AdminDto;
import com.sparta.backoffice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody AdminDto requestDto) {
        adminService.createAdmin(requestDto);
    }
}
