package br.com.maelton.learning_jpa.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.maelton.learning_jpa.model.Produto;

public class ProdutoController {

    public static void createProduto(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
            em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    /**
    public static void createProduto(Produto produto) {
        EntityManagerService.manager().getTransaction().begin();
            EntityManagerService.manager().persist(produto);
        EntityManagerService.manager().getTransaction().commit();
    } */
}
