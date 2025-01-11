package com.gl.app.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int cId;

    @NotBlank(message = "Customer name should not be empty")
    @Size(min = 4, message = "Customer name should have at least 4 characters")
    @NotNull(message = "Customer name should not be null")
    private String cName;

    @NotBlank(message = "Location should not be empty")
    @Size(min = 3, message = "Location should have at least 3 characters")
    @NotNull(message = "Location should not be null")
    private String cLocation;

    @NotBlank(message = "Address should not be empty")
    @Size(min = 3, message = "Address should have at least 3 characters")
    @NotNull(message = "Address should not be null")
    private String cAddress;

    @NotBlank(message = "Type should not be empty")
    @Size(min = 7, message = "Type should have at least 37 characters")
    @NotNull(message = "Type should not be null")
    @Pattern(regexp = "Premium|Regular", message = "Customer type should be either Regular or Premium")
    private String cType;

}
