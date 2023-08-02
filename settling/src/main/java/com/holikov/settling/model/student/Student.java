package com.holikov.settling.model.student;

import com.holikov.settling.model.Role;
import com.holikov.settling.model.User;
import com.holikov.settling.model.dormitory.Dormitory;
import com.holikov.settling.model.dormitory.Room;
import com.holikov.settling.model.university.Department;
import com.holikov.settling.model.university.Group;
import com.holikov.settling.model.university.Speciality;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity(name = "student")
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false)
    @NotBlank
    private String surname;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "age", nullable = false)
    @NotBlank
    private int age;


    @Column(name = "phone", nullable = false)
    @NotBlank
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groups", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile")
    private Profile profile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dormitory")
    private Dormitory dormitory;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "room")
    private Room room;

    public Student(Long id, String surname, String firstName, String lastName,
                   int age, String phone, Group group, Department department,
                   Speciality speciality, Profile profile, Role role,
                   Dormitory dormitory, Room room) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.group = group;
        this.department = department;
        this.speciality = speciality;
        this.profile = profile;
        this.role = role;
        this.dormitory = dormitory;
        this.room = room;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "\n\nStudent{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", group=" + group +
                ", department=" + department +
                ", speciality=" + speciality +
                ", profile=" + profile +
                ", role=" + role +
                ", dormitory=" + dormitory +
                ", room=" + room +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}

