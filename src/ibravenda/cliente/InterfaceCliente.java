/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.cliente;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface InterfaceCliente {

    /**
     * Cadastrar cliente na tabela cliente
     * @param c
     * @throws Exception 
     */
    public void cadastrar(Cliente c) throws Exception;
    
    /**
     * Atualizar cliente na tabela cliente
     * @param c
     * @throws Exception 
     */
    public void atualizar(Cliente c) throws Exception;
    
    /**
     * Remover cliente na tabela cliente
     * @param c
     * @throws Exception 
     */
    public void remover(Cliente c) throws Exception;
    
    /**
     * Listagem com clientes da tabela cliente
     * Utilizando possível filtro
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception;
}
