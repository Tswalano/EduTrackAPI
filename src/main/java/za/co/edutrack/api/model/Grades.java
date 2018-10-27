package za.co.edutrack.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gradeID")
    private Long id;

    @NotBlank
    @Column(name = "gradeCode")
    private String gradeCode;

    @NotNull
    @Column(name = "grade")
    private Integer grade;

    @NotNull
    @Column(name = "year")
    private Integer year;

    @OneToMany(mappedBy = "grades", // Refers to "subject" property in Subject class
            cascade = {CascadeType.ALL})
    private List<Subject> subjects;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "schoolID")
    private School school;

    public Grades() {
    }

    public Grades(String gradeCode, Integer grade, Integer year) {
        this.gradeCode = gradeCode;
        this.grade = grade;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", gradeCode='" + gradeCode + '\'' +
                ", grade=" + grade +
                ", year=" + year +
                ", subjects=" + subjects +
                ", school=" + school +
                '}';
    }

    public void addSubject(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        subjects.add(subject);
        subject.setGrades(this);
    }
}
