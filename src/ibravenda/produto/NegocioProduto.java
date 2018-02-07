/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.produto;

import ibravenda.pedidoProduto.DadosPedidoProduto;
import ibravenda.pedidoProduto.PedidoProduto;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class NegocioProduto implements InterfaceProduto{
    
    @Override
    public void cadastrar(Produto p) throws Exception {
        if (p.getDescricao().trim().equals("")) {
            throw new Exception("Informe a descrição do produto.");
        }
        if (p.getEstoque() < 0) {
            throw new Exception("O estoque deve ser positivo.");
        }
        if(p.getPreco() < 0) {
            throw new Exception("O preço deve ser positivo.");
        } 
        DadosProduto d = new DadosProduto();
        d.cadastrar(p);
    }
    
    @Override
    public void atualizar(Produto p) throws Exception {
        if(p.getCodigo() < 1) {
            throw new Exception("Informe o código do produto");
        }
        if(p.getDescricao().trim().equals("")) {
            throw new Exception("Informe a descrição do produto");
        }
        if(p.getEstoque() < 0) {
            throw new Exception("Informe o estoque");
        }
        if(p.getPreco() < 1) {
            throw new Exception("Informe o preço");
        }
        DadosProduto d = new DadosProduto();
        d.atualizar(p);
    }
    
    @Override
    public void remover(Produto p) throws Exception {
        if (p.getCodigo() < 1) {
            throw new Exception("Informe o código do produto.");
        }
        DadosPedidoProduto dp = new DadosPedidoProduto();
        PedidoProduto pp = new PedidoProduto();
        pp.setProduto(p);
        if(dp.listar(pp).size() > 0) {
            throw new Exception("Produto já vinculado a pedido.");
        }
        DadosProduto d = new DadosProduto();
        d.remover(p);
    }
    
    @Override
    public ArrayList<Produto> listar(Produto filtro) throws Exception {
        DadosProduto d = new DadosProduto();
        if(filtro.getDescricao() == null) {
            filtro.setDescricao("");
        }
        return d.listar(filtro);
    }
}
