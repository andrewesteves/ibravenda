/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedidoProduto;

import ibravenda.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class DadosPedidoProduto extends Dados implements InterfacePedidoProduto {

    @Override
    public void cadastrar(PedidoProduto pp) throws Exception {
        conectar();

        String sql = "INSERT INTO pedido_produto (qtd_produtos, prc_unitario, prd_codigo, ped_numero) ";
        sql += "VALUES (?,?,?,?)";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, pp.getQuantidade());
            cmd.setFloat(2, pp.getPreco());
            cmd.setInt(3, pp.getProduto().getCodigo());
            cmd.setInt(4, pp.getPedido().getNumero());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public ArrayList<PedidoProduto> listar(PedidoProduto filtro) throws Exception {
        conectar();
        int posicao = 1;

        ArrayList<PedidoProduto> pedido_produtos = new ArrayList<>();

        String sql = "SELECT qtd_produtos, prc_unitario, pedido_produto.prd_codigo as prd_codigo, ped_numero, prd_descricao ";
        sql += "FROM pedido_produto ";
        sql += "INNER JOIN produto ON produto.prd_codigo = pedido_produto.prd_codigo ";
        sql += "WHERE ped_numero > 0 ";
        if(filtro.getPedido().getNumero() > 0) {
            sql += "AND pedido_produto.ped_numero = ? ";
        }
        if(filtro.getProduto().getCodigo()> 0) {
            sql += "AND produto.prd_codigo = ? ";
        }
        PreparedStatement cmd = conn.prepareStatement(sql);
        if(filtro.getPedido().getNumero() > 0) {
            cmd.setInt(posicao, filtro.getPedido().getNumero());
            posicao++;
        }
        if(filtro.getProduto().getCodigo()> 0) {
            cmd.setInt(posicao, filtro.getProduto().getCodigo());
            posicao++;
        }
        
        ResultSet leitor = cmd.executeQuery();
        while (leitor.next()) {
            PedidoProduto pp = new PedidoProduto();
            pp.setQuantidade(leitor.getInt("qtd_produtos"));
            pp.setPreco(leitor.getFloat("prc_unitario"));
            pp.getProduto().setCodigo(leitor.getInt("prd_codigo"));
            pp.getProduto().setDescricao(leitor.getString("prd_descricao"));
            pp.getPedido().setNumero(leitor.getInt("ped_numero"));
            pedido_produtos.add(pp);
        }

        cmd.execute();

        desconectar();

        return pedido_produtos;
    }
}
