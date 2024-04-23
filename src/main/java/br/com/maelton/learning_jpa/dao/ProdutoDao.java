package br.com.maelton.learning_jpa.dao;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.model.Produto;

public class ProdutoDao {
    
    private EntityManager persistenceContext;

    public void insertProduto(Produto produto) {
        this.persistenceContext.getTransaction().begin();
            this.persistenceContext.persist(produto);
        this.persistenceContext.getTransaction().commit();
    }

    public void deleteProduto(Produto produto) {
        this.persistenceContext.getTransaction().begin();
            //garantindo status managed do objeto
            produto = this.persistenceContext.merge(produto);

            this.persistenceContext.remove(produto);
        this.persistenceContext.getTransaction().commit();
    }
    
    public ProdutoDao(EntityManager persistenceContext) {
        this.persistenceContext = persistenceContext;
    }
}
