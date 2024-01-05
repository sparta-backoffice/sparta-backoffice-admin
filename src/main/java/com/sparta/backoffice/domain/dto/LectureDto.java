package com.sparta.backoffice.domain.dto;

import com.sparta.backoffice.domain.entity.Lecture;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LectureDto {
	private String lectureName;
	private Integer price;
	private String introduction;
	private String category;
	private LocalDate registerAt;
	private Long instructorId;


	public LectureDto(Lecture entity) {
		this.lectureName = entity.getLectureName();
		this.price = entity.getPrice();
		this.introduction = entity.getIntroduction();
		this.category = entity.getCategory();
		this.registerAt = entity.getCreateAt();
		this.instructorId = entity.getInstructor().getId();
	}
}
