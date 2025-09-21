package com.example.automovil.repository;

import com.example.automovil.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CarRepository {
    private final Map<UUID, Car> data = new ConcurrentHashMap<>();
    public Car add(Car car){
        if (car.getId() == null)
            car.setId(UUID.randomUUID());
        data.put(car.getId(), car);
        return car;
    }

}
