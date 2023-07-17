package com.karaaslan.wedemy.controller;


import com.karaaslan.wedemy.dao.AppDAO;

import com.karaaslan.wedemy.entity.Instructor;
import com.karaaslan.wedemy.entity.InstructorDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    private AppDAO appDAO;


    @Autowired
    public InstructorController(AppDAO appDAO) {
        this.appDAO = appDAO;
    }


    @GetMapping("/instructors")
    public List<Instructor> getInstructors() {
        return appDAO.getInstructors();

    }

    @GetMapping("/instructors/{id}")
    public Instructor getInstructorById(@PathVariable int id) {
        return appDAO.findInstructorById(id);
    }


    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {


        appDAO.save(instructor);

        return instructor;
    }


    @GetMapping("/instructors/detail/{id}")
    public InstructorDetail
    getInstructorDetailById(@PathVariable int id) {


        InstructorDetail result = appDAO.findInstructorDetailById(id);

        return result;

    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id) {
        appDAO.deleteInstructorById(id);
        return "Deleted instructor with id: " + id;
    }

    @DeleteMapping("/instructors/detail/{id}")
    public String deleteInstructorDetailById(@PathVariable int id) {
        appDAO.deleteInstructorDetailById(id);
        return "Deleted instructor detail with id: " + id;
    }


}
