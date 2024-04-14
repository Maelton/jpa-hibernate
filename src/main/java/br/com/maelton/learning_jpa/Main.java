package br.com.maelton.learning_jpa;

import br.com.maelton.learning_jpa.controller.ProdutoController;
import br.com.maelton.learning_jpa.model.Produto;

public class Main {
    public static void main(String[] args) {
        
        Produto cafe = new Produto();
            cafe.setNome("Cafe Santa Clara");
            cafe.setDescricao("Cafe Torrado e Moido Santa Clara Classico Pacote de 500g");
            cafe.setPreco(17.99);
        
        ProdutoController.cadastrarProduto(cafe);
    }
}