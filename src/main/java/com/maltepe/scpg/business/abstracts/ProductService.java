package com.maltepe.scpg.business.abstracts;

import com.maltepe.scpg.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getByName(String name);
}
