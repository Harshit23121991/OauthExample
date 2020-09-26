package com.example.springsocial.service;

import com.example.springsocial.model.Student;

public interface StudentService {
    Student getAllStudents();

    Student getStudentById(int id);
}
