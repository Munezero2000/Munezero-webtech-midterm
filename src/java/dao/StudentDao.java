package dao;

import java.util.List;
import model.Student;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class StudentDao {

    public Student createStudent(Student student) {
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

    public Student updateStudent(Student student) {
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

    public Student DeleteStudent(Student student) {
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

    public Student findStudentById(Student student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Student theStudent = (Student) ss.get(Student.class, student.getStudentId());
            return theStudent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Student> students = session.createQuery("FROM Student").list();
            session.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
