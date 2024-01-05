package com.sparta.backoffice.domain.dto;

import com.sparta.backoffice.domain.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {

    private Long instructorId;
    private String instructorName;
    private String career;
    private String company;
    private String phoneNumber;
    private String introduction;

    public InstructorDto(Instructor entity) {
        this.instructorId = entity.getId();
        this.instructorName = entity.getInstructorName();
        this.career = entity.getCareer();
        this.company = entity.getCompany();
        this.phoneNumber = entity.getPhoneNumber();
        this.introduction = entity.getIntroduction();
    }
}
