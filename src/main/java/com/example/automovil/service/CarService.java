package com.example.automovil.service;

import com.example.automovil.dto.CarRequest;
import com.example.automovil.dto.CarResponse;
import com.example.automovil.model.Car;
import com.example.automovil.repository.CarRepository;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    public CarResponse add(CarRequest car) {
        Car c = Car.builder()
                .modelo(car.modelo())
                .marca(car.marca())
                .color(car.color()).build();
        repo.add(c);
        return toResponse(c);
    }

    private CarResponse toResponse(Car car) {
        return new CarResponse(car.getId(), car.getModelo(), car.getMarca(), car.getColor());
    }

}
