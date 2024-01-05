package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.LectureDto;
import com.sparta.backoffice.domain.entity.Lecture;
import com.sparta.backoffice.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

	private final LectureRepository lectureRepository;

	@Transactional
	public LectureDto createLecture(LectureDto lectureDto) {
		Lecture lecture = Lecture.builder()
				.lectureName(lectureDto.getLectureName())
				.price(lectureDto.getPrice())
				.introduction(lectureDto.getIntroduction())
				.category(lectureDto.getCategory())
				.build();

		Lecture saveLecture = lectureRepository.save(lecture);
		return new LectureDto(saveLecture);
	}

	@Transactional
	public LectureDto getLecture(Long id) {
		Lecture lecture = lectureRepository.findById(id).orElseThrow();
		return new LectureDto(lecture);
	}

	@Transactional
	public List<LectureDto> getLectureByCategory(String category) {
		List<Lecture> lectures = lectureRepository.findByCategoryOrderByRegisterAtDesc(category);
		return lectures.stream()
				.map(LectureDto::new)
				.collect(Collectors.toList());
	}

	@Transactional
	public LectureDto modifyLecture(Long id, LectureDto lectureDto) {
		Lecture findLecture = lectureRepository.findById(id).orElseThrow();
		findLecture.setLectureName(lectureDto.getLectureName());
		findLecture.setPrice(lectureDto.getPrice());
		findLecture.setIntroduction(lectureDto.getIntroduction());
		findLecture.setCategory(lectureDto.getCategory());
		return new LectureDto(findLecture);
	}

	public List<LectureDto> getLectureListByInstructorId(Long InstructorId) {
		List<Lecture> lectureList = lectureRepository.findByInstructorId(InstructorId);
		return lectureList.stream().map(LectureDto::new).toList();
	}
}
