/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.vendedor;

import ibravenda.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class DadosVendedor extends Dados implements InterfaceVendedor {

    @Override
    public void cadastrar(Vendedor v) throws Exception {
        conectar();

        String sql = "INSERT INTO vendedor (ved_cpf, ved_nome, ved_logradouro, ved_numero, ved_complemento, ved_cep, ved_bairro, ved_cidade, ved_estado, ved_telefone) ";
        sql += "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, v.getCpf());
            cmd.setString(2, v.getNome());
            cmd.setString(3, v.getLogradouro());
            cmd.setString(4, v.getNumero());
            cmd.setString(5, v.getComplemento());
            cmd.setString(6, v.getCep());
            cmd.setString(7, v.getBairro());
            cmd.setString(8, v.getCidade());
            cmd.setString(9, v.getEstado());
            cmd.setString(10, v.getTelefone());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void atualizar(Vendedor v) throws Exception {
        conectar();

        String sql = "UPDATE vendedor SET ved_cpf = ?, ";
        sql += "ved_nome = ?, ved_logradouro = ?, ved_numero = ?, ved_complemento = ?, ";
        sql += "ved_cep = ?, ved_bairro = ?, ";
        sql += "ved_cidade = ?, ved_estado = ?, ";
        sql += "ved_telefone = ? ";
        sql += "WHERE ved_cpf = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, v.getCpf());
            cmd.setString(2, v.getNome());
            cmd.setString(3, v.getLogradouro());
            cmd.setString(4, v.getNumero());
            cmd.setString(5, v.getComplemento());
            cmd.setString(6, v.getCep());
            cmd.setString(7, v.getBairro());
            cmd.setString(8, v.getCidade());
            cmd.setString(9, v.getEstado());
            cmd.setString(10, v.getTelefone());
            cmd.setString(11, v.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public void remover(Vendedor v) throws Exception {
        conectar();

        String sql = "DELETE FROM vendedor WHERE ved_cpf = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, v.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public ArrayList<Vendedor> listar(Vendedor filtro) throws Exception {
        conectar();

        // posição utilizada para o prepared statement
        int posicao = 1;

        ArrayList<Vendedor> vendedores = new ArrayList<>();

        String sql = "SELECT ved_cpf, ved_nome, ved_telefone, ved_logradouro, ved_numero, ";
        sql += "ved_complemento, ved_cep, ved_bairro, ved_cidade, ved_estado ";
        sql += "FROM vendedor WHERE 1 < 2 ";

        if (filtro.getCpf().trim().length() == 11) {
            sql += " AND ved_cpf = ?";
        }
        if (filtro.getNome().trim().equals("") == false) {
            sql += " AND ved_nome LIKE ?";
        }
        if (filtro.getLogradouro() != null && filtro.getLogradouro().trim().equals("") == false) {
            sql += " AND ved_logradouro LIKE ?";
        }
        if (filtro.getNumero() != null && filtro.getNumero().trim().equals("") == false) {
            sql += " AND ved_numero LIKE ?";
        }
        if (filtro.getComplemento() != null && filtro.getComplemento().trim().equals("") == false) {
            sql += " AND ved_complemento LIKE ?";
        }
        if (filtro.getCep() != null && filtro.getCep().trim().equals("") == false) {
            sql += " AND ved_cep LIKE ?";
        }
        if (filtro.getBairro() != null && filtro.getBairro().trim().equals("") == false) {
            sql += " AND ved_bairro LIKE ?";
        }
        if (filtro.getCidade() != null && filtro.getCidade().trim().equals("") == false) {
            sql += " AND ved_cidade LIKE ?";
        }
        if (filtro.getEstado() != null && filtro.getEstado().trim().equals("") == false) {
            sql += " AND ved_estado LIKE ?";
        }
        if (filtro.getTelefone() != null && filtro.getTelefone().trim().equals("") == false) {
            sql += " AND ved_telefone LIKE ?";
        }
        

        sql += " ORDER BY ved_nome";

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
            if (filtro.getLogradouro() != null && filtro.getLogradouro().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getLogradouro());
                posicao++;
            }
            if (filtro.getNumero() != null && filtro.getNumero().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getNumero());
                posicao++;
            }
            if (filtro.getComplemento() != null && filtro.getComplemento().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getComplemento());
                posicao++;
            }
            if (filtro.getCep() != null && filtro.getCep().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getCep());
                posicao++;
            }
            if (filtro.getBairro() != null && filtro.getBairro().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getBairro());
                posicao++;
            }
            if (filtro.getCidade() != null && filtro.getCidade().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getCidade());
                posicao++;
            }
            if (filtro.getEstado() != null && filtro.getEstado().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getEstado());
                posicao++;
            }
            if (filtro.getTelefone() != null && filtro.getTelefone().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getTelefone());
                posicao++;
            }

            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Vendedor v = new Vendedor();
                v.setCpf(leitor.getString("ved_cpf"));
                v.setNome(leitor.getString("ved_nome"));
                v.setTelefone(leitor.getString("ved_telefone"));
                v.setLogradouro(leitor.getString("ved_logradouro"));
                v.setNumero(leitor.getString("ved_numero"));
                v.setComplemento(leitor.getString("ved_complemento"));
                v.setCep(leitor.getString("ved_cep"));
                v.setBairro(leitor.getString("ved_bairro"));
                v.setCidade(leitor.getString("ved_cidade"));
                v.setEstado(leitor.getString("ved_estado"));
                vendedores.add(v);
            }

            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar dados na tabela: " + e.getMessage());
        }

        desconectar();

        return vendedores;
    }
}
