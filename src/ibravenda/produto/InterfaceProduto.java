/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.produto;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface InterfaceProduto {
    
    /**
     * Cadastrar produto
     * @param p
     * @throws java.lang.Exception
     */
    public void cadastrar(Produto p) throws Exception;
    
    /**
     * Atualizar produto
     * @param p
     * @throws Exception 
     */
    public void atualizar(Produto p) throws Exception;
    
    /**
     * Remover
     * @param p
     * @throws java.lang.Exception
     */
    public void remover(Produto p) throws Exception;
    
    /**
     * Listagem de produtos
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Produto> listar(Produto filtro) throws Exception;
}
