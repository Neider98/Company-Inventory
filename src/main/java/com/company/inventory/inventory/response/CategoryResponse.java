package com.company.inventory.inventory.response;

import com.company.inventory.inventory.model.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryResponse {

    private List<Category> category = new ArrayList<>();


}
