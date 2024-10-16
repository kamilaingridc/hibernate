package br.ETS.hibernate;

// Classe MaterialDTO representando um objeto de transferência de dados para a entidade Material
public record MaterialDTO(String nome,          // Nome do material
                          String fornecedor,   // Fornecedor do material
                          int quantidade,      // Quantidade do material
                          Categoria categoria) // Categoria do material
{
    // O compilador automaticamente gera os métodos:
    // - Construtor para inicializar os campos
    // - Métodos getters para acessar os valores dos campos
    // - Métodos equals() e hashCode() para comparar instâncias
    // - Método toString() para representar o objeto como uma string
}
