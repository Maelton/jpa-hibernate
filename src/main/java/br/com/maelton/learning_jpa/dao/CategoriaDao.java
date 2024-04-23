package br.com.maelton.learning_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.maelton.learning_jpa.model.Categoria;

public class CategoriaDao {
    
    private EntityManager persistenceContext;

    public void insertCategoria(Categoria categoria) {
        this.persistenceContext.getTransaction().begin();
            persistenceContext.persist(categoria);
        this.persistenceContext.getTransaction().commit();
    }

    public void deleteCategoria(Categoria categoria) {
        this.persistenceContext.getTransaction().begin();
            //garantindo status managed do objeto
            categoria = this.persistenceContext.merge(categoria);

            this.persistenceContext.remove(categoria);
        this.persistenceContext.getTransaction().commit();
    }

    public Categoria selectCategoriaById(int id) {
        return this.persistenceContext.find(Categoria.class, id);
    }

    public List<Categoria> selectAll() {
        String JPQL = "SELECT categorias FROM Categoria categorias";
        return this.persistenceContext.createQuery(JPQL, Categoria.class).getResultList();
    }

    public List<Categoria> selectCategoriaByNome(String nome) {
        String JPQL = "SELECT categorias FROM Categoria categorias WHERE categorias.nome = :nome";
        return this.persistenceContext
                    .createQuery(JPQL, Categoria.class)
                    .setParameter("nome", nome)
                    .getResultList();
    }

    public String selectNomeById(int id) {
        String JPQL = 
        "SELECT categoria.nome FROM Categoria categoria WHERE categoria.id = ?1";

        return this.persistenceContext.createQuery(JPQL, String.class)
                    .setParameter(1, id)
                    .getSingleResult();
    }

    public CategoriaDao(EntityManager persistenceContext) {
        this.persistenceContext = persistenceContext;
    }
}
