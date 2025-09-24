package com.example.automovil.repository;

import com.example.automovil.model.Car;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCarRepository implements CarReposirotyTemp {

    private final Map<UUID, Car> data = new ConcurrentHashMap<>();

    @Override
    public List<Car> findAll(){
        return new ArrayList<>(data.values());
    }


    @Override
    public Optional<Car> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public Car add(Car car){
        if (car.getId() == null)
            car.setId(UUID.randomUUID());
        data.put(car.getId(), car);
        return car;
    }

    @Override
    public boolean deleteById(UUID id) {
        return data.remove(id) != null;
    }

    @Override
    public Optional<Car> findByBrand(String brand) {
        return data.values().stream().filter(car -> car.getBrand().equalsIgnoreCase(brand)).findFirst();
    }

    @Override
    public Optional<Car> findByModel(String model) {
        return data.values().stream().filter(car -> car.getModel().equalsIgnoreCase(model)).findFirst();
    }

    @Override
    public Optional<Car> findByColor(String color) {
        return data.values().stream().filter(car -> car.getColor().equalsIgnoreCase(color)).findFirst();
    }
}
