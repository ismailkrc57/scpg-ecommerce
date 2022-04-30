package com.maltepe.scpg.business.concretes;

import com.maltepe.scpg.business.abstracts.ProductService;
import com.maltepe.scpg.core.result.*;
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
    public DataResult<List<Product>> getAll() {
        List<Product> products = this.productDao.findAll();
        return new SuccessDataResult<>(products, "Products Listed");
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product product = this.productDao.findById(id);
        if (product != null)
            return new SuccessDataResult<>(product, "Product Listed");
        else
            return new ErrorDataResult<>("Veri bulunamadı");
    }

    @Override
    public DataResult<List<Product>> getByName(String name) {
        List<Product> products = this.productDao.getAllByProductName(name);
        if (!products.isEmpty())
            return new SuccessDataResult<>(products, "Products Listed by Name");
        else
            return new ErrorDataResult<>("There is no product in database with this name");
    }

    @Override
    public Result add(Product product) {
        if (product.getUnitPrice()>=35000)
            return new ErrorResult("the Unit Price Must be less than 35000");

        this.productDao.save(product);
        return new SuccessResult(product.getProductName() + " added to database");
    }


}
