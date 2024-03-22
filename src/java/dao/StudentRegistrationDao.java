package dao;

import java.util.List;
import model.StudentRegistration;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class StudentRegistrationDao {
     public StudentRegistration createStudentRegistration(StudentRegistration stregistration){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(stregistration);
            ss.beginTransaction().commit();
            return stregistration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public StudentRegistration updateStudentRegistration(StudentRegistration stregistration) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(stregistration);
            ss.beginTransaction().commit();
            return stregistration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public StudentRegistration DeleteStudentRegistration(StudentRegistration stregistration) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(stregistration);
            ss.beginTransaction().commit();
            return stregistration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public StudentRegistration findStudentRegistrationById(StudentRegistration stregistration) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            StudentRegistration theStudentRegistration =(StudentRegistration)ss.get(StudentRegistration.class, stregistration.getRegistrationId());
            return theStudentRegistration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<StudentRegistration> getAllStudentRegistrations() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<StudentRegistration> stregistrations = session.createQuery("FROM StudentRegistration").list();
            session.close(); 
            return stregistrations;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
