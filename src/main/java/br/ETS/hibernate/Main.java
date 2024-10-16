package br.ETS.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PostRemove;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        MaterialDAO materialDAO = new MaterialDAO(entityManager);

        var buscaFornecedorPorNome = materialDAO.buscaPorFornecedor("LeoStore");
        System.out.println(buscaFornecedorPorNome);

//        Categoria escritorio = new Categoria("ESCRITORIO");
//        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
//        Material material = new Material(new MaterialDTO("Caneta", "Só Canetas", 600, escritorio));




    }
}