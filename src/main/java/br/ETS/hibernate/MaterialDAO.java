package br.ETS.hibernate;

import org.hibernate.annotations.GenerationTime;

import javax.persistence.EntityManager;
import java.util.List;

public class MaterialDAO {
    private EntityManager entityManager;

    public MaterialDAO() {
    }

    public MaterialDAO (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Material material){
        entityManager.getTransaction().begin();
        this.entityManager.persist(material);
        entityManager.getTransaction().commit();

    }

    public void atualizar(Material material){
        entityManager.getTransaction().begin();
        this.entityManager.merge(material);
        entityManager.getTransaction().commit();

    }

    public void remover(Material material){
        entityManager.getTransaction().begin();
        material = entityManager.merge(material);
        this.entityManager.remove(material);
        entityManager.getTransaction().commit();

    }

    public Material buscaPorId(int id){
        var material = this.entityManager.find(Material.class, id);
        if (material != null){
            return material;
        } else {
            throw new RuntimeException("Material com esse id não foi encontrado");
        }
    }

    public List<Material> lerDadosTabela(){
        String jpql = "SELECT m FROM Material m";
        return entityManager.createQuery(jpql, Material.class).getResultList();
    }

    public List<Material> buscaPorCategoria(String nome){
        String jpql = "SELECT m FROM Material m WHERE m.categoria.nome = :nome ";
        return entityManager.createQuery(jpql, Material.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Material> buscaPorNome(String nome){
        String jpql = "SELECT m FROM Material m WHERE m.nome = :nome ";
        return entityManager.createQuery(jpql, Material.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public String buscaPorFornecedor(String nome){
        String jpql = "SELECT m.fornecedor FROM Material m WHERE m.nome = :nome ";
        return entityManager.createQuery(jpql, String.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

}