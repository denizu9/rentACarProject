package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.CarService;
import com.example.demo.core.utilities.mappers.ModelMapperService;
import com.example.demo.dataAccess.abstracts.CarRepository;
import com.example.demo.dtos.requests.CreateCarRequest;
import com.example.demo.dtos.requests.UpdateCarRequest;
import com.example.demo.dtos.responses.GetAllCarsResponse;
import com.example.demo.dtos.responses.GetByIdCarResponse;
import com.example.demo.entities.concretes.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = this.carRepository.findAll();

        return cars.stream().map(car ->
                this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        return this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

        this.carRepository.save(car);
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);

        this.carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }
}
