/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Martins
 * @author Breno Araujo
 * @author Eduardo Marinho
 * @author Mateus Henrique;
 * descricao:
 * pojo de apartamaneto com seus atributos mapeados, entidades, colounas, chave primaria;
 * com relacionamento com morador, um apartamento para varios moradores (1 para n);
 * Alem de seus construtores gets e sets;
 * numero eh obrigatorio, unico em cada bloco e deve aceitar apenas numeros;
 * andar e bloco sao obrigatorios;
 * moradores pode ter moradores associados ou nao, pois o cadastro de apartamento independe da existencia
 * de moradores.
 */

@Entity
@Table(name = "apartamento",schema = "syscond")
public class Apartamento {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String numero;
    @Column
    private String andar;
    @Column
    private String bloco;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "apartamento")
    private List<Morador> moradores = new ArrayList<>();

    public Apartamento() {
    }

    /**
     * @param numero eh o parametro usado nesse segundo construtor de apartamento, pois o primeiro eh vazio.
     */
    public Apartamento(String numero) {
        this.numero = numero;
    }

    /**
     * @param numero e
     * @param moradores sao os parametros usados nesse terceiro construtor de apartamento.
     */
    public Apartamento(String numero, List<Morador> moradores) {
        this.numero = numero;
        this.moradores = moradores;
    }

    /**
     * @param numero ,
     * @param andar e
     * @param bloco sao os parametros usados nesse quarto construtor de apartamento.
     */
    public Apartamento(String numero, String andar, String bloco) {
        this.numero = numero;
        this.andar = andar;
        this.bloco = bloco;
    }

    /**
     * @param numero ,
     * @param andar ,
     * @param bloco e
     * @param moradores sao os parametros usados nesse quinto construtor de apartamento.
     */
    public Apartamento(String numero, String andar, String bloco, List<Morador> moradores) {
        this.numero = numero;
        this.andar = andar;
        this.bloco = bloco;
        this.moradores = moradores;
    }

    /**
     * @return retorna o numero do apartamento.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero eh atribuido um novo numero para o apartamento.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return retorna o andar do apartamento.
     */
    public String getAndar() {
        return andar;
    }

    /**
     * @param andar eh atribuido um novo andar para o apartamento.
     */
    public void setAndar(String andar) {
        this.andar = andar;
    }

    /**
     * @return retorna o bloco do apartamento.
     */
    public String getBloco() {
        return bloco;
    }

    /**
     * @param bloco eh atribuido um novo bloco para o apartamento.
     */
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    /**
     * @return retorna a lista de moradores do apartamento.
     */
    public List<Morador> getMorador() {
        return moradores;
    }

    /**
     * @param morador eh atribuido uma nova lista de moradores para o apartamento.
     */
    public void setMorador(List<Morador> morador) {
        this.moradores = morador;
    }
}
