/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.vendedor;

import ibravenda.pedido.NegocioPedido;
import ibravenda.pedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class NegocioVendedor implements InterfaceVendedor{
    
    @Override
    public void cadastrar(Vendedor v) throws Exception {
        if (v.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        if (v.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        DadosVendedor d = new DadosVendedor();
        d.cadastrar(v);
    }

    @Override
    public void atualizar(Vendedor v) throws Exception {
        if (v.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        if (v.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        DadosVendedor d = new DadosVendedor();
        d.atualizar(v);
    }

    @Override
    public void remover(Vendedor v) throws Exception {
        if (v.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        Pedido p = new Pedido();
        p.setVendedor(v);
        NegocioPedido n = new NegocioPedido();
        if (n.listar(p).size() > 0) {
            throw new Exception("O vendedor já possui pedido.");
        }
        DadosVendedor d = new DadosVendedor();
        d.remover(v);
    }
    
    @Override
    public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception {
        DadosVendedor d = new DadosVendedor();
        return d.listar(filtro);
    }
}
