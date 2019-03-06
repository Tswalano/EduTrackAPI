package za.co.edutrack.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.*;

@Table(name = "Student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentID")
    private Long id;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @NotBlank
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "idNumber")
    private Long idNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "phoneNum")
    private Integer phoneNum;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "schoolID")
    private School school;


    @OneToMany(mappedBy = "student",
            cascade = {CascadeType.ALL})
    private List<Grades> grades;

    //  Constructor
    public Student() {
    }

    public Student(String firstName, String lastName, String gender, Long idNumber, String email, String password,
                   Integer phoneNum, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.dateOfBirth = dateOfBirth;
    }

    //  Generate getters/setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber=" + idNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum=" + phoneNum +
                ", dateOfBirth=" + dateOfBirth +
                ", school=" + school +
                '}';
    }



    // Add convenience methods for Bi-Directional relationship
    public void addGrades(Grades grade) {
        if (grades == null) {
            grades = new ArrayList<>();
        }

        grades.add(grade);
        grade.setStudent(this);
    }
}
