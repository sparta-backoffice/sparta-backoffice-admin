package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.LectureDto;
import com.sparta.backoffice.domain.entity.Lecture;
import com.sparta.backoffice.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
