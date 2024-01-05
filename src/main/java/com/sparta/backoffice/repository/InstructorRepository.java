package com.sparta.backoffice.repository;

import com.sparta.backoffice.domain.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
