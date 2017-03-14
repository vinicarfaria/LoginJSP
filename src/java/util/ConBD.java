/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jivago
 */
public class ConBD {
    public Connection con;  
    public Statement stm;  
    public ResultSet res = null;  
    private String id = null;  
    private String senha = null;
    
    public ConBD() {
        
        try {
            
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jsp","root","");
          stm = con.createStatement();
          
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não "
                    + "encontrada: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean consultarId(){
        boolean testa = false;
        try {  
         String query = "select * from usuario where login='"+id+"'";  
         res = stm.executeQuery(query);  
           
         testa = res.next();  
           
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
      return testa;
    }
    
    public boolean consultarSenha(){
        boolean testa = false;
        try {  
         String query = "select * from usuario where login='" +id+"' AND senha='"+senha+"'";  
         res = stm.executeQuery(query);  
           
         testa = res.next();  
           
      }catch (SQLException e){System.out.println("Erro na inserção:" + e.getMessage());}  
        
      return testa;
    }
    
    
}
