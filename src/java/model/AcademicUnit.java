package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author magtech
 */
@Entity
@Table(name = "academic_unit")
public class AcademicUnit implements Serializable {

    @Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long academicUnitId;

    @Column(name = "academic_unit_name")
    private String academicUnitName;

    @Column(name = "academic_unit_type")
    @Enumerated(EnumType.STRING)
    private EAcademicUnit academicUnitType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parentId;

    public AcademicUnit() {
    }

    public AcademicUnit(Long academicUnitId, String academicUnitName, EAcademicUnit academicUnitType, AcademicUnit parentId) {
        this.academicUnitId = academicUnitId;
        this.academicUnitName = academicUnitName;
        this.academicUnitType = academicUnitType;
        this.parentId = parentId;
    }

    public AcademicUnit(String academicUnitName, EAcademicUnit academicUnitType, AcademicUnit parentId) {
        this.academicUnitName = academicUnitName;
        this.academicUnitType = academicUnitType;
        this.parentId = parentId;
    }

    public Long getAcademicUnitId() {
        return academicUnitId;
    }

    public void setAcademicUnitId(Long academicUnitId) {
        this.academicUnitId = academicUnitId;
    }

    public String getAcademicUnitName() {
        return academicUnitName;
    }

    public void setAcademicUnitName(String academicUnitName) {
        this.academicUnitName = academicUnitName;
    }

    public EAcademicUnit getAcademicUnitType() {
        return academicUnitType;
    }

    public void setAcademicUnitType(EAcademicUnit academicUnitType) {
        this.academicUnitType = academicUnitType;
    }

    public AcademicUnit getParentId() {
        return parentId;
    }

    public void setParentId(AcademicUnit parentId) {
        this.parentId = parentId;
    }

}
