package com.company.inventory.inventory.services;

import com.company.inventory.inventory.dao.ICategoryDao;
import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();
        try {
            Optional<Category> category = categoryDao.findById(id);
            if (category.isPresent()) {
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata(
                        "Respuesta OK",
                        "00",
                        "Categoria encontrada");
            } else {

                response.setMetadata(
                        "Respuesta nOK",
                        "-1",
                        "Categoria no encontrada");
                return new ResponseEntity<>(response,
                        HttpStatus.NOT_FOUND);
            }
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
