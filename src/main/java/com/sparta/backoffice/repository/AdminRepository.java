package com.sparta.backoffice.repository;

import com.sparta.backoffice.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
