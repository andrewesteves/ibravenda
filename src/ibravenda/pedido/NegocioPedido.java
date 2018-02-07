/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedido;

import ibravenda.pedidoProduto.NegocioPedidoProduto;
import ibravenda.pedidoProduto.PedidoProduto;
import ibravenda.produto.Produto;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class NegocioPedido implements InterfacePedido {

    @Override
    public void cadastrar(Pedido p) throws Exception {
        if (p.getData().trim().length() != 10) {
            throw new Exception("Data é obrigatório no formato dd/mm/yyyy");
        }
        if (p.getVendedor().getCpf().trim().equals("")) {
            throw new Exception("CPF do vendedor é obrigatório");
        }
        if (p.getCliente().getCpf().trim().equals("")) {
            throw new Exception("CPF do cliente é obrigatório");
        }
        if (p.getProdutos().isEmpty()) {
            throw new Exception("Informe quais os itens do pedido");
        }
        DadosPedido d = new DadosPedido();
        d.cadastrar(p);
        int numeroInserido = this.numeroInserido();

        NegocioPedidoProduto npp = new NegocioPedidoProduto();
        for (PedidoProduto ppd : p.getProdutos()) {
            PedidoProduto pp = new PedidoProduto();
            pp.setQuantidade(ppd.getQuantidade());
            pp.setPreco(ppd.getProduto().getPreco());
            pp.getProduto().setCodigo(ppd.getProduto().getCodigo());
            pp.getPedido().setNumero(numeroInserido);
            npp.cadastrar(pp);
        }
    }

    @Override
    public void atualizar(Pedido p) throws Exception {
        if (p.getData().trim().length() != 10) {
            throw new Exception("Data é obrigatório!");
        }
        if (p.getVendedor().getCpf().trim().equals("")) {
            throw new Exception("CPF do vendedor é obrigatório!");
        }
        if (p.getCliente().getCpf().trim().equals("")) {
            throw new Exception("CPF do cliente é obrigatório!");
        }
        DadosPedido d = new DadosPedido();
        d.atualizar(p);
    }

    @Override
    public void remover(Pedido p) throws Exception {
        if (p.getNumero() < 1) {
            throw new Exception("O número do pedido deve ser informado!");
        }
        DadosPedido d = new DadosPedido();
        d.remover(p);
    }

    @Override
    public ArrayList<Pedido> listar(Pedido filtro) throws Exception {
        if (filtro.getNumero() < 1) {
            filtro.setNumero(0);
        }
        if (filtro.getData() == null) {
            filtro.setData("");
        }
        if (filtro.getVendedor().getCpf() == null) {
            filtro.getVendedor().setCpf("");
        }
        if (filtro.getCliente().getCpf() == null) {
            filtro.getCliente().setCpf("");
        }
        DadosPedido d = new DadosPedido();
        return d.listar(filtro);
    }

    @Override
    public int numeroInserido() throws Exception {
        DadosPedido d = new DadosPedido();
        return d.numeroInserido();
    }

    @Override
    public ArrayList<Pedido> listarPedidosPorProduto(Produto filtro) throws Exception {
        DadosPedido d = new DadosPedido();
        return d.listarPedidosPorProduto(filtro);
    }
}
