package br.ETS.hibernate;

import javax.persistence.EntityManager; // Importa a classe EntityManager para gerenciar entidades

public class Main {
    public static void main(String[] args) {
        // Obtém uma nova instância de EntityManager utilizando JPAUtil
        EntityManager entityManager = JPAUtil.getEntityManager();

        // Cria uma instância do MaterialDAO, passando o EntityManager
        MaterialDAO materialDAO = new MaterialDAO(entityManager);

        // Busca o fornecedor pelo nome
        var precoPorNome = materialDAO.buscaFornecedorPorNome("LeoStore");

        // Imprime o resultado da busca
        System.out.println(precoPorNome);

        // Fecha o EntityManager para liberar recursos
        entityManager.close(); // Certifique-se de fechar o EntityManager ao final do uso
    }
}
