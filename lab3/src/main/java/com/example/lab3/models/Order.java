package com.example.lab3.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;


@Entity(name = "\"order\"")
public class Order {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "doctorsurname")
    @Nonnull
    private String doctorSurname;

    @Column(name = "payway")
    @Nonnull
    private String payWay;

    public Order() {

    }

    public Order(String doctorSurname, String payWay) {
        this.doctorSurname = doctorSurname;
        this.payWay = payWay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nonnull
    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(@Nonnull String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    @Nonnull
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(@Nonnull String payWay) {
        this.payWay = payWay;
    }
}
