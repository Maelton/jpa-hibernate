package br.com.maelton.jpa_hibernate.dao;

import java.util.List;

import br.com.maelton.jpa_hibernate.util.JPAUtil;
import jakarta.persistence.EntityManager;

import br.com.maelton.jpa_hibernate.model.Product;

public class ProductDao {

    public static void insert(Product product) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                em.persist(product);
            em.getTransaction().commit();
        }
    }

    public static void delete(Product product) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                //making sure the object is managed (managed status)
                product = em.merge(product);
                em.remove(product);
            em.getTransaction().commit();
        }
    }

    public static Product select(int id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                Product product = em.find(Product.class, id);
            em.getTransaction().commit();

            return product;
        }
    }

    public static List<Product> selectAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String JPQL = "SELECT p FROM Product p";
            em.getTransaction().begin();
                List<Product> products = em.createQuery(JPQL, Product.class).getResultList();
            em.getTransaction().commit();

            return products;
        }
    }

    public static List<Product> selectByName(String name) {
        String JPQL = "SELECT p FROM Product p WHERE p.name = :name";
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                List<Product> products = em.createQuery(JPQL, Product.class).setParameter("name", name).getResultList();
            em.getTransaction().commit();

            return products;
        }
    }

    public static List<Product> selectByCategory(String categoryName) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            //bye JOIN(), JPQL is Object Oriented, JPQL is amazing
            String JPQL = "SELECT p FROM Product p WHERE p.category.name = :name";

            em.getTransaction().begin();
                List<Product> products = em.createQuery(JPQL, Product.class).setParameter("name", categoryName).getResultList();
            em.getTransaction().commit();

            return products;

        }
    }

    public static Double selectPrice(int productId) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String JPQL = "SELECT p.price FROM Product p WHERE p.id = ?1";
            em.getTransaction().begin();
                Double price = em.createQuery(JPQL, Double.class).setParameter(1, productId).getSingleResult();
            em.getTransaction().commit();

            return price;
        }
    }
}
