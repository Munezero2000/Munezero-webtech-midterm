
package dao;

import java.util.List;
import model.Teacher;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class TeacherDao {
     public Teacher createTeacher(Teacher teacher){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(teacher);
            ss.beginTransaction().commit();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public Teacher updateTeacher(Teacher teacher) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(teacher);
            ss.beginTransaction().commit();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Teacher DeleteTeacher(Teacher teacher) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(teacher);
            ss.beginTransaction().commit();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Teacher findTeacherById(Teacher teacher) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Teacher theTeacher =(Teacher)ss.get(Teacher.class, teacher.getId());
            return theTeacher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Teacher> getAllTeachers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Teacher> teachers = session.createQuery("FROM Teacher").list();
            session.close(); 
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
