package com.gl.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class FoodDto {

    private int fId;

    @NotBlank(message = "Food name should not be empty")
    @Size(min = 4, message = "Food name should have at least 4 characters")
    @NotNull(message = "Food name should not be null")
    private String fName;

    @NotBlank(message = "Food name should not be empty")
    @Size(min = 3, message = "Food name should have at least 3 characters")
    @NotNull(message = "Food name should not be null")
    private String fType;

    @Range(min = 1, max = 5, message = "Invalid Rating!")
    private int rating;

    @NotBlank(message = "Hotel name should not be empty")
    @Size(min = 4, message = "Hotel name should have at least 4 characters")
    @NotNull(message = "Hotel name should not be null")
    private String hotelName;

    @NotBlank(message = "Hotel Address should not be empty")
    @Size(min = 3, message = "Hotel Address should have at least 3 characters")
    @NotNull(message = "Hotel Address should not be null")
    private String hotelAddress;

}
