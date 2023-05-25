package com.example.demo.business.abstracts;

import com.example.demo.dtos.requests.CreateModelRequest;
import com.example.demo.dtos.requests.UpdateBrandRequest;
import com.example.demo.dtos.requests.UpdateModelRequest;
import com.example.demo.dtos.responses.GetAllModelsResponse;
import com.example.demo.dtos.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    GetByIdModelResponse getById(int id);

    void update(UpdateModelRequest updateModelRequest);

    void add(CreateModelRequest createModelRequest);

    void delete(int id);

}
