package br.com.maelton.jpa_hibernate.controller;

import com.google.gson.Gson;

import br.com.maelton.jpa_hibernate.dao.ProductDao;
import br.com.maelton.jpa_hibernate.model.Product;
import br.com.maelton.jpa_hibernate.util.JPAUtil;

public class ProductController {

    private static ProductDao DAO = new ProductDao(JPAUtil.getEntityManager());

    public static void registerProduct(Product product) {
        DAO.insert(product);
    }

    public static void deleteProduct(Product product) {
        DAO.delete(product);
    }

    public static String selectProductById(int id) {
        Product product = DAO.select(id);

        return "{\n" +
                "    id: " + product.getId() + "\n" +
                "    name: " + product.getName() + "\n"  + 
                "    price: " + product.getPrice() + "\n"  +
                "    description: " + product.getDescription() + "\n}";
    }

    public static String selectProducts() {
        return new Gson().toJson(DAO.selectAll());
    }

    public static String selectProductByName(String name) {
        return new Gson().toJson(DAO.selectByName(name));
    }

    public static String selectProductByCategoryName(String name) {
        return new Gson().toJson(DAO.selectByCategory(name));
    }

    public static Double selectProductPriceById(int id) {
        return DAO.selectPrice(id);
    }
}
