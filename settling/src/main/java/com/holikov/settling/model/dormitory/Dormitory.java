package com.holikov.settling.model.dormitory;

import com.holikov.settling.model.student.Student;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "dormitory")
@Table(name = "dormitory")
public class Dormitory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    @NotBlank
    private int number;

    @Column(name = "address", nullable = false)
    @NotBlank
    private String address;

    @Column(name = "num_rooms", nullable = false)
    @NotBlank
    private int numRooms;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warden")
    private Warden warden;

    public Dormitory(Long id, int number, String address, int numRooms, Warden warden) {
        this.id = id;
        this.number = number;
        this.address = address;
        this.numRooms = numRooms;
        this.warden = warden;
    }

    public Dormitory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public Warden getWarden() {
        return warden;
    }

    public void setWarden(Warden warden) {
        this.warden = warden;
    }
}
