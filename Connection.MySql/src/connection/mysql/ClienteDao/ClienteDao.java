/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.mysql.ClienteDao;

import connection.clientes.Cliente;
import Classes.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hugo lazzari
 */
public class ClienteDao {
    public void criarRegitroNoBancoDeDados(Cliente c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into";
        try{
            stmt = con.prepareStatement(sql);
        }catch(SQLException e){
            
        }finally{
            con.close(con, stmt);
        }
    }
}
