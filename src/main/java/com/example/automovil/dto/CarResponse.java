package com.example.automovil.dto;

import java.util.UUID;

public record CarResponse (
    UUID id,
    String modelo,
    String marca,
    String color
    //int anio
){}
