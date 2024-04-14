package br.com.maelton.learning_jpa;

import br.com.maelton.learning_jpa.controller.ProdutoController;
import br.com.maelton.learning_jpa.model.Produto;

public class Main {
    public static void main(String[] args) {
        ProdutoController.createProduto(new Produto());
    }
}