package br.ETS.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "TbMateriaisIndiretos")
public class Material {

    public Material(MaterialDTO materialDTO){
        this.nome = materialDTO.nome();
        this.fornecedor = materialDTO.fornecedor();
        this.quantidade = materialDTO.quantidade();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(name = "Forn")
    private String fornecedor;

    private int quantidade;

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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}


