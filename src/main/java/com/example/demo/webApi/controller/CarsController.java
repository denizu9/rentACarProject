package com.example.demo.webApi.controller;

import com.example.demo.business.abstracts.CarService;
import com.example.demo.dtos.requests.CreateCarRequest;
import com.example.demo.dtos.requests.UpdateCarRequest;
import com.example.demo.dtos.responses.GetAllCarsResponse;
import com.example.demo.dtos.responses.GetByIdCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {

    private CarService carService;

    @GetMapping
    List<GetAllCarsResponse> getAll(){
        return this.carService.getAll();
    }

    @GetMapping("/{id}")
    GetByIdCarResponse getById(int id){
        return this.carService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.carService.delete(id);
    }
}
