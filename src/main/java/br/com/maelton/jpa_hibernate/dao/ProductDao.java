package br.com.maelton.jpa_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.maelton.jpa_hibernate.model.Product;

public class ProductDao {
    
    private EntityManager persistenceContext;

    public void insert(Product product) {
        this.persistenceContext.getTransaction().begin();
            this.persistenceContext.persist(product);
        this.persistenceContext.getTransaction().commit();
    }

    public void delete(Product product) {
        this.persistenceContext.getTransaction().begin();
            //making sure the object is managed (managed status)
            product = this.persistenceContext.merge(product);

            this.persistenceContext.remove(product);
        this.persistenceContext.getTransaction().commit();
    }

    public Product select(int id) {
        return this.persistenceContext.find(Product.class, id);
    }

    public List<Product> selectAll() {
        String JPQL = "SELECT p FROM Product p";
        return this.persistenceContext.createQuery(JPQL, Product.class).getResultList();
    }

    public List<Product> selectByName(String name) {
        String JPQL = "SELECT p FROM Product p WHERE p.name = :name";
        return this.persistenceContext
                    .createQuery(JPQL, Product.class)
                    .setParameter("name", name)
                    .getResultList();
    }

    public List<Product> selectByCategory(String categoryName) {
        //bye JOIN(), JPQL is Object Oriented, JPQL is amazing
        String JPQL = "SELECT p FROM Product p WHERE p.category.name = :name";
        return this.persistenceContext.createQuery(JPQL, Product.class)
                    .setParameter("name", categoryName)
                    .getResultList();
    }

    public Double selectPrice(int productId) {
        String JPQL = "SELECT p.price FROM Product p WHERE p.id = ?1";

        return this.persistenceContext.createQuery(JPQL, Double.class)
                    .setParameter(1, productId)
                    .getSingleResult();
    }
    
    public ProductDao(EntityManager persistenceContext) {
        this.persistenceContext = persistenceContext;
    }
}
