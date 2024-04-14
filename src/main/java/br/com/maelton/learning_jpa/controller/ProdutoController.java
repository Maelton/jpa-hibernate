package br.com.maelton.learning_jpa.controller;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.dao.ProdutoDao;
import br.com.maelton.learning_jpa.model.Produto;
import br.com.maelton.learning_jpa.util.JPAUtil;

public class ProdutoController {

    private static EntityManager em = JPAUtil.getEntityManager();
    private static ProdutoDao dao = new ProdutoDao(em);

    public static void cadastrarProduto(Produto produto) {
        dao.insertProduto(produto);
    }
}
