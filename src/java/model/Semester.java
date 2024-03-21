package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author magtech
 */
@Entity
public class Semester implements Serializable {

    @Id
    @Column(name = "semester_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long semesterId;

    @Column(name = "semester_Name")
    private String semesterName;

    @Column(name = "starting_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    

    public Semester() {
    }

    public Semester(Long semesterId, String semesterName, Date startingDate, Date endDate) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }

    public Semester(String semesterName, Date startingDate, Date endDate) {
        this.semesterName = semesterName;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Long semesterId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
