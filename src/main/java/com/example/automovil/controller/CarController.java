package com.example.automovil.controller;

import com.example.automovil.dto.CarRequest;
import com.example.automovil.dto.CarResponse;
import com.example.automovil.service.CarService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService car) {
        this.service = car;
    }

    @PostMapping
    public CarResponse add(@Valid @RequestBody CarRequest car) {
        return service.add(car);
    }

}
