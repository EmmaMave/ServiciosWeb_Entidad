package com.example.automovil.service;

import com.example.automovil.dto.CarRequest;
import com.example.automovil.dto.CarResponse;
import com.example.automovil.model.Car;
import com.example.automovil.repository.CarReposirotyTemp;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarService {
    private final CarReposirotyTemp repo;

    public CarService(CarReposirotyTemp repo) {
        this.repo = repo;
    }

    public List<CarResponse> findAllCars() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public CarResponse getCar(UUID id) {
        Car car = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Automovil no encontrado" + id));
        return toResponse(car);
    }

    public CarResponse add(CarRequest car) {
        Car c = Car.builder()
                .model(car.model())
                .brand(car.brand())
                .color(car.color()).build();
        repo.add(c);
        return toResponse(c);
    }

    public CarResponse update(UUID id, @Valid @RequestBody CarRequest car) {
        Car exists = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado" + id));

//        if (!exists.getColor().equalsIgnoreCase(car.color())){
//            repo.findByColor(car.color()).ifPresent(c -> {
//                throw new IllegalArgumentException("Ya existe un automovil con ese color" + id);
//            });
//        }

        exists.setBrand(car.brand());
        exists.setColor(car.color());
        exists.setModel(car.model());
        return toResponse(repo.add(exists));
    }

    public void delete(UUID id) {
        if (!repo.deleteById(id)) {
            throw new IllegalArgumentException("Automovil no encontrado: " + id);
        }
    }
    
    public CarResponse getByBrand(String brand) {
        Car car = repo.findByBrand(brand)
                .orElseThrow(() -> new IllegalArgumentException("Automovil no encontrado" + brand));
        return toResponse(car);
    }

    public CarResponse getByModel(String model) {
        Car car = repo.findByBrand(model)
                .orElseThrow(() -> new IllegalArgumentException("Automovil no encontrado" + model));
        return toResponse(car);
    }

    public CarResponse getByColor(String color) {
        Car car = repo.findByBrand(color)
                .orElseThrow(() -> new IllegalArgumentException("Automovil no encontrado" + color));
        return toResponse(car);
    }

    private CarResponse toResponse(Car car) {
        return new CarResponse(car.getId(), car.getModel(), car.getBrand(), car.getColor());
    }



}
