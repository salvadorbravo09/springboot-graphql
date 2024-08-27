package com.spring.graphql.controllers;

import com.spring.graphql.entities.Course;
import com.spring.graphql.entities.Student;
import com.spring.graphql.graphql.InputStudent;
import com.spring.graphql.services.CourseService;
import com.spring.graphql.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        Long studentId = Long.parseLong(id);
        return studentService.findById(studentId);
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent) {
        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.saveStudent(student);
        return student;
    }

    @MutationMapping
    public String deleteStudentById(@Argument(name = "studentId") String id) {
        studentService.deleteById(Long.parseLong(id));
        return "El estudiante con id: " + id + " ha sido eliminado correctamente";
    }
}
