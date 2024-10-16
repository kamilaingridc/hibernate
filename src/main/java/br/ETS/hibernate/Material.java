package br.ETS.hibernate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TbMateriaisIndiretos")
public class Material {

    public Material(MaterialDTO materialDTO){
        this.nome = materialDTO.nome();
        this.fornecedor = materialDTO.fornecedor();
        this.quantidade = materialDTO.quantidade();
        this.categoria = materialDTO.categoria();
    }
    public Material(){

    }

    // atributos da entidade
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(name = "forn")
    private String fornecedor;
    private int quantidade;
    private LocalDate dataCadastro = LocalDate.now();
    @ManyToOne
    private Categoria categoria;

    // getter e setter
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