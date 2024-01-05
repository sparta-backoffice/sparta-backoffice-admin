package com.sparta.backoffice.repository;

import com.sparta.backoffice.domain.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
	List<Lecture> findByCategoryOrderByRegisterAtDesc(String category);

    List<Lecture> findByInstructorId(Long InstructorId);
}
