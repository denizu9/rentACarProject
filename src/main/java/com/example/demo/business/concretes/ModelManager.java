package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.ModelService;
import com.example.demo.core.utilities.mappers.ModelMapperService;
import com.example.demo.dataAccess.abstracts.ModelRepository;
import com.example.demo.dtos.requests.CreateModelRequest;
import com.example.demo.dtos.requests.UpdateBrandRequest;
import com.example.demo.dtos.requests.UpdateModelRequest;
import com.example.demo.dtos.responses.GetAllModelsResponse;
import com.example.demo.dtos.responses.GetByIdModelResponse;
import com.example.demo.entities.concretes.Model;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;

    private ModelMapperService modelMapperService;

    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        return models.stream().map(model ->
                this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).toList();
    }

    @Override
    public GetByIdModelResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }


    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
