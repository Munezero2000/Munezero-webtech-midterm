package dao;

import java.util.List;
import model.StudentRegistration;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class StudentRegistrationDao {
     public StudentRegistration createStudentRegistration(StudentRegistration student){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(student);
            ss.beginTransaction().commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public StudentRegistration updateStudentRegistration(StudentRegistration student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(student);
            ss.beginTransaction().commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public StudentRegistration DeleteStudentRegistration(StudentRegistration student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(student);
            ss.beginTransaction().commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public StudentRegistration findStudentRegistrationById(StudentRegistration student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            StudentRegistration theStudentRegistration =(StudentRegistration)ss.get(StudentRegistration.class, student.getRegistrationId());
            return theStudentRegistration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<StudentRegistration> getAllStudentRegistrations() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<StudentRegistration> students = session.createQuery("FROM StudentRegistration").list();
            session.close(); 
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
