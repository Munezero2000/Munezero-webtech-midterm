package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author magtech
 */
@Entity
@Table(name="course_definition")
public class CourseDefinition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_definition_id")
    private Long Id;

    @Column(name ="course_definition_description")
    private String description ;
    
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course; 

    public CourseDefinition() {
    }

    public CourseDefinition(Long Id, String description, Course course) {
        this.Id = Id;
        this.description = description;
        this.course = course;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
