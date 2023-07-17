package com.karaaslan.wedemy.controller;

import com.karaaslan.wedemy.dao.AppDAO;
import com.karaaslan.wedemy.entity.Course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private AppDAO appDAO;

    @Autowired
    public CourseController(AppDAO appDAO) {
        this.appDAO = appDAO;
    }


    @GetMapping("/courses/{id}")
    public List<Course> getCoursesById(
            @PathVariable int id
    ) {
        return appDAO.getInstructorCourses(id);

    }

    @PostMapping("/courses/{id}")
    public Course createCourse(
            @PathVariable int id,
            @RequestBody Course course
    ) {
        appDAO.saveCourse(id, course);

        return course;
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(
            @PathVariable int id,
            @RequestBody Course course
    ) {
        appDAO.updateCourse(id, course);

        return course;
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
        appDAO.deleteCourseById(id);

        return "Deleted course id - " + id;
    }


}
