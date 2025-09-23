package com.example.automovil.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CarRequest(

    @NotBlank(message = "La marca es obligatoria")
    String marca,

    @NotBlank(message = "El modelo es obligatorio")
    String modelo,

    @NotBlank(message = "El color es obligatorio")
    String color,

   // @NotNull(message = "El año es obligatorio")
    @Positive(message = "El año debe ser un número positivo")
    Integer anio,
) {}
