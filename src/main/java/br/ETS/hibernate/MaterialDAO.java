package br.ETS.hibernate;

import br.ETS.hibernate.Material;

import javax.persistence.EntityManager;
import java.util.List;

// Classe responsável pelas operações de acesso a dados da entidade Material
public class MaterialDAO {
    private EntityManager entityManager; // Gerenciador de entidades JPA

    // Construtor que recebe um EntityManager para operações de persistência
    public MaterialDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Método para cadastrar um novo material no banco de dados
    public void cadastrar(Material material) {
        entityManager.getTransaction().begin(); // Inicia a transação
        this.entityManager.persist(material); // Persiste o objeto material
        entityManager.getTransaction().commit(); // Comita a transação
        entityManager.close(); // Fecha o EntityManager
    }

    // Método para atualizar um material existente no banco de dados
    public void atualizar(Material material) {
        entityManager.getTransaction().begin(); // Inicia a transação
        this.entityManager.merge(material); // Mescla o objeto material
        entityManager.getTransaction().commit(); // Comita a transação
        entityManager.close(); // Fecha o EntityManager
    }

    // Método para remover um material do banco de dados
    public void remover(Material material) {
        entityManager.getTransaction().begin(); // Inicia a transação
        material = entityManager.merge(material); // Mescla o objeto material para garantir que está gerenciado
        this.entityManager.remove(material); // Remove o objeto material
        entityManager.getTransaction().commit(); // Comita a transação
        entityManager.close(); // Fecha o EntityManager
    }

    // Método para buscar um material pelo ID
    public Material buscaPorID(int id) {
        /*-----------------------------------------------------------------*/
        /* Alterando o método para lançar exceção se o material não for encontrado */
        var material = this.entityManager.find(Material.class, id); // Busca o material pelo ID
        if (material != null) {
            return material; // Retorna o material encontrado
        } else {
            throw new RuntimeException("Material com esse id não foi encontrado"); // Lança exceção se não encontrado
        }
        /*-----------------------------------------------------------------*/
    }

    // Método para ler todos os materiais da tabela
    public List<Material> lerDadosTabela() {
        String jpql = "SELECT m FROM Material m"; // JPQL para selecionar todos os materiais
        return entityManager.createQuery(jpql, Material.class).getResultList(); // Retorna a lista de materiais
    }

    // Método para buscar materiais por categoria
    public List<Material> buscaPorCategoria(String nome) {
        String jpql = "SELECT m FROM Material m WHERE m.categoria.nome = :nome"; // JPQL para buscar por categoria
        return entityManager.createQuery(jpql, Material.class)
                .setParameter("nome", nome) // Define o parâmetro da consulta
                .getResultList(); // Retorna a lista de materiais encontrados
    }

    // Método para buscar materiais por nome
    public List<Material> buscaPorNome(String nome) {
        String jpql = "SELECT m FROM Material m WHERE m.nome = :nome"; // JPQL para buscar por nome
        return entityManager.createQuery(jpql, Material.class)
                .setParameter("nome", nome) // Define o parâmetro da consulta
                .getResultList(); // Retorna a lista de materiais encontrados
    }

    // Método para buscar o fornecedor de um material pelo nome
    public String buscaFornecedorPorNome(String nome) {
        String jpql = "SELECT m.fornecedor FROM Material m WHERE m.nome = :nome";
        List<String> resultado = entityManager.createQuery(jpql, String.class)
                .setParameter("nome", nome)
                .getResultList();

        if (resultado.isEmpty()) {
            return "Fornecedor não encontrado"; // ou lançar uma exceção personalizada
        } else {
            return resultado.get(0);
        }
    }
}
