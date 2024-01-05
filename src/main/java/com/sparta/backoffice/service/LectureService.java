package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.LectureDto;
import com.sparta.backoffice.domain.entity.Lecture;
import com.sparta.backoffice.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {

	private final LectureRepository lectureRepository;

	public LectureDto createLecture(LectureDto lectureDto) {
		Lecture lecture = Lecture.builder()
				.lectureName(lectureDto.getLectureName())
				.price(lectureDto.getPrice())
				.introduction(lectureDto.getIntroduction())
				.category(lectureDto.getCategory())
				.registerAt(lectureDto.getRegisterAt())
				.build();

		Lecture saveLecture = lectureRepository.save(lecture);
		return new LectureDto(saveLecture);
	}

	public LectureDto modifyLecture(Long id, LectureDto lectureDto) {
		Optional<Lecture> findLecture = lectureRepository.findById(id);
		if (findLecture.isPresent()) {
			Lecture lecture = findLecture.get();
			lecture.setLectureName(lectureDto.getLectureName());
			lecture.setPrice(lectureDto.getPrice());
			lecture.setIntroduction(lectureDto.getIntroduction());
			lecture.setCategory(lectureDto.getCategory());
			Lecture updateLecture = lectureRepository.save(lecture);
			return new LectureDto(updateLecture);
		}
		throw new EntityNotFoundException("강의 정보가 없습니다.");
	}
}
