package com.maltepe.scpg.business.concretes;

import com.maltepe.scpg.business.abstracts.CategoryService;
import com.maltepe.scpg.core.result.DataResult;
import com.maltepe.scpg.core.result.SuccessDataResult;
import com.maltepe.scpg.dataAccess.abstracts.CategoryDao;
import com.maltepe.scpg.entities.concretes.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;

    @Override
    public DataResult<List<Category>> getAll() {
        List<Category> categories = this.categoryDao.findAll();
        return new SuccessDataResult<>(categories,"Categories Listed");
    }

    @Override
    public DataResult<Category> getById(int id) {
        Category category = this.categoryDao.getById(id);

        return new SuccessDataResult<>(category,category.getCategoryName()+" listed");
    }
}
