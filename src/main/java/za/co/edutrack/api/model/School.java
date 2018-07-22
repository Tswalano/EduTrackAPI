package za.co.edutrack.api.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "School")
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "school_id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String schoolName;

    @NotBlank
    @Column(name = "grade")
    private String grade;

    @NotNull
    @Column(name = "year")
    private Integer year;

    @OneToMany(mappedBy = "school", // Refers to "subject" property in Subject class
            cascade = {CascadeType.ALL})
    private List<Subject> subjects;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "student_school",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private List<Student> students;

    public School() {
    }

    public School(String schoolName, String grade, Integer year) {
        this.schoolName = schoolName;
        this.grade = grade;
        this.year = year;
    }

    //    Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", grade='" + grade + '\'' +
                ", year=" + year +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }

    // Add convenience methods for Bi-Directional relationship
    public void addSubject(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }

        subjects.add(subject);
        subject.setSchool(this);
    }
}
