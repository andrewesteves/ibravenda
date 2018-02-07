/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.vendedor;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface InterfaceVendedor {
    /**
     * Cadastrar vendedor na tabela cliente
     * @param v
     * @throws Exception 
     */
    public void cadastrar(Vendedor v) throws Exception;
    
    /**
     * Atualizar vendedor na tabela cliente
     * @param v
     * @throws Exception 
     */
    public void atualizar(Vendedor v) throws Exception;
    
    /**
     * Remover vendedor na tabela cliente
     * @param v
     * @throws Exception 
     */
    public void remover(Vendedor v) throws Exception;
    
    /**
     * Listagem com vendedores
     * Utilizando possível filtro
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception;
}
