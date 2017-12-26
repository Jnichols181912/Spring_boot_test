package com.example.challenge.web;

import com.example.challenge.domain.Brand;
import com.example.challenge.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController{

    @Autowired
    private BrandService brandService;

    @RequestMapping(
            value= "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public List<Brand> getBrands() {
        return brandService.findAllBrands();
    }

    @RequestMapping(
            value= "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public Brand getBrand(@PathVariable Long id) {
        return brandService.findBrandById(id);
    }

    @RequestMapping(
            value= "",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity addBrand(@RequestBody Brand input) {
        try {
            brandService.saveBrand(input);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
