package za.co.edutrack.api.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subjectID")
    private Long id;

    @NotBlank
    @Column(name = "subjectName")
    private String subjectName;

    @NotBlank
    @Column(name = "subjectCode")
    private String subjectCode;

    @NotNull
    @Column(name = "term")
    private Integer term;

    @NotNull
    @Column(name = "mark")
    private Integer mark;

//    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "gradeID")
    private Grades grades;

    public Subject() {
    }

    public Subject(String subjectName, String subjectCode, Integer term, Integer mark) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.term = term;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", term=" + term +
                ", mark=" + mark +
                ", grades=" + grades +
                '}';
    }
}
