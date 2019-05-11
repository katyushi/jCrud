/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.mysql.ClienteDao;

import connection.clientes.Cliente;
import connection.mysql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo lazzari
 */
public class ClienteDao {
    public void criarRegitroNoBancoDeDados(Cliente c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into cliente(nomeCompleto, idade, cpf, rg) values (?, ?, ?, ?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNomeCompleto());
            stmt.setString(2, c.getIdade());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getRg());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "os dados foram inseridos com sucesso!");
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "erro ao salvar os dados" + e.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
