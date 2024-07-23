package br.com.maelton.jpa_hibernate.controller;

import br.com.maelton.jpa_hibernate.dao.ProductDao;
import com.google.gson.Gson;

import br.com.maelton.jpa_hibernate.model.Product;

public class ProductController {

    public static void registerProduct(Product product) {
        ProductDao.insert(product);
    }

    public static void deleteProduct(Product product) {
        ProductDao.delete(product);
    }

    public static String selectProductById(int id) {
        Product product = ProductDao.select(id);

        return "{\n" +
                "    id: " + product.getId() + "\n" +
                "    name: " + product.getName() + "\n"  + 
                "    price: " + product.getPrice() + "\n"  +
                "    description: " + product.getDescription() + "\n}";
    }

    public static String selectProducts() {
        return new Gson().toJson(ProductDao.selectAll());
    }

    public static String selectProductByName(String name) {
        return new Gson().toJson(ProductDao.selectByName(name));
    }

    public static String selectProductByCategoryName(String name) {
        return new Gson().toJson(ProductDao.selectByCategory(name));
    }

    public static Double selectProductPriceById(int id) {
        return ProductDao.selectPrice(id);
    }
}
