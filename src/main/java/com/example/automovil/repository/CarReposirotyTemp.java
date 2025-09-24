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

    List<Car> findByBrand(String brand);

    List<Car> findByModel(String model);

    List<Car> findByColor(String color);

}
