/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.cliente;

import ibravenda.pedido.NegocioPedido;
import ibravenda.pedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class NegocioCliente implements InterfaceCliente {

    @Override
    public void cadastrar(Cliente c) throws Exception {
        if (c.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        if (c.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        DadosCliente d = new DadosCliente();
        d.cadastrar(c);
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        if (c.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        if (c.getNome().trim().equals("")) {
            throw new Exception("NOME é obrigatório.");
        }
        DadosCliente d = new DadosCliente();
        d.atualizar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {
        if (c.getCpf().trim().length() != 11) {
            throw new Exception("CPF deve conter apenas números, não use pontos e hífen.");
        }
        Pedido p = new Pedido();
        p.setCliente(c);
        NegocioPedido n = new NegocioPedido();
        if (n.listar(p).size() > 0) {
            throw new Exception("O cliente já possui pedido.");
        }
        DadosCliente d = new DadosCliente();
        d.remover(c);
    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        if (filtro.getCpf() == null) {
            filtro.setCpf("");
        }
        if (filtro.getNome() == null) {
            filtro.setNome("");
        }
        if (filtro.getEmail() == null) {
            filtro.setEmail("");
        }
        if (filtro.getAniversario() == null) {
            filtro.setAniversario("");
        }
        DadosCliente d = new DadosCliente();
        return d.listar(filtro);
    }

}
