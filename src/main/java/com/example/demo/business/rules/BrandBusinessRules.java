package com.example.demo.business.rules;

import com.example.demo.core.utilities.exceptions.BusinessException;
import com.example.demo.dataAccess.abstracts.BrandRepository;
import com.example.demo.entities.concretes.Brand;
import org.springframework.stereotype.Service;

@Service // injection yapıyoruz, new yapmadığımız için spring ioc'ye yerleşiyor
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand Already Exists");
        }
    }
}
