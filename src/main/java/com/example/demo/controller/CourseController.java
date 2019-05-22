package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC
    CourseService courseService; // Singleton

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity addCourse(@RequestBody Course newCourse) {
        courseService.addCourse(newCourse);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/delete/{inputString}", produces = "application/json")
    public ResponseEntity deleteCourse(@PathVariable("inputString") String inputString) {
        courseService.deleteCourseByName(inputString);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{inputString}", produces = "application/json")
    public ResponseEntity updateCourse(@PathVariable("inputString") String inputString,
                                       @RequestBody Course newCourse) {
        courseService.deleteCourseByName(inputString);
        courseService.addCourse(newCourse);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {

        List<Course> findedCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(findedCourse, HttpStatus.OK);
    }
}
