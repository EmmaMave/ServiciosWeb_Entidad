package com.example.automovil.dto;

import java.util.UUID;

public record CarResponse (
    UUID id,
    String model,
    String brand,
    String color
    //int anio
){}
