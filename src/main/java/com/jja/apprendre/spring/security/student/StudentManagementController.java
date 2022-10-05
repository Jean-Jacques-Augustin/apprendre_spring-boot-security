package com.jja.apprendre.spring.security.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/Student")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "James Bond"), new Student(2, "Maria Johns"), new Student(3, "Bill Gate"));

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINISTRATE')")
    public List<Student> getAllStudent() {
        return STUDENTS;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerStudent(@RequestBody Student student) {
        System.out.println("registerStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("delete student with id " + studentId);
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        System.out.println("update student " + "with id " + studentId + "and" + student);
        System.out.printf(studentId + " et " + student);
    }
}
