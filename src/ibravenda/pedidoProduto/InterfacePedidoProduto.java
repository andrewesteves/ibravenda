/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedidoProduto;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface InterfacePedidoProduto {
    
    /**
     * Cadastrar pedido
     * @param pp
     * @throws Exception 
     */
    public void cadastrar(PedidoProduto pp) throws Exception;
    
    /**
     * Listagem de pedido_produto
     * Utilizando possível filtro
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<PedidoProduto> listar(PedidoProduto filtro) throws Exception;
}
