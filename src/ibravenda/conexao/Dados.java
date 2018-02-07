/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibravenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrew
 */
public abstract class Dados {

    public Connection conn;
    private Statement stmt;
    
    /**
     * Conectar com banco de dados
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarMySQL();
    }
    
    /**
     * Desconectar do banco de dados
     * @throws Exception 
     */
    public void desconectar() throws Exception {
        conn.close();
    }
    
    /**
     * Conectar com o MySQL
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private Statement conectarMySQL() throws ClassNotFoundException, SQLException {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String banco = "ibravenda";
            String url = "jdbc:mysql://localhost:3306/";
            String usuario = "root";
            String senha = "";
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url + banco, usuario, senha);
            stmt = conn.createStatement();
            return stmt;
        } catch (InstantiationException e) {
            throw new SQLException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
