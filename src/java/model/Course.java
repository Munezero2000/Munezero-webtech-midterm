package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author magtech
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

    @OneToOne(mappedBy = "course")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CourseDefinition courseDefinition;
    
    @OneToOne(mappedBy = "course")
    private Teacher teacher;

    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course(Long id, String courseCode, String courseName, Semester semester, AcademicUnit department, CourseDefinition courseDefinition, Teacher teacher) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.department = department;
        this.courseDefinition = courseDefinition;
        this.teacher = teacher;
    }

    public Course(String courseCode, String courseName, Semester semester, AcademicUnit department, CourseDefinition courseDefinition) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.department = department;
        this.courseDefinition = courseDefinition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit department) {
        this.department = department;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
