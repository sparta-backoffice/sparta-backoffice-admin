package com.sparta.backoffice.controller;

import com.sparta.backoffice.domain.dto.LectureDto;
import com.sparta.backoffice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {

	private final LectureService lectureService;
	@PostMapping("/")
	public ResponseEntity<LectureDto> createLecture(@RequestBody LectureDto lectureDto) {
		LectureDto lecture = lectureService.createLecture(lectureDto);
		return new ResponseEntity<>(lecture, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LectureDto> modifyLecture(@PathVariable Long id, @RequestBody LectureDto lectureDto) {
		LectureDto lecture = lectureService.modifyLecture(id, lectureDto);
		return new ResponseEntity<>(lecture, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LectureDto> getLecture(@PathVariable Long id) {
		LectureDto lecture = lectureService.getLecture(id);
		return new ResponseEntity<>(lecture, HttpStatus.OK);
	}

}
