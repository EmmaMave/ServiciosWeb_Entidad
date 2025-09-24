package com.example.automovil.repository;

import com.example.automovil.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarReposirotyTemp {

    List<Car> findAll();

    Optional<Car> findById(UUID id);

    Car add(Car car);

    boolean deleteById(UUID id);

    Optional<Car> findByBrand(String brand);

    Optional<Car> findByModel(String model);

    Optional<Car> findByColor(String color);

}
