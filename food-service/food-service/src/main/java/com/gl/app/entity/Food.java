package com.gl.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fId;
    private String fName;
    private String fType;
    private int rating;
    private String hotelName;
    private String hotelAddress;

}
