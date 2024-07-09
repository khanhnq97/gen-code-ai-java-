package com.example.gen_code_ai.web;

import com.example.gen_code_ai.dto.Response;
import com.example.gen_code_ai.dto.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-09T15:31:04.908141+07:00[Asia/Ho_Chi_Minh]")
@Controller
@RequestMapping("${openapi.studentInformationManagementSystem.base-path:/api}")
public class StudentsApiController implements StudentsApi {

    private final StudentsApiDelegate delegate;

    public StudentsApiController(@Autowired(required = false) StudentsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new StudentsApiDelegate() {});
    }

    @Override
    public StudentsApiDelegate getDelegate() {
        return delegate;
    }

}
