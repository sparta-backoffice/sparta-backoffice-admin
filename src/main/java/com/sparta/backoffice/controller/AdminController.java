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
    private final JwtUtil jwtUtil;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody AdminDto requestDto) {
        adminService.createAdmin(requestDto);
    }

    @GetMapping("/create-jwt")
    public String createJwt(HttpServletResponse res) {
        // Jwt 생성
        String token = jwtUtil.createToken("Robbie", Authority.MANAGER);

        // Jwt 쿠키 저장
        jwtUtil.addJwtToCookie(token, res);

        return "createJwt : " + token;
    }

    @GetMapping("/get-jwt")
    public String getJwt(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {
        // JWT 토큰 substring
        String token = jwtUtil.substringToken(tokenValue);

        // 토큰 검증
        if (!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        // 토큰에서 사용자 정보 가져오기
        Claims info = jwtUtil.getUserInfoFromToken(token);
        // 사용자 username
        String username = info.getSubject();
        System.out.println("username = " + username);
        // 사용자 권한
        String authority = (String) info.get(JwtUtil.AUTHORIZATION_KEY);
        System.out.println("authority = " + authority);

        return "getJwt : " + username + ", " + authority;
    }

    @PostMapping("/sign")
    public String login(@RequestBody AdminDto requestDto, HttpServletResponse response) {
        try {
            adminService.login(requestDto, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/";
    }

    @GetMapping("/products")
    public String getProducts(HttpServletRequest req) {
        System.out.println("ProductController.getProducts : 인증 완료");
        Admin admin = (Admin) req.getAttribute("admin");
        System.out.println("user.getEmail() = " + admin.getAuthority());

        return "redirect:/";
    }
}

