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
    @Column(name = "subject_id")
    private Long id;

    @NotBlank
    @Column(name = "subject")
    private String subject;

    @NotBlank
    @Column(name = "Term")
    private String term;

    @NotNull
    @Column(name = "mark")
    private Integer mark;

//    @JsonIgnore
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "school_id")
    private School school;


    public Subject() {
    }

    public Subject(String subject, String term, Integer mark) {
        this.subject = subject;
        this.term = term;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", term='" + term + '\'' +
                ", mark=" + mark +
                ", school=" + school +
                '}';
    }
}
