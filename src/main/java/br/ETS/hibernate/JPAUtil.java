package br.ETS.hibernate;

import javax.persistence.EntityManager; // Importa a classe EntityManager para gerenciar entidades
import javax.persistence.EntityManagerFactory; // Importa a classe EntityManagerFactory para criar EntityManagers
import javax.persistence.Persistence; // Importa a classe Persistence para gerenciar a persistência

public class JPAUtil {
    // Cria uma única instância de EntityManagerFactory, que será compartilhada por toda a aplicação
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("almoxarifado");

    // Método para obter uma nova instância de EntityManager
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager(); // Cria e retorna um novo EntityManager
    }
}
