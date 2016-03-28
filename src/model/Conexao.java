/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Augusto-PC
 */
public class Conexao {
    private static String url = "jdbc:derby://localhost:1527/agenciaAutomoveisDB";
    
    
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=TrabalhoRosen;user=sa;password=123mudar";
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("CONNECTED");
            } else {
                System.out.println("UNABLE TO CONNECT");
            }
            return conn;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }
}
