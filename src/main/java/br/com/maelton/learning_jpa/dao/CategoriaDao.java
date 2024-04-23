package br.com.maelton.learning_jpa.dao;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.model.Categoria;

public class CategoriaDao {
    
    private EntityManager persistenceContext;

    public void insertCategoria(Categoria categoria) {
        this.persistenceContext.getTransaction().begin();
            persistenceContext.persist(categoria);
        this.persistenceContext.getTransaction().commit();
    }

    public void deleteCategoria(Categoria categoria) {
        this.persistenceContext.getTransaction().begin();
            //garantindo status managed do objeto
            categoria = this.persistenceContext.merge(categoria);

            this.persistenceContext.remove(categoria);
        this.persistenceContext.getTransaction().commit();
    }

    public CategoriaDao(EntityManager persistenceContext) {
        this.persistenceContext = persistenceContext;
    }
}
