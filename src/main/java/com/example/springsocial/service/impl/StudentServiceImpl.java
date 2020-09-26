package com.example.springsocial.service.impl;

import com.example.springsocial.annotation.NoLogging;
import com.example.springsocial.model.Student;
import com.example.springsocial.service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getAllStudents() {
        return new Student("Harshit", 1, 9900839);
    }

    @Override
    @NoLogging
    public Student getStudentById(int id) {
        return new Student("Harshit", id, 9900839);
    }
}
