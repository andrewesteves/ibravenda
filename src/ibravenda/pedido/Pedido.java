/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedido;

import ibravenda.cliente.Cliente;
import ibravenda.pedidoProduto.PedidoProduto;
import ibravenda.vendedor.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Pedido {

    private int numero;
    private String data;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<PedidoProduto> produtos;

    public Pedido() {
        this.vendedor = new Vendedor();
        this.cliente = new Cliente();
        this.produtos = new ArrayList<>();
    }

    public double getTotalPedido() {
        double total = 0.0;
        for (PedidoProduto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the produtos
     */
    public ArrayList<PedidoProduto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(ArrayList<PedidoProduto> produtos) {
        this.produtos = produtos;
    }
}
