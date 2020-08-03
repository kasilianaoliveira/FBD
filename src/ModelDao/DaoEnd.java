/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import conection.ConexaoBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelBeans.ModelEnd;

/**
 *
 * @author kasil
 */
public class DaoEnd {
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
    
    public void Alterar(ModelEnd cad) {
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("update endereco set logradouro=?, num_casa=?, bairro=?, cidade=? where id_endereco=?");
            
            pst.setString(1, cad.getLogradouro());
            pst.setInt(2, cad.getNum_casa());
            pst.setString(3, cad.getBairro());
            pst.setString(4, cad.getCidade());
            pst.setInt(5, cad.getId_endereco());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados!/nErro:" + ex.getMessage());
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
    
    public ModelEnd pesquisar(ModelEnd end){
        conecte.conexao();
        
        try {
            conecte.executaSql("select *from endereco where bairro like'%" + end.getPesquisar()+"%'");
            conecte.rs.first();
            
            end.setId_endereco(conecte.rs.getInt("id_endereco"));
            end.setLogradouro(conecte.rs.getString("logradouro"));
            end.setNum_casa(conecte.rs.getInt("num_casa"));
            end.setBairro(conecte.rs.getString("bairro"));
            end.setCidade(conecte.rs.getString("cidade"));
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Endereço não cadastrado"+e);
        }
        conecte.desconecta();
            return end;
        
    }
    
    
}
