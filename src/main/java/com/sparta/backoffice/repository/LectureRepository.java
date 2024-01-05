package com.sparta.backoffice.repository;

import com.sparta.backoffice.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findByInstructorId(Long InstructorId);
}
