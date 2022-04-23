package com.maltepe.scpg.api.controller;

import com.maltepe.scpg.business.abstracts.ProductService;
import com.maltepe.scpg.entities.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController  @RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getbyid")
    public Product getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @GetMapping("getbyname")
    List<Product> getByName(@RequestParam String name){
        return this.productService.getByName(name);
    }
    
}
