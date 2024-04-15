package br.com.maelton.learning_jpa.controller;

import br.com.maelton.learning_jpa.dao.ProdutoDao;
import br.com.maelton.learning_jpa.model.Produto;
import br.com.maelton.learning_jpa.util.JPAUtil;

public class ProdutoController {

    private static ProdutoDao dao = new ProdutoDao(JPAUtil.getEntityManager());

    public static void cadastrarProduto(Produto produto) {
        dao.insertProduto(produto);
    }
}
