package br.com.maelton.learning_jpa;

import br.com.maelton.learning_jpa.controller.CategoriaController;
import br.com.maelton.learning_jpa.controller.ProdutoController;
import br.com.maelton.learning_jpa.model.Categoria;
import br.com.maelton.learning_jpa.model.Produto;

public class Main {
    public static void main(String[] args) {
        
        Categoria alimentos = new Categoria("Alimentos");
        CategoriaController.cadastrarCategoria(alimentos);

        Produto cafe = new Produto
                        (
                            "Cafe Santa Clara", 
                            "Cafe Torrado e Moido Santa Clara Classico Pacote de 500g",
                            17.99,
                            alimentos
                        );
        ProdutoController.cadastrarProduto(cafe);
        ProdutoController.deletarProduto(cafe);
    }
}