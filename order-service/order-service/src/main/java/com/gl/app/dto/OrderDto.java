package com.gl.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    private int oId;
    private int cId;
    private int fId;
    private LocalDate date;
    private Double totalBill;

}
