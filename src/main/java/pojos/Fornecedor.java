package pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *   @author Mateus Martins
 *   @author Breno Araujo
 *   @author Eduardo Marinho
 *   @author Mateus Henrique;
 *   descricao:
 *   pojo de fornecedor com seus atributos mapeados, entidades, colouna, chave primaria;
 *   Alem de seus construtores gets e sets;
 *   nome deve ser obrigatorio e deve aceitar apenas letras;
 *   cnpj deve ser obrigatorio, unico e no formato: 99.999.999/9999-99;
 *   telefone deve ser escrito no formato: +99 (99) 9 9999-9999.
 *
*/
@NamedQueries({ 
    @NamedQuery(name = "Fornecedor.buscaPorCNPJ", query = "select f from Fornecedor f where f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.buscaTodos", query = "select f from Fornecedor f") })

@Entity
public class Fornecedor {
    @Id
    String cnpj;
    @Column(nullable = false)
    String nome;
    @Column
    String telefone;


    public Fornecedor() {
    }
    /**
     * @param cnpj ,
     * @param nome e
     * @param telefone sao os parametros usados nesse segundo construtor de fornecedor, pois o primeiro construtor eh vazio.
     */
    public Fornecedor(String cnpj, String nome, String telefone) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
    }
    /**
     * @return retorna o cnpj do fornecedor.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj eh atribuido um novo cnpj para o fornecedor.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return retorna o nome do fornecedor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome eh atribuido um novo nome para o fornecedor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return retorna o telefone do fornecedor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone eh atribuido um novo telefone para o fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
