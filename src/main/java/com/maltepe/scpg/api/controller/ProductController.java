package com.maltepe.scpg.api.controller;

import com.maltepe.scpg.business.abstracts.ProductService;
import com.maltepe.scpg.core.result.DataResult;
import com.maltepe.scpg.core.result.ErrorResult;
import com.maltepe.scpg.core.result.Result;
import com.maltepe.scpg.entities.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController  @RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        DataResult<List<Product>> productDataResult = this.productService.getAll();

        if (productDataResult.isSuccess())
            return new ResponseEntity<>(productDataResult, HttpStatus.OK);
        else return new ResponseEntity<>(new ErrorResult(productDataResult.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getbyid")
    public DataResult<Product> getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @GetMapping("getbyname")
    DataResult<List<Product>> getByName(@RequestParam String name){
        return this.productService.getByName(name);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getallbycategory")
    public ResponseEntity<?> getAllByCategory(@RequestParam String categoryName){
        DataResult<List<Product>> productDataResult = this.productService.getAllByCategory(categoryName);

        if (productDataResult.isSuccess())
            return new ResponseEntity<>(productDataResult, HttpStatus.OK);
        else return new ResponseEntity<>(new ErrorResult(productDataResult.getMessage()),HttpStatus.BAD_REQUEST);
    }


}
