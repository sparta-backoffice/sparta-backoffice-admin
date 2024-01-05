package com.sparta.backoffice.domain.dto;

import com.sparta.backoffice.domain.entity.Admin;
import com.sparta.backoffice.domain.entity.Authority;
import com.sparta.backoffice.domain.entity.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdminDto {

    private Long id;

    @Email
    private String email;

    @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하이어야 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "알파벳 대소문자, 숫자, 특수문자를 포함해야 합니다.")
    private String password;
    private Department department;
    private Authority authority;

    public AdminDto(Admin entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.department = entity.getDepartment();
        this.authority = entity.getAuthority();
    }
}
