/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedidoProduto;

import ibravenda.pedido.Pedido;
import ibravenda.produto.Produto;

/**
 *
 * @author Andrew
 */
public class PedidoProduto {
    private int quantidade;
    private float preco;
    private Produto produto;
    private Pedido pedido;
    
    /**
     * Construtor
     */
    public PedidoProduto() {
        this.produto = new Produto();
        this.pedido = new Pedido();
    }

    public double getTotal() {
        return this.quantidade * this.preco;
    }
    
    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        if(quantidade < 0) {
            quantidade *= -1;
        }
        this.quantidade = quantidade;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
