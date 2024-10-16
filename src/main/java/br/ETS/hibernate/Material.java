package br.ETS.hibernate;

// Importa as classes necessárias para o mapeamento JPA e manipulação de datas
import java.time.LocalDate;
import javax.persistence.*;

// Indica que esta classe é uma entidade JPA
@Entity
// Define o nome da tabela no banco de dados
@Table(name = "TbMateriaisIndiretos")
public class Material {

    // Declara o identificador da entidade e especifica que será gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Atributo que representa o nome do material
    private String nome;

    // Atributo que representa o fornecedor, com um nome de coluna específico
    @Column(name = "Forn")
    private String fornecedor;

    // Atributo que representa a quantidade do material
    private int quantidade;

    // Data de cadastro do material, inicializada com a data atual
    private LocalDate dataCadastro = LocalDate.now();

    // Enum que representa a categoria do material, armazenado como uma string
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    // Construtor que aceita um MaterialDTO para inicializar os atributos da entidade
    public Material(MaterialDTO materialDTO) {
        this.nome = materialDTO.nome();
        this.fornecedor = materialDTO.fornecedor();
        this.quantidade = materialDTO.quantidade();
        this.categoria = materialDTO.categoria();
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
