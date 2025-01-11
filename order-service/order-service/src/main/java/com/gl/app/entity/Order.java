package com.gl.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;
    private int cId;
    private int fId;
    private LocalDate date;
    private Double totalBill;

}
