package br.com.maelton.learning_jpa.dao;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.model.Categoria;

public class CategoriaDao {
    
    private EntityManager em;

    public void insertCategoria(Categoria categoria) {
        this.em.getTransaction().begin();
            em.persist(categoria);
        this.em.getTransaction().commit();
    }

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
}
