/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import conection.ConexaoBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBeans.ModelEnd;

/**
 *
 * @author kasil
 */
public class DaoEnd2 {
    ConexaoBanco conecte = new ConexaoBanco();
    ModelEnd cad = new ModelEnd();

    
    
    public void Salvar(ModelEnd cad) {
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("INSERT INTO endereco (logradouro, num_casa, bairro, cidade) VALUES(?,?,?,?)");
            
            pst.setString(1, cad.getLogradouro());
            pst.setInt(2, cad.getNum_casa());
            pst.setString(3, cad.getBairro());
            pst.setString(4, cad.getCidade());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
    }       
    
    public void Alterar(ModelEnd ende){
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("update endereco set logradouro=?, num_casa=?, bairro=?, cidade=? where id_endereco=?");
            pst.setString(1, ende.getLogradouro());
            pst.setInt(2, ende.getNum_casa());
            pst.setString(3, ende.getBairro());
            pst.setString(4, ende.getCidade());
            pst.setInt(5, ende.getId_endereco());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
        
    }
    public void Excluir(ModelEnd cad) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("delete from endereco where id_endereco=?");
            pst.setInt(1, cad.getId_endereco());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados! /nErro:" + ex);
        }

        conecte.desconecta();
    }
    public ModelEnd pesquisaEndereco( ModelEnd ende){
        conecte.conexao();
        conecte.executaSql("select *from endereco where logradouro like'%"+ende.getPesquisar()+"%'");
        try {
            conecte.rs.first();
            ende.setId_endereco(conecte.rs.getInt("id_endereco"));
            ende.setLogradouro(conecte.rs.getString("logradouro"));
            ende.setNum_casa(conecte.rs.getInt("num_casa"));
            ende.setBairro(conecte.rs.getString("bairro"));
            ende.setCidade(conecte.rs.getString("cidade"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar endereço "+ex);
        }
        conecte.desconecta();
        
        return ende;
    }
}
