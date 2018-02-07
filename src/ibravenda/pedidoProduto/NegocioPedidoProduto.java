/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedidoProduto;

import ibravenda.produto.NegocioProduto;
import ibravenda.produto.Produto;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class NegocioPedidoProduto implements InterfacePedidoProduto{

    @Override
    public void cadastrar(PedidoProduto pp) throws Exception {
        if(pp.getQuantidade() < 1) {
            throw new Exception("Informe a quantidade de produtos");
        }
        if(pp.getPreco() < 1) {
            throw new Exception("Informe o preço do produto!");
        }
        if(pp.getProduto().getCodigo() < 1) {
            throw new Exception("Selecione o produto!");
        }
        if(pp.getPedido().getNumero() < 1) {
            throw new Exception("Informe o número do pedido!");
        }
        DadosPedidoProduto d = new DadosPedidoProduto();
        d.cadastrar(pp);
        
        Produto prd = new Produto();
        prd.setCodigo(pp.getProduto().getCodigo());
        NegocioProduto n = new NegocioProduto();
        for(Produto prdd: n.listar(prd)) {
            // produto atualizado
            Produto prdAtt = new Produto();
            prdAtt.setCodigo(prdd.getCodigo());
            prdAtt.setDescricao(prdd.getDescricao());
            prdAtt.setEstoque(prdd.getEstoque() - pp.getQuantidade());
            prdAtt.setPreco(prdd.getPreco());
            NegocioProduto nn = new NegocioProduto();
            nn.atualizar(prdAtt);
        }     
    }
    
    @Override
    public ArrayList<PedidoProduto> listar(PedidoProduto filtro) throws Exception {
        DadosPedidoProduto d = new DadosPedidoProduto();
        return d.listar(filtro);
    }
    
}
