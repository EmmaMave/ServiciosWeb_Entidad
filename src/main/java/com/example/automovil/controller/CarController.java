package com.example.automovil.controller;

import com.example.automovil.dto.CarRequest;
import com.example.automovil.dto.CarResponse;
import com.example.automovil.model.Car;
import com.example.automovil.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    // POST 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse add(@Valid @RequestBody CarRequest car) {
        return service.add(car);
    }

    // GETALL
    @GetMapping
    public List<CarResponse> findAll() {
        return service.findAllCars();
    }

    // GET 
    @GetMapping("/{id}")
    public CarResponse getById(@PathVariable UUID id) {
        return service.getCar(id);
    }

    // PUT 
    @PutMapping("/{id}")
    public CarResponse update(@PathVariable UUID id, @Valid @RequestBody CarRequest car) {
        return service.update(id,car);
    }

    // DELETE - Eliminar auto por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        service.delete(id);
    }

    // GET - Buscar autos por marca 
    @GetMapping("/brand/{brand}")
    public List<CarResponse> getByBrand(@PathVariable String brand) {
        return service.getByBrand(brand);
    }

    
    // GET - Buscar autos por modelo
    @GetMapping("/model/{model}")
    public List<CarResponse> getByModel(@PathVariable String model) {
        return service.getByModel(model);
    }

      // GET - Buscar autos por modelo
    @GetMapping("/color/{color}")
    public List<CarResponse> getByColor(@PathVariable String color) {
        return service.getByColor(color);
    }  
}
