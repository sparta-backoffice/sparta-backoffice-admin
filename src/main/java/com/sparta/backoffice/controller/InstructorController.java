package com.sparta.backoffice.controller;

import com.sparta.backoffice.domain.dto.InstructorDto;
import com.sparta.backoffice.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto requestDto) {
         return new ResponseEntity<>(instructorService.creteInstructor(requestDto), HttpStatus.CREATED);
    }

}
