
package dao;

import java.util.List;
import model.Semester;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class SemesterDao {
     public Semester createSemester(Semester semester){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(semester);
            ss.beginTransaction().commit();
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public Semester updateSemester(Semester semester) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(semester);
            ss.beginTransaction().commit();
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Semester DeleteSemester(Semester semester) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(semester);
            ss.beginTransaction().commit();
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Semester findSemesterById(Semester semester) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Semester theSemester =(Semester)ss.get(Semester.class, semester.getSemesterId());
            return theSemester;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Semester> getAllSemesters() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Semester> semesters = session.createQuery("FROM Semester").list();
            session.close(); 
            return semesters;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
