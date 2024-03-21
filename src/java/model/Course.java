
package model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author magtech
 */
@Entity
@Table(name = "course")
public class Course {

    
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "course_name")
    private String courseName;
    
    @Column(name = "semester_id")
    private Semester semester;
    
    @OneToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;
    
    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;
    @OneToOne(mappedBy = "course")
    private Teacher teacher;

    public Course() {
    }

    public Course(CourseDefinition courseDefinition, Long id, String courseName, Semester semester, AcademicUnit department) {
        this.courseDefinition = courseDefinition;
        this.id = id;
        this.courseName = courseName;
        this.semester = semester;
        this.department = department;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
}
