
package dao;

import java.util.List;
import model.AcademicUnit;
import org.hibernate.Session;

/**
 *
 * @author magtech
 */
public class AcademicUnitDao {
     public AcademicUnit createAcademicUnit(AcademicUnit academicUnit){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(academicUnit);
            ss.beginTransaction().commit();
            return academicUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        }
    public AcademicUnit updateAcademicUnit(AcademicUnit academicUnit) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(academicUnit);
            ss.beginTransaction().commit();
            return academicUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public AcademicUnit DeleteAcademicUnit(AcademicUnit academicUnit) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(academicUnit);
            ss.beginTransaction().commit();
            return academicUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public AcademicUnit findAcademicUnitById(AcademicUnit academicUnit) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            AcademicUnit theAcademicUnit =(AcademicUnit)ss.get(AcademicUnit.class, academicUnit.getAcademicUnitId());
            return theAcademicUnit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<AcademicUnit> getAllAcademicUnits() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<AcademicUnit> academicUnits = session.createQuery("FROM AcademicUnit").list();
            session.close(); 
            return academicUnits;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
