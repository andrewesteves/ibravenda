/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.pedido;

import ibravenda.conexao.Dados;
import ibravenda.pedidoProduto.DadosPedidoProduto;
import ibravenda.pedidoProduto.PedidoProduto;
import ibravenda.produto.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class DadosPedido extends Dados implements InterfacePedido {

    @Override
    public void cadastrar(Pedido p) throws Exception {
        conectar();

        String sql = "INSERT INTO pedido (ped_data, ved_cpf, cli_cpf) ";
        sql += "VALUES (?,?,?)";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, p.getData());
            cmd.setString(2, p.getVendedor().getCpf());
            cmd.setString(3, p.getCliente().getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void atualizar(Pedido p) throws Exception {
        conectar();

        String sql = "UPDATE pedido SET ped_data = ?, ved_cpf = ?, cli_cpf = ? ";
        sql += "WHERE ped_numero = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, p.getData());
            cmd.setString(2, p.getVendedor().getCpf());
            cmd.setString(3, p.getCliente().getCpf());
            cmd.setInt(4, p.getNumero());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void remover(Pedido p) throws Exception {
        conectar();

        String sql = "DELETE FROM pedido WHERE ped_numero = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, p.getNumero());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public ArrayList<Pedido> listar(Pedido filtro) throws Exception {
        conectar();

        // posição utilizada para o prepared statement
        int posicao = 1;

        ArrayList<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT ped_numero, ped_data, pedido.ved_cpf as ved_cpf, ved_nome, pedido.cli_cpf as cli_cpf, cli_nome ";
        sql += "FROM pedido ";
        sql += "INNER JOIN vendedor ON vendedor.ved_cpf = pedido.ved_cpf ";
        sql += "INNER JOIN cliente ON cliente.cli_cpf = pedido.cli_cpf ";
        sql += "WHERE 1 < 2";

        if (filtro.getNumero() > 0) {
            sql += " AND ped_numero = ?";
        }
        if (filtro.getData().trim().equals("") == false) {
            sql += " AND ped_data = ?";
        }
        if (filtro.getVendedor().getCpf().trim().equals("") == false) {
            sql += " AND pedido.ved_cpf = ?";
        }
        if (filtro.getCliente().getCpf().trim().equals("") == false) {
            sql += " AND pedido.cli_cpf = ?";
        }

        sql += " ORDER BY ped_numero DESC";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);

            if (filtro.getNumero() > 0) {
                cmd.setInt(posicao, filtro.getNumero());
                posicao++;
            }
            if (filtro.getData().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getData());
                posicao++;
            }
            if (filtro.getVendedor().getCpf().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getVendedor().getCpf());
                posicao++;
            }
            if (filtro.getCliente().getCpf().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getCliente().getCpf());
                posicao++;
            }

            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Pedido p = new Pedido();
                p.setNumero(leitor.getInt("ped_numero"));
                p.setData(leitor.getString("ped_data"));
                p.getVendedor().setCpf(leitor.getString("ved_cpf"));
                p.getVendedor().setNome(leitor.getString("ved_nome"));
                p.getCliente().setCpf(leitor.getString("cli_cpf"));
                p.getCliente().setNome(leitor.getString("cli_nome"));
                //recebendo os produtos vinculados ao pedido
                DadosPedidoProduto d1 = new DadosPedidoProduto();
                PedidoProduto filtro2 = new PedidoProduto();
                filtro2.setPedido(p);
                p.setProdutos(d1.listar(filtro2));
                pedidos.add(p);
            }

            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar dados na tabela: " + e.getMessage());
        }

        desconectar();

        return pedidos;
    }

    @Override
    public int numeroInserido() throws Exception {
        conectar();

        int numero = 0;
        String sql = "SELECT ped_numero FROM pedido ORDER BY ped_numero DESC LIMIT 1";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                numero = leitor.getInt("ped_numero");
            }
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar último registro de pedido: " + e.getMessage());
        }

        desconectar();

        return numero;
    }

    @Override
    public ArrayList<Pedido> listarPedidosPorProduto(Produto filtro) throws Exception {
        conectar();

        ArrayList<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT pedido.ped_numero, ped_data, pedido.ved_cpf as ved_cpf, ved_nome, pedido.cli_cpf as cli_cpf, cli_nome ";
        sql += " FROM pedido ";
        sql += " INNER JOIN vendedor ON vendedor.ved_cpf = pedido.ved_cpf ";
        sql += " INNER JOIN cliente ON cliente.cli_cpf = pedido.cli_cpf ";
        sql += " INNER JOIN pedido_produto ON pedido_produto.ped_numero = pedido.ped_numero ";
        sql += " WHERE pedido_produto.prd_codigo = ? ";
        sql += " ORDER BY ped_numero DESC; ";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, filtro.getCodigo());

            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Pedido p = new Pedido();
                p.setNumero(leitor.getInt("ped_numero"));
                p.setData(leitor.getString("ped_data"));
                p.getVendedor().setCpf(leitor.getString("ved_cpf"));
                p.getVendedor().setNome(leitor.getString("ved_nome"));
                p.getCliente().setCpf(leitor.getString("cli_cpf"));
                p.getCliente().setNome(leitor.getString("cli_nome"));
                //recebendo os produtos vinculados ao pedido
                DadosPedidoProduto d1 = new DadosPedidoProduto();
                PedidoProduto filtro2 = new PedidoProduto();
                filtro2.setPedido(p);
                p.setProdutos(d1.listar(filtro2));
                pedidos.add(p);
            }

            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar dados na tabela: " + e.getMessage());
        }

        desconectar();

        return pedidos;
    }
}
