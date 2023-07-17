package com.karaaslan.wedemy.dao;


import com.karaaslan.wedemy.entity.*;

import java.util.List;

public interface AppDAO {

    void save(Instructor intructor);

    List<Instructor> getInstructors();

    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);


    void deleteInstructorById(int id);


    void deleteInstructorDetailById(int id);

    List<Course> getInstructorCourses(int id);

    void saveCourse(int id, Course course);

    void updateCourse(int id, Course course);

    List<Review> getCourseReviews(int id);

    Review getReviewByIdAndCourseId(int id, int reviewId);
    void deleteCourseById(int id);

    List<Student> getCourseStudents(int id);

    List<Course> getStudentCourses(int id);
}
