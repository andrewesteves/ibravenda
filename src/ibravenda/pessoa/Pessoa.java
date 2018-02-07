/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pessoa;

/**
 *
 * @author Andrew
 */
public abstract class Pessoa {

    private String cpf;
    private String nome;

    /**
     * @return the cpf
     */
    public String getCpf() {
        if (this.cpf == null) {
            this.cpf = "";
        }
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        if (this.nome == null) {
            this.nome = "";
        }
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
