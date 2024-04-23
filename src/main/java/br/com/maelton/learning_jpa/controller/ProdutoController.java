package br.com.maelton.learning_jpa.controller;

import com.google.gson.Gson;

import br.com.maelton.learning_jpa.dao.ProdutoDao;
import br.com.maelton.learning_jpa.model.Produto;
import br.com.maelton.learning_jpa.util.JPAUtil;

public class ProdutoController {

    private static ProdutoDao dao = new ProdutoDao(JPAUtil.getEntityManager());

    public static void cadastrarProduto(Produto produto) {
        dao.insertProduto(produto);
    }

    public static void deletarProduto(Produto produto) {
        dao.deleteProduto(produto);
    }

    public static String selecionarProdutoPorID(int id) {
        Produto produto = dao.selectProdutoById(id);

        return "{\n" +
                "    id: " + produto.getId() + "\n" +
                "    nome: " + produto.getNome() + "\n"  + 
                "    preco: " + produto.getPreco() + "\n"  +
                "    descricao: " + produto.getDescricao() + "\n}";
    }

    public static String selecionarProdutos() {
        return new Gson().toJson(dao.selectAll());
    }

    public static String selecionarProdutoPorNome(String nome) {
        return new Gson().toJson(dao.selectProdutoByNome(nome));
    }

    public static String selecionarProdutoPorNomeCategoria(String nome) {
        return new Gson().toJson(dao.selectProdutoByNomeCategoria(nome));
    }

    public static Double selecionarPrecoPorIdProduto(int id) {
        return dao.selectPrecoById(id);
    }
}
