package com.sparta.backoffice.repository;

import com.sparta.backoffice.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
