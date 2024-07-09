package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.dto.Student;
import com.example.gen_code_ai.web.StudentsApiDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentApiDelegateImpl implements StudentsApiDelegate {

    @Override
    public ResponseEntity<Student> getStudentById(String id) {
        Student student = new Student();
        student.setId(1L);
        student.setCode("123");
        student.setName("John");

        return ResponseEntity.ok().body(student);
    }
}
