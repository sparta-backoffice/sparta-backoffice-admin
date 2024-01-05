package com.sparta.backoffice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name ="lecture")
public class Lecture extends AuditingFields {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lecture_id")
	private Long lectureId;

	@Column(name = "lecture_name")
	private String lectureName;

	@Column(name = "price")
	private int price;

	@Column(name = "introduction")
	private String introduction;

	@Column(name = "category")
	private String category;

	@Column(name = "register_at")
	private LocalDate registerAt;



}
