package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.InstructorDto;
import com.sparta.backoffice.domain.entity.Instructor;
import com.sparta.backoffice.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    public InstructorDto creteInstructor(InstructorDto requestDto) {
        Instructor instructor = Instructor.builder()
                .instructorName(requestDto.getInstructorName())
                .career(requestDto.getCareer())
                .company(requestDto.getCompany())
                .phoneNumber(requestDto.getPhoneNumber())
                .introduction(requestDto.getPhoneNumber())
                .build();

        return new InstructorDto(instructorRepository.save(instructor));
    }
}
