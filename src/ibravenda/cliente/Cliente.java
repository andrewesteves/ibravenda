/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.cliente;

import ibravenda.pessoa.Pessoa;

/**
 *
 * @author Andrew
 */
public class Cliente extends Pessoa{
    private String email;
    private String aniversario;    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the aniversario
     */
    public String getAniversario() {
        return aniversario;
    }

    /**
     * @param aniversario the aniversario to set
     */
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
}
