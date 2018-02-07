/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.cliente;

import ibravenda.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class DadosCliente extends Dados implements InterfaceCliente {

    @Override
    public void cadastrar(Cliente c) throws Exception {
        conectar();

        String sql = "INSERT INTO cliente (cli_cpf, cli_nome, cli_email, cli_aniversario) ";
        sql += "VALUES (?,?,?,?)";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.setString(2, c.getNome());
            cmd.setString(3, c.getEmail());
            cmd.setString(4, c.getAniversario());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        conectar();

        String sql = "UPDATE cliente SET cli_cpf = ?, cli_nome = ?, cli_email = ?, cli_aniversario = ? ";
        sql += "WHERE cli_cpf = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.setString(2, c.getNome());
            cmd.setString(3, c.getEmail());
            cmd.setString(4, c.getAniversario());
            cmd.setString(5, c.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void remover(Cliente c) throws Exception {
        conectar();

        String sql = "DELETE FROM cliente WHERE cli_cpf = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        conectar();

        // posição utilizada para o prepared statement
        int posicao = 1;

        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT cli_cpf, cli_nome, cli_email, cli_aniversario ";
        sql += "FROM cliente WHERE 1 < 2 ";

        if (filtro.getCpf().trim().length() == 11) {
            sql += " AND cli_cpf = ?";
        }
        if (filtro.getNome().trim().equals("") == false) {
            sql += " AND cli_nome LIKE ?";
        }
        if (filtro.getEmail().trim().equals("") == false) {
            sql += " AND cli_email LIKE ?";
        }
        if (filtro.getAniversario().length() == 10) {
            sql += " AND cli_aniversario = ?";
        }
        
        sql += " ORDER BY cli_nome";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            
            if (filtro.getCpf().trim().length() == 11) {
                cmd.setString(posicao, filtro.getCpf());
                posicao++;
            }
            if (filtro.getNome().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getNome());
                posicao++;
            }
            if (filtro.getEmail().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getEmail());
                posicao++;
            }
            if (filtro.getAniversario().length() == 10) {
                cmd.setString(posicao, filtro.getAniversario());
                posicao++;
            }
            
            ResultSet leitor = cmd.executeQuery();
            while(leitor.next()) {
                Cliente c = new Cliente();
                c.setCpf(leitor.getString("cli_cpf"));
                c.setNome(leitor.getString("cli_nome"));
                c.setEmail(leitor.getString("cli_email"));
                c.setAniversario(leitor.getString("cli_aniversario"));
                clientes.add(c);
            }
            
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar dados na tabela: " + e.getMessage());
        }

        desconectar();

        return clientes;
    }

}
