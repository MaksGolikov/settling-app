package com.holikov.settling.model.student;

import jakarta.persistence.*;

@Entity(name = "profile")
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eco", nullable = false)
    private boolean eco;

    @Column(name = "deputy", nullable = false)
    private boolean deputy;

    @Column(name = "nurse", nullable = false)
    private boolean nurse;

    public Profile(Long id, boolean eco, boolean deputy, boolean nurse) {
        this.id = id;
        this.eco = eco;
        this.deputy = deputy;
        this.nurse = nurse;
    }

    public Profile() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public boolean isdeputy() {
        return deputy;
    }

    public void setdeputy(boolean deputy) {
        this.deputy = deputy;
    }

    public boolean isNurse() {
        return nurse;
    }

    public void setNurse(boolean nurse) {
        this.nurse = nurse;
    }
}
