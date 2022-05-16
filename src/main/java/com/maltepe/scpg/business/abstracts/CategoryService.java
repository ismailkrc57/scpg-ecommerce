package com.maltepe.scpg.business.abstracts;

import com.maltepe.scpg.core.result.DataResult;
import com.maltepe.scpg.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
}
