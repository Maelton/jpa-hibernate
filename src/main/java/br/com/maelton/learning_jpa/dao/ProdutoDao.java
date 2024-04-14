package br.com.maelton.learning_jpa.dao;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.model.Produto;

public class ProdutoDao {
    
    private EntityManager em;

    public void insertProduto(Produto produto) {
        this.em.getTransaction().begin();
            this.em.persist(produto);
        this.em.getTransaction().commit();
    }
    
    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
}
