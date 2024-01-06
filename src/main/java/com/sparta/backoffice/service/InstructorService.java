package com.sparta.backoffice.service;

import com.sparta.backoffice.domain.dto.InstructorDto;
import com.sparta.backoffice.domain.entity.Admin;
import com.sparta.backoffice.domain.entity.Authority;
import com.sparta.backoffice.domain.entity.Instructor;
import com.sparta.backoffice.repository.InstructorRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public InstructorDto modifyInstructor(InstructorDto requestDto, HttpServletRequest request) {

        Admin admin = (Admin) request.getAttribute("admin");
        if (admin.getAuthority() != Authority.MANAGER) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only managers are allowed to modify instructors.");
        }

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
