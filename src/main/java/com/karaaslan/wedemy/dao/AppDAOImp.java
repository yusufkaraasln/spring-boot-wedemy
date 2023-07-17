package com.karaaslan.wedemy.dao;


import com.karaaslan.wedemy.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class AppDAOImp implements AppDAO {

    @Autowired
    private EntityManager em;


    public AppDAOImp(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional
    public void save(Instructor intructor) {

        em.persist(intructor);


    }

    @Override
    public List<Instructor> getInstructors() {
        return em.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findInstructorById(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return em.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = em.find(Instructor.class, id);

        em.remove(instructor);


    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = em.find(InstructorDetail.class, id);

        em.remove(instructorDetail);

    }

    @Override
    public List<Course> getInstructorCourses(int id) {
        Instructor instructor = em.find(Instructor.class, id);

        return instructor.getCourses();

    }


    @Override
    @Transactional
    public void saveCourse(int id, Course course) {
        String sql = "INSERT INTO course (title, instructor_id) VALUES (?, ?)";
        em.createNativeQuery(sql)
                .setParameter(1, course.getTitle())
                .setParameter(2, id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void updateCourse(int id, Course course) {
        String sql = "UPDATE course SET title = ? WHERE id = ?";
        em.createNativeQuery(sql)
                .setParameter(1, course.getTitle())
                .setParameter(2, id)
                .executeUpdate();

    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = em.find(Course.class, id);

        em.remove(course);

    }

    @Override
    public List<Review> getCourseReviews(int id) {
        Course course = em.find(Course.class, id);

        return course.getReviews();
    }


    @Override
    public Review getReviewByIdAndCourseId(int id, int reviewId) {

       /* String sql = "SELECT * FROM review WHERE id = ? AND course_id = ?";
        return (Review) em.createNativeQuery(sql, Review.class)
                .setParameter(1, reviewId)
                .setParameter(2, id)
                .getSingleResult();*/

        Course course = em.find(Course.class, id);

        List<Review> reviews = course.getReviews();

        Review result = null;

        for (int i = 0; i < reviews.size(); i++) {

            Review review = reviews.get(i);
            review.setId(i + 1);

            if (review.getId() == reviewId) {
                result = review;
                break;
            }


        }

        return result;


    }

    @Override
    public List<Student> getCourseStudents(int id) {

        Course course = em.find(Course.class, id);

        return course.getStudents();
    }

    @Override
    public List<Course> getStudentCourses(int id) {

        Student student = em.find(Student.class, id);

        return student.getCourses();
    }


}
