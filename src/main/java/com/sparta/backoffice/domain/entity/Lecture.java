package com.sparta.backoffice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

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
	@Setter(AccessLevel.NONE)
	@Column(name = "lecture_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="instructor_id")
	private Instructor instructor;

	@Column(name = "lecture_name")
	private String lectureName;

	@Column(name = "price")
	private int price;

	@Column(name = "introduction")
	private String introduction;

	@Column(name = "category")
	private String category;
}
