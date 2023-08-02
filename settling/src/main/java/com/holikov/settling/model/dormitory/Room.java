package com.holikov.settling.model.dormitory;

import com.holikov.settling.model.student.Student;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "room")
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_seats", nullable = false)
    @NotBlank
    private int numSeats;

    @Column(name = "free_p", nullable = false)
    @NotBlank
    private int freePlace;

    @Column(name = "occupied_p", nullable = false)
    @NotBlank
    private int occupiedPlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dormitory")
    private Dormitory dormitory;

    public Room(Long id, int numSeats, int freePlace, int occupiedPlace, Dormitory dormitory) {
        this.id = id;
        this.numSeats = numSeats;
        this.freePlace = freePlace;
        this.occupiedPlace = occupiedPlace;
        this. dormitory = dormitory;
    }

    public Room() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void setFreePlace(int freePlace) {
        this.freePlace = freePlace;
    }

    public int getOccupiedPlace() {
        return occupiedPlace;
    }

    public void setOccupiedPlace(int occupiedPlace) {
        this.occupiedPlace = occupiedPlace;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }
}
