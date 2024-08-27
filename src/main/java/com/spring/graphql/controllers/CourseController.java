package com.spring.graphql.controllers;

import com.spring.graphql.entities.Course;
import com.spring.graphql.graphql.InputCourse;
import com.spring.graphql.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id) {
        Long courseId = Long.parseLong(id);

        return courseService.findById(courseId);
    }

    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse) {
        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.saveCourse(course);
        return course;
    }

    @MutationMapping(name = "deleteCourseById")
    public String deleteCourseById(@Argument(name = "courseId") String id) {
        courseService.deleteById(Long.parseLong(id));
        return "El curso con id: " + id + " has sido eliminado correctamente";
    }
}
