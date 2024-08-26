package com.spring.graphql.services;

import com.spring.graphql.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    void saveCourse(Course course);

    void deleteById(Long id);
}
