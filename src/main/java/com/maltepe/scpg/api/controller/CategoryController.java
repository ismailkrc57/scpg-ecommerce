package com.maltepe.scpg.api.controller;

import com.maltepe.scpg.business.abstracts.CategoryService;
import com.maltepe.scpg.core.result.DataResult;
import com.maltepe.scpg.core.result.ErrorResult;
import com.maltepe.scpg.core.result.Result;
import com.maltepe.scpg.entities.concretes.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("/getall")
    public ResponseEntity<Result> getAll(){
        DataResult<List<Category>> result =  this.categoryService.getAll();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
