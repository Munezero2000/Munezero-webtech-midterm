package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author magtech
 */
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    
    @OneToMany(mappedBy = "student")
    private List<StudentRegistration> studentRegistrations;

    public Student() {
    }

    public Student(Long studentId, String firstName, String lastName, String dateOfBirth) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<StudentRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(List<StudentRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }
    
    
}
