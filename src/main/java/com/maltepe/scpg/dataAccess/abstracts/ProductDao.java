package com.maltepe.scpg.dataAccess.abstracts;

import com.maltepe.scpg.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    List<Product> getAllByProductName(String name);

    Product findById(int id);

    List<Product> getAllByCategory_CategoryName(String categoryName);



}
