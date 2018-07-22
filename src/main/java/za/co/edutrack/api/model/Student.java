package za.co.edutrack.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Table(name = "Student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @Column(name = "gender")
    private String gender;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "number")
    private Long number;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_school",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "school_id", referencedColumnName = "school_id"))
    private List<School> school;


    //  Constructor
    public Student() {
    }

    public Student(String name, String surname, String gender, String email, String username, String password, Long number, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
    }

    //  Generate getters/setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<School> getSchool() {
        return school;
    }

    public void setSchool(List<School> school) {
        this.school = school;
    }

    //  Generate toString() method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", number=" + number +
                ", dateOfBirth=" + dateOfBirth +
                ", school=" + school +
                '}';
    }

    //      Add a convenience method
    public void addSchool(School mySchool) {
        if (school == null) {
            school = new ArrayList<>();
        }
        school.add(mySchool);
    }
}
