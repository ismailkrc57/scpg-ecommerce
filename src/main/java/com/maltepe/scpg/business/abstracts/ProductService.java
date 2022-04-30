package com.maltepe.scpg.business.abstracts;

import com.maltepe.scpg.core.result.DataResult;
import com.maltepe.scpg.core.result.Result;
import com.maltepe.scpg.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);
    DataResult<List<Product>> getByName(String name);
    Result add(Product product);
}
