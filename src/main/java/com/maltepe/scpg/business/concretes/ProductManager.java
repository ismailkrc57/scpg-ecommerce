package com.maltepe.scpg.business.concretes;

import com.maltepe.scpg.business.abstracts.ProductService;
import com.maltepe.scpg.dataAccess.abstracts.ProductDao;
import com.maltepe.scpg.entities.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;


    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public Product getById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getByName(String name) {
        return this.productDao.getAllByProductName(name);
    }


}
