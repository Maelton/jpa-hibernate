package br.com.maelton.jpa_hibernate.dao;

import java.util.List;

import jakarta.persistence.EntityManager;

import br.com.maelton.jpa_hibernate.model.Category;
import br.com.maelton.jpa_hibernate.util.JPAUtil;

public class CategoryDao {

    public static void insert(Category category) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                em.persist(category);
            em.getTransaction().commit();
        }
    }

    public static void delete(Category category) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                //making sure the object is managed (managed status)
                category = em.merge(category);
                em.remove(category);
            em.getTransaction().commit();
        }
    }

    public static Category select(int id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
                Category category = em.find(Category.class, id);
            em.getTransaction().commit();

            return category;
        }
    }

    public static List<Category> selectAll() {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String JPQL = "SELECT c FROM Category c";
            em.getTransaction().begin();
                List<Category> categories = em.createQuery(JPQL, Category.class).getResultList();
            em.getTransaction().commit();

            return categories;
        }
    }

    public static List<Category> selectByName(String name) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String JPQL = "SELECT c FROM Category c WHERE c.name = :name";
            em.getTransaction().begin();
                List<Category> categories = em.createQuery(JPQL, Category.class).setParameter("name", name).getResultList();
            em.getTransaction().commit();

            return categories;
        }
    }

    public static String selectName(int id) {
        try(EntityManager em = JPAUtil.getEntityManager()) {
            String JPQL = "SELECT c.name FROM Category c WHERE c.id = ?1";
            em.getTransaction().begin();
                String name = em.createQuery(JPQL, String.class)
                                .setParameter(1, id)
                                .getSingleResult();
            em.getTransaction().commit();

            return name;
        }
    }
}
