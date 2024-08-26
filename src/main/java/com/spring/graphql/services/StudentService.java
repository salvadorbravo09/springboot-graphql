package com.spring.graphql.services;

import com.spring.graphql.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void saveStudent(Student student);

    void deleteById(Long id);
}
