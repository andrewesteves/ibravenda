/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.produto;

import ibravenda.conexao.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class DadosProduto extends Dados implements InterfaceProduto{
    
    @Override
    public void cadastrar(Produto p) throws Exception {
        conectar();

        String sql = "INSERT INTO produto (prd_descricao, prd_estoque, prd_preco) ";
        sql += "VALUES (?,?,?)";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, p.getDescricao());
            cmd.setInt(2, p.getEstoque());
            cmd.setFloat(3, p.getPreco());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao inserir dados na tabela: " + e.getMessage());
        }

        desconectar();
    }
    
    @Override
    public void atualizar(Produto p) throws Exception {
        conectar();
        
        String sql = "UPDATE produto SET prd_descricao = ?, prd_estoque = ?, prd_preco = ? ";
        sql += "WHERE prd_codigo = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, p.getDescricao());
            cmd.setInt(2, p.getEstoque());
            cmd.setFloat(3, p.getPreco());
            cmd.setInt(4, p.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar dados na tabela: " + e.getMessage());
        }

        desconectar();
    }
    
    @Override
    public void remover(Produto p) throws Exception {
        conectar();

        String sql = "DELETE FROM produto WHERE prd_codigo = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, p.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover dados na tabela: " + e.getMessage());
        }

        desconectar();
    }

    @Override
    public ArrayList<Produto> listar(Produto filtro) throws Exception {
        conectar();

        // posição utilizada para o prepared statement
        int posicao = 1;

        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT prd_codigo, prd_descricao, prd_estoque, prd_preco ";
        sql += "FROM produto WHERE 1 < 2 ";
        
        if(filtro.getCodigo() > 0) {
            sql += "AND prd_codigo = ? ";
        }
        if(filtro.getDescricao().trim().equals("") == false) {
            sql += "AND prd_descricao LIKE ? ";
        }
        if(filtro.getPreco() > 0) {
            sql += "AND prd_preco = ? ";
        }
        if(filtro.getEstoque() > 0) {
            sql += "AND prd_estoque = ?";
        }
        
        sql += " ORDER BY prd_descricao";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            
            if(filtro.getCodigo() > 0) {
                cmd.setInt(posicao, filtro.getCodigo());
                posicao++;
            }
            if (filtro.getDescricao().trim().equals("") == false) {
                cmd.setString(posicao, filtro.getDescricao());
                posicao++;
            }
            if (filtro.getPreco() > 0) {
                cmd.setFloat(posicao, filtro.getPreco());
                posicao++;
            }
            if (filtro.getEstoque() > 0) {
                cmd.setInt(posicao, filtro.getEstoque());
                posicao++;
            }            
                       
            ResultSet leitor = cmd.executeQuery();
            while(leitor.next()) {
                Produto p = new Produto();
                p.setCodigo(leitor.getInt("prd_codigo"));
                p.setDescricao(leitor.getString("prd_descricao"));
                p.setEstoque(leitor.getInt("prd_estoque"));
                p.setPreco(leitor.getFloat("prd_preco"));
                produtos.add(p);
            }
            
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao selecionar dados na tabela: " + e.getMessage());
        }

        desconectar();

        return produtos;
    }
}
