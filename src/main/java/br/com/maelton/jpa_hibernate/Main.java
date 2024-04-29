package br.com.maelton.jpa_hibernate;

import br.com.maelton.jpa_hibernate.controller.CategoryController;
import br.com.maelton.jpa_hibernate.controller.ProductController;
import br.com.maelton.jpa_hibernate.model.Category;
import br.com.maelton.jpa_hibernate.model.Product;

public class Main {
    public static void main(String[] args) {
        
        Category grains = new Category("Grains");
        Category personalCare = new Category("Personal Care");

        Product rice = new Product(
            "Nishiki Rice", 
            "Nishiki is a premium medium grain rice grown with the rich soil and crystal clear water of California.", 
            2.46, 
            grains
        );

        Product quinoa = new Product(
            "Success Boil-In-Bag Quinoa", 
            "Our Success quinoa bags have you prepared with our natural, nutty quinoa grain! Cook quick and tasty quinoa that any meat lover, vegan, or vegetarian will enjoy.", 
            11.12, 
            grains
        );

        Product shampoo = new Product(
            "Head & Shoulders Supreme Dandruff Shampoo", 
            "With Argan Oil, Anti Dandruff Scalp Treatment, Sulfate Free, Soothes Scalp, Deep Moisturization, Controls Itch, Natural Rose Essence", 
            23.83, 
            personalCare
        );

        CategoryController.registerCategory(grains);
        CategoryController.registerCategory(personalCare);

        ProductController.registerProduct(rice);
        ProductController.registerProduct(quinoa);
        ProductController.registerProduct(shampoo);
        
        System.out.println(
            CategoryController.selectCategories()
        );

        System.out.println(
            ProductController.selectProducts()
        );

        System.out.println(
            ProductController.selectProductById(2)
        );

        System.out.println(
            CategoryController.selectCategoryById(1)
        );

        System.out.println(
            CategoryController.selectCategoryByName("Personal Care")
        );

        System.out.println(
            ProductController.selectProductByCategoryName("Grains")
        );

        System.out.println(
            ProductController.selectProductPriceById(3)
        );

        ProductController.deleteProduct(quinoa);

        System.out.println(
            ProductController.selectProducts()
        );
    }
}