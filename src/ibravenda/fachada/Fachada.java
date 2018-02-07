/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.fachada;

import ibravenda.cliente.Cliente;
import ibravenda.cliente.InterfaceCliente;
import ibravenda.cliente.NegocioCliente;
import ibravenda.pedido.InterfacePedido;
import ibravenda.pedido.NegocioPedido;
import ibravenda.pedido.Pedido;
import ibravenda.pedidoProduto.InterfacePedidoProduto;
import ibravenda.pedidoProduto.NegocioPedidoProduto;
import ibravenda.pedidoProduto.PedidoProduto;
import ibravenda.produto.InterfaceProduto;
import ibravenda.produto.NegocioProduto;
import ibravenda.produto.Produto;
import ibravenda.vendedor.InterfaceVendedor;
import ibravenda.vendedor.NegocioVendedor;
import ibravenda.vendedor.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public final class Fachada implements InterfaceCliente, InterfaceVendedor, InterfaceProduto, InterfacePedido, InterfacePedidoProduto {

    // Cliente
    @Override
    public void cadastrar(Cliente c) throws Exception {
        NegocioCliente n = new NegocioCliente();
        n.cadastrar(c);
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        NegocioCliente n = new NegocioCliente();
        n.atualizar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {
        NegocioCliente n = new NegocioCliente();
        n.remover(c);
    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        NegocioCliente n = new NegocioCliente();
        return n.listar(filtro);
    }

    // Pedido
    @Override
    public void cadastrar(Pedido p) throws Exception {
        NegocioPedido n = new NegocioPedido();
        n.cadastrar(p);
    }

    @Override
    public void atualizar(Pedido p) throws Exception {
        NegocioPedido n = new NegocioPedido();
        n.atualizar(p);
    }

    @Override
    public void remover(Pedido p) throws Exception {
        NegocioPedido n = new NegocioPedido();
        n.remover(p);
    }

    @Override
    public ArrayList<Pedido> listar(Pedido filtro) throws Exception {
        NegocioPedido n = new NegocioPedido();
        return n.listar(filtro);
    }

    @Override
    public int numeroInserido() throws Exception {
        NegocioPedido n = new NegocioPedido();
        return n.numeroInserido();
    }

    // Vendedor
     @Override
    public void cadastrar(Vendedor v) throws Exception {
        NegocioVendedor n = new NegocioVendedor();
        n.cadastrar(v);
    }

    @Override
    public void atualizar(Vendedor v) throws Exception {
        NegocioVendedor n = new NegocioVendedor();
        n.atualizar(v);
    }

    @Override
    public void remover(Vendedor v) throws Exception {
        NegocioVendedor n = new NegocioVendedor();
        n.remover(v);
    }
    
    @Override
    public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception {
        NegocioVendedor n = new NegocioVendedor();
        return n.listar(filtro);
    }

    // Produto
    @Override
    public void cadastrar(Produto p) throws Exception {
        NegocioProduto n = new NegocioProduto();
        n.cadastrar(p);
    }

    @Override
    public void atualizar(Produto p) throws Exception {
        NegocioProduto n = new NegocioProduto();
        n.atualizar(p);
    }

    @Override
    public void remover(Produto p) throws Exception {
        NegocioProduto n = new NegocioProduto();
        n.remover(p);
    }

    @Override
    public ArrayList<Produto> listar(Produto filtro) throws Exception {
        NegocioProduto n = new NegocioProduto();
        return n.listar(filtro);
    }

    // Pedido Produto
    @Override
    public void cadastrar(PedidoProduto pp) throws Exception {
        NegocioPedidoProduto n = new NegocioPedidoProduto();
        n.cadastrar(pp);
    }

    @Override
    public ArrayList<PedidoProduto> listar(PedidoProduto filtro) throws Exception {
        NegocioPedidoProduto n = new NegocioPedidoProduto();
        return n.listar(filtro);
    }

    @Override
    public ArrayList<Pedido> listarPedidosPorProduto(Produto filtro) throws Exception {
        NegocioPedido d = new NegocioPedido();
        return d.listarPedidosPorProduto(filtro);
    }

}
