package br.com.maelton.jpa_hibernate.controller;

import br.com.maelton.jpa_hibernate.dao.CategoryDao;
import com.google.gson.Gson;

import br.com.maelton.jpa_hibernate.model.Category;

public class CategoryController {

    public static void registerCategory(Category category) {
        CategoryDao.insert(category);
    }

    public static void deletarCategoria(Category category) {
        CategoryDao.delete(category);
    }

    public static String selectCategoryById(int id) {
        Category category = CategoryDao.select(id);

        return "{\n" +
                "    id: " + category.getId() + "\n" +
                "    name: " + category.getName() + "\n}";
    }

    public static String selectCategories() {
        return new Gson().toJson(CategoryDao.selectAll());
    }

    public static String selectCategoryByName(String name) {
        return new Gson().toJson(CategoryDao.selectByName(name));
    }

    public static String selectCategoryNameById(int id) {
        return CategoryDao.selectName(id);
    }
}
