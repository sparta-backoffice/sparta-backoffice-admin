package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.InstructorDto;
import com.sparta.backoffice.domain.entity.Instructor;
import com.sparta.backoffice.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Transactional
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

    @Transactional
    public InstructorDto modifyInstructor(InstructorDto requestDto) {
        Instructor instructor = instructorRepository.findById(requestDto.getInstructorId()).orElseThrow();
        instructor.setCareer(requestDto.getCareer());
        instructor.setCompany(requestDto.getCompany());
        instructor.setPhoneNumber(requestDto.getPhoneNumber());
        instructor.setIntroduction(requestDto.getIntroduction());

        return new InstructorDto(instructor);
    }

    public InstructorDto getInstructor(Long instructorId) {
        return new InstructorDto(instructorRepository.findById(instructorId).orElseThrow());
    }
}
