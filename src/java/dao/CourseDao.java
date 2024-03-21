/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Course;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class CourseDao {
     public Course createCourse(Course course){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(course);
            ss.beginTransaction().commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public Course updateCourse(Course course) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(course);
            ss.beginTransaction().commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Course DeleteCourse(Course course) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(course);
            ss.beginTransaction().commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Course findCourseById(Course course) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Course theCourse =(Course)ss.get(Course.class, course.getId());
            return theCourse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Course> getAllCourses() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Course> courses = session.createQuery("FROM Course").list();
            session.close(); 
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
