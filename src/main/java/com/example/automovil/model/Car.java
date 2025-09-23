package com.example.automovil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Car {
    private UUID id;
    private String model;
    private String brand;
    private String color;
    //private int anio;
}
