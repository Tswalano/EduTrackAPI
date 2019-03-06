package za.co.edutrack.api.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.User;
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
    @Column(name = "schoolID")
    private Long id;

    @NotBlank
    @Column(name = "schoolName")
    private String schoolName;

    @NotNull
    @Column(name = "phoneNum")
    private Integer phoneNum;

    @NotBlank
    @Column(name = "address_line1")
    private String address_line1;

    @NotBlank
    @Column(name = "address_line2")
    private String address_line2;

    @NotBlank
    @Column(name = "city")
    private String city;

    @NotBlank
    @Column(name = "province")
    private String province;

    @NotNull
    @Column(name = "postalCode")
    private int postalCode;

    @NotNull
    @Column(name = "circuit")
    private String circuit;

    @OneToMany(mappedBy = "school", // Refers to "subject" property in Subject class
            cascade = {CascadeType.ALL})
    private List<Student> students;

    @OneToMany(mappedBy = "school", // Refers to "subject" property in Subject class
            cascade = {CascadeType.ALL})
    private List<Users> users;

    public School() {
    }

    //Constructor

    public School(String schoolName, Integer phoneNum, String address_line1, String address_line2,
                  String city, String province, int postalCode, String circuit) {
        this.schoolName = schoolName;
        this.phoneNum = phoneNum;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.circuit = circuit;
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

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public List<Grades> getGrades() {
//        return grades;
//    }
//
//    public void setGrades(List<Grades> grades) {
//        this.grades = grades;
//    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", phoneNum=" + phoneNum +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode=" + postalCode +
                ", circuit='" + circuit + '\'' +
                ", students=" + students +
//                ", grades=" + grades +
                ", users=" + users +
                '}';
    }

    //      Add a convenience method
    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setSchool(this);
    }

    public void addUsers(Users user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
//        user.setSchool(this);
    }
}
