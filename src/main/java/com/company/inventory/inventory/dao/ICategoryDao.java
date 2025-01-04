package com.company.inventory.inventory.dao;

import com.company.inventory.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {



}
