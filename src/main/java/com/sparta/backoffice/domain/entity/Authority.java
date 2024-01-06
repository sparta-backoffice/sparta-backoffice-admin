package com.sparta.backoffice.domain.entity;

import lombok.Getter;

@Getter
public enum Authority {

    MANAGER(AdminAuthority.MANAGER),
    STAFF(AdminAuthority.STAFF);

    private final String authority;

    Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class AdminAuthority {
        public static final String STAFF = "ROLE_USER";
        public static final String MANAGER = "ROLE_ADMIN";
    }

}
