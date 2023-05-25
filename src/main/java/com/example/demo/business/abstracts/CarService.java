package com.example.demo.business.abstracts;

import com.example.demo.dtos.requests.CreateCarRequest;
import com.example.demo.dtos.requests.UpdateCarRequest;
import com.example.demo.dtos.responses.GetAllCarsResponse;
import com.example.demo.dtos.responses.GetByIdCarResponse;

import java.util.List;

public interface CarService {

    List<GetAllCarsResponse> getAll();

    GetByIdCarResponse getById(int id);

    void update(UpdateCarRequest updateCarRequest);

    void add(CreateCarRequest createCarRequest);

    void delete(int id);
}
