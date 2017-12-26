package com.example.challenge.service;

import com.example.challenge.domain.Brand;
import com.example.challenge.domain.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Boolean isValid(Brand brand) {
        if (!(brand.getName().length() >= 5 && brand.getName().length()  <= 25)) {
            return false;
        }

        if(!(brand.getDescription().length() >= 5 && brand.getDescription().length()  <= 255)) {
            return false;
        }

        return true;
    }

    public Brand findBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public void saveBrand(Brand input) {
        brandRepository.save(new Brand(input.getName(), input.getDescription()));
    }
}
