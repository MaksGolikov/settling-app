package com.holikov.settling.model.university;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity (name = "groups")
@Table (name = "groups")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "number", nullable = false)
    @NotBlank
    private int number;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "department")
    private Department department;


    public Group(Long id, String name, int number, Department department) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.department = department;
    }

    public Group() {

    }

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
