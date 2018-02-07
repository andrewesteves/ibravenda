/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedido;

import ibravenda.produto.Produto;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface InterfacePedido {
    
    /**
     * Cadastrar pedido
     * @param p
     * @throws Exception 
     */
    public void cadastrar(Pedido p) throws Exception;
    
    /**
     * Atualizar pedido
     * @param p
     * @throws Exception 
     */
    public void atualizar(Pedido p) throws Exception;
    
    /**
     * Remover pedido
     * @param p
     * @throws Exception 
     */
    public void remover(Pedido p) throws Exception;
    
    /**
     * Listagem de pedidos
     * Utilizando possível filtro
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Pedido> listar(Pedido filtro) throws Exception;
    
    /**
     * Pegar o número do último pedido inserido
     * @return int
     * @throws java.lang.Exception
     */
    public int numeroInserido() throws Exception;
    
    
    /**
     * Listar pedidos por produto informado
     * @param filtro
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Pedido> listarPedidosPorProduto(Produto filtro) throws Exception;
}
