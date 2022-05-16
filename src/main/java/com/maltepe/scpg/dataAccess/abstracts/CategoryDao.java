package com.maltepe.scpg.dataAccess.abstracts;

import com.maltepe.scpg.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {



}
