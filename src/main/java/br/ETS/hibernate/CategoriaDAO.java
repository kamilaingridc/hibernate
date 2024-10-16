package br.ETS.hibernate;

import javax.persistence.EntityManager; // Importa a classe EntityManager para gerenciar entidades
import javax.persistence.EntityTransaction; // Importa a classe EntityTransaction para gerenciar transações
import java.util.List; // Importa a classe List para manipulação de listas

public class CategoriaDAO {
    private EntityManager entityManager; // Declara um EntityManager para operações de banco de dados

    // Construtor que recebe um EntityManager para inicialização
    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para cadastrar uma nova categoria
    public void cadastrar(Categoria categoria) {
        EntityTransaction transaction = entityManager.getTransaction(); // Obtém a transação atual
        try {
            transaction.begin(); // Inicia a transação
            entityManager.persist(categoria); // Persiste a nova categoria no banco de dados
            transaction.commit(); // Confirma a transação
        } catch (Exception e) {
            // Em caso de erro, reverte a transação
            if (transaction.isActive()) {
                transaction.rollback(); // Reverte a transação se estiver ativa
            }
            e.printStackTrace(); // Imprime o erro no console (ou pode usar um logger)
        }
    }

    // Método para atualizar uma categoria existente
    public void atualizar(Categoria categoria) {
        EntityTransaction transaction = entityManager.getTransaction(); // Obtém a transação atual
        try {
            transaction.begin(); // Inicia a transação
            entityManager.merge(categoria); // Atualiza a categoria no banco de dados
            transaction.commit(); // Confirma a transação
        } catch (Exception e) {
            // Em caso de erro, reverte a transação
            if (transaction.isActive()) {
                transaction.rollback(); // Reverte a transação se estiver ativa
            }
            e.printStackTrace(); // Imprime o erro no console
        }
    }

    // Método para remover uma categoria
    public void remover(Categoria categoria) {
        EntityTransaction transaction = entityManager.getTransaction(); // Obtém a transação atual
        try {
            transaction.begin(); // Inicia a transação
            categoria = entityManager.merge(categoria); // Mescla a categoria para garantir que está gerenciada
            entityManager.remove(categoria); // Remove a categoria do banco de dados
            transaction.commit(); // Confirma a transação
        } catch (Exception e) {
            // Em caso de erro, reverte a transação
            if (transaction.isActive()) {
                transaction.rollback(); // Reverte a transação se estiver ativa
            }
            e.printStackTrace(); // Imprime o erro no console
        }
    }

    // Método para buscar uma categoria pelo ID
    public Categoria buscaPorID(int id) {
        return entityManager.find(Categoria.class, id); // Retorna a categoria correspondente ao ID fornecido
    }

    // Método para ler todas as categorias da tabela
    public List<Categoria> lerDadosTabela() {
        String jpql = "SELECT c FROM Categoria c"; // JPQL para selecionar todas as categorias
        return entityManager.createQuery(jpql, Categoria.class).getResultList(); // Executa a consulta e retorna a lista de categorias
    }
}
