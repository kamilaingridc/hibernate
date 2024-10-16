package br.ETS.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "tbcategorias")
public class Categoria {
    // atributos da entidade
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Categoria() {

    }
    public Categoria(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}