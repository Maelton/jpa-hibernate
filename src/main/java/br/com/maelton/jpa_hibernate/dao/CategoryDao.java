package br.com.maelton.jpa_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.maelton.jpa_hibernate.model.Category;

public class CategoryDao {
    
    private EntityManager persistenceContext;

    public void insert(Category category) {
        this.persistenceContext.getTransaction().begin();
            persistenceContext.persist(category);
        this.persistenceContext.getTransaction().commit();
    }

    public void delete(Category category) {
        this.persistenceContext.getTransaction().begin();
            //making sure the object is managed (managed status)
            category = this.persistenceContext.merge(category);

            this.persistenceContext.remove(category);
        this.persistenceContext.getTransaction().commit();
    }

    public Category select(int id) {
        return this.persistenceContext.find(Category.class, id);
    }

    public List<Category> selectAll() {
        String JPQL = "SELECT c FROM Category c";
        return this.persistenceContext.createQuery(JPQL, Category.class).getResultList();
    }

    public List<Category> selectByName(String name) {
        String JPQL = "SELECT c FROM Category c WHERE c.name = :name";
        return this.persistenceContext
                    .createQuery(JPQL, Category.class)
                    .setParameter("name", name)
                    .getResultList();
    }

    public String selectName(int id) {
        String JPQL = "SELECT c.name FROM Category c WHERE c.id = ?1";

        return this.persistenceContext.createQuery(JPQL, String.class)
                    .setParameter(1, id)
                    .getSingleResult();
    }

    public CategoryDao(EntityManager persistenceContext) {
        this.persistenceContext = persistenceContext;
    }
}
