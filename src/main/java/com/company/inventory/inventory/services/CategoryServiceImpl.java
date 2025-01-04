package com.company.inventory.inventory.services;

import com.company.inventory.inventory.dao.ICategoryDao;
import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest response = new CategoryResponseRest();
        try {
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata(
                    "Respuesta OK",
                    "00",
                    "Respuesta Exitosa");
        } catch (Exception e) {
            response.setMetadata(
                    "Error",
                    "01",
                    "Error en la búsqueda");
            e.getStackTrace();
            return new ResponseEntity<>(response,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
