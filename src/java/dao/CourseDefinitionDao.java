
package dao;

import java.util.List;
import model.CourseDefinition;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class CourseDefinitionDao {
        public CourseDefinition createCourseDefinition(CourseDefinition courseDefinition){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(courseDefinition);
            ss.beginTransaction().commit();
            return courseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public CourseDefinition updateCourseDefinition(CourseDefinition courseDefinition) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(courseDefinition);
            ss.beginTransaction().commit();
            return courseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public CourseDefinition DeleteCourseDefinition(CourseDefinition courseDefinition) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(courseDefinition);
            ss.beginTransaction().commit();
            return courseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public CourseDefinition findCourseDefinitionById(CourseDefinition courseDefinition) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            CourseDefinition theCourseDefinition =(CourseDefinition)ss.get(CourseDefinition.class, courseDefinition.getId());
            return theCourseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<CourseDefinition> getAllCourseDefinitions() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<CourseDefinition> courseDefinitions = session.createQuery("FROM CourseDefinition").list();
            session.close(); 
            return courseDefinitions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
