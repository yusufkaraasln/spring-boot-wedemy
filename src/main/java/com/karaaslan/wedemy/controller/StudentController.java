package com.karaaslan.wedemy.controller;

import com.karaaslan.wedemy.dao.AppDAOImp;
import com.karaaslan.wedemy.entity.Course;
import com.karaaslan.wedemy.entity.Review;
import com.karaaslan.wedemy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private AppDAOImp appDAO;

    @Autowired
    public StudentController(AppDAOImp appDAO) {
        this.appDAO = appDAO;
    }

    @GetMapping("/courses/{id}/students")
    public List<Student> getStudentsById(@PathVariable int id) {
        return appDAO.getCourseStudents(id);

    }

/*    @GetMapping("/students/{id}/courses")
    public List<Course> getCoursesById(@PathVariable int id) {
        return appDAO.getStudentCourses(id);

    }*/
}
