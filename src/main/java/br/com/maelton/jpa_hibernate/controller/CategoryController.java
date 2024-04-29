package br.com.maelton.jpa_hibernate.controller;

import com.google.gson.Gson;

import br.com.maelton.jpa_hibernate.dao.CategoryDao;
import br.com.maelton.jpa_hibernate.model.Category;
import br.com.maelton.jpa_hibernate.util.JPAUtil;

public class CategoryController {
    
    private static CategoryDao DAO = new CategoryDao(JPAUtil.getEntityManager());

    public static void registerCategory(Category category) {
        DAO.insert(category);
    }

    public static void deletarCategoria(Category category) {
        DAO.delete(category);
    }

    public static String selectCategoryById(int id) {
        Category category = DAO.select(id);

        return "{\n" +
                "    id: " + category.getId() + "\n" +
                "    name: " + category.getName() + "\n}";
    }

    public static String selectCategories() {
        return new Gson().toJson(DAO.selectAll());
    }

    public static String selectCategoryByName(String name) {
        return new Gson().toJson(DAO.selectByName(name));
    }

    public static String selectCategoryNameById(int id) {
        return DAO.selectName(id);
    }
}
