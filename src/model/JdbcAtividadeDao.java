/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto-PC
 */
public abstract class JdbcAtividadeDao implements AtividadeDAO{
    
    private PreparedStatement stmt;
    Connection conn = Conexao.getConnection();
    
    @Override
    public boolean gravar(Atividade atividade){
        try{
            String sql = "INSERT INTO ATIVIDADES VALUES (?,?,?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, atividade.getMaxCurso());
            stmt.setInt(2, atividade.getMaxParticipante());
            stmt.setString(3, atividade.getLocalizacao());

            stmt.execute();
            stmt.close();
            
            return true;
        }catch(SQLException ex){
             Logger.getLogger(JdbcAtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
    }
    
    @Override
    public ArrayList<Atividade> listar(){
        try{
            String sql = "SELECT * FROM ATIVIDADES";
            stmt = conn.prepareStatement(sql);
            ArrayList<Atividade> list = new ArrayList<Atividade>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Atividade at = new Atividade();
            
                at.setId(rs.getInt(1));
                at.setMaxCurso(rs.getInt(2));
                at.setMaxParticipante(rs.getInt(3));
                at.setLocalizacao(rs.getString(4));
                
                list.add(at);
            }
            
            return list;   
        }catch(SQLException ex){
            Logger.getLogger(JdbcAtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @Override
    public boolean alterar(Atividade atividade){
        try{
            String sql = "UPDATE ATIVIDADES SET max_curso = ?, max_participante = ?, localizacao = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, atividade.getMaxCurso());
            stmt.setInt(2, atividade.getMaxParticipante());
            stmt.setString(3, atividade.getLocalizacao());
            stmt.setInt(4, atividade.getId());
            
            stmt.executeUpdate();
            stmt.close(); 
            
            return true;
        }catch(SQLException ex){
            Logger.getLogger(JdbcAtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public boolean excluir(Atividade atividade){
        try{
            String sql = "DELETE FROM ATIVIDADES WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, atividade.getId());
            
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }catch(SQLException ex){
            Logger.getLogger(JdbcAtividadeDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
