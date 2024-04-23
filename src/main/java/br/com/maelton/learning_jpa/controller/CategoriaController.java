package br.com.maelton.learning_jpa.controller;

import com.google.gson.Gson;

import br.com.maelton.learning_jpa.dao.CategoriaDao;
import br.com.maelton.learning_jpa.model.Categoria;
import br.com.maelton.learning_jpa.util.JPAUtil;

public class CategoriaController {
    
    private static CategoriaDao dao = new CategoriaDao(JPAUtil.getEntityManager());

    public static void cadastrarCategoria(Categoria categoria) {
        dao.insertCategoria(categoria);
    }

    public static void deletarCategoria(Categoria categoria) {
        dao.deleteCategoria(categoria);
    }

    public static String selecionarCategoriaPorID(int id) {
        Categoria categoria = dao.selectCategoriaById(id);

        return "{\n" +
                "    id: " + categoria.getId() + "\n" +
                "    nome: " + categoria.getNome() + "\n}";
    }

    public static String selecionarCategorias() {
        return new Gson().toJson(dao.selectAll());
    }

    public static String selecionarCategoriaPorNome(String nome) {
        return new Gson().toJson(dao.selectCategoriaByNome(nome));
    }

    public static String selecionarNomePorIdCategoria(int id) {
        return dao.selectNomeById(id);
    }
}
