package br.com.maelton.learning_jpa.controller;

import br.com.maelton.learning_jpa.dao.CategoriaDao;
import br.com.maelton.learning_jpa.model.Categoria;
import br.com.maelton.learning_jpa.util.JPAUtil;

public class CategoriaController {
    
    private static CategoriaDao dao = new CategoriaDao(JPAUtil.getEntityManager());

    public static void cadastrarCategoria(Categoria categoria) {
        dao.insertCategoria(categoria);
    }
}
