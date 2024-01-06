package com.sparta.backoffice.controller;

import com.sparta.backoffice.domain.dto.InstructorDto;
import com.sparta.backoffice.service.InstructorService;
import com.sparta.backoffice.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto requestDto, HttpServletRequest request) {
        return new ResponseEntity<>(instructorService.creteInstructor(requestDto,request), HttpStatus.CREATED);
    }

    @PutMapping("/{instructorId}")
    public ResponseEntity<InstructorDto> modifyInstructor(@RequestBody InstructorDto requestDto, HttpServletRequest request) {
        return new ResponseEntity<>(instructorService.modifyInstructor(requestDto,request), HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorDto> getInstructor(@PathVariable Long instructorId) {
        return new ResponseEntity<>(instructorService.getInstructor(instructorId), HttpStatus.OK);
    }
}
