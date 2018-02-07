/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.produto;

import ibravenda.pedidoProduto.PedidoProduto;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Produto {
    private int codigo;
    private String descricao;
    private float preco;
    private int estoque;
    private ArrayList<PedidoProduto> pedidos;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the pedidos
     */
    public ArrayList<PedidoProduto> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ArrayList<PedidoProduto> pedidos) {
        this.pedidos = pedidos;
    }
}
