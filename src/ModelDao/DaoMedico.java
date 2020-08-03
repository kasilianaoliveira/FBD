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
import modelBeans.ModelMed;
import modelBeans.ModelUser;

/**
 *
 * @author kasil
 */
public class DaoMedico {
    ConexaoBanco conecte = new ConexaoBanco();
    ModelMed cad = new ModelMed();

    public void Inserir(ModelMed med) {
        conecte.conexao();
        PreparedStatement pst = null;
        try {
            pst = conecte.conn.prepareStatement("INSERT INTO medico (nome,especialidade,crm,plantao,cpf) VALUE(?,?,?,?,?)");
            pst.setString(1, med.getNome());
            pst.setString(2, med.getEspecialidade());
            pst.setInt(3, med.getCrm());
            pst.setString(4, med.getPlantao());
            pst.setString(5, med.getCpf());
   
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dos dados!/nErro:" + ex);
        } finally {
            conecte.desconecta();
        }
    }

    public void Alterar(ModelMed med) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("update medico set nome=?, especialidade=?, plantao=?, cpf=? where crm=?");
            pst.setString(1, med.getNome());
            pst.setString(2, med.getEspecialidade());
            pst.setString(3, med.getPlantao());
            pst.setString(4, med.getCpf());
            pst.setInt(5, med.getCrm());
            
            
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!/nErro:" + ex);
        } finally {
            conecte.desconecta();
        }
    }

    public void Excluir(ModelMed med) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("delete from medico where crm =?");
            pst.setInt(1, med.getCrm());
            pst.execute();
           //JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados! /nErro:" + ex);
        }

        conecte.desconecta();
    }

    public void Salvar(ModelMed med) {
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("INSERT INTO medico (nome,especialidade,crm,plantao,cpf) VALUES(?,?,?,?,?)");
            
            pst.setString(1, med.getNome());
            pst.setString(2, med.getEspecialidade());
            pst.setInt(3, med.getCrm());
            pst.setString(4, med.getPlantao());
            pst.setString(5, med.getCpf());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
    }
    
    public ModelMed pesquisar(ModelMed med){
        conecte.conexao();
        
        //conecte.executaSql("select crm,especialidade,plantao,tipo,cpf from medico inner join caduser on iduser = id_user where nome like'%"+med.getPesquisa()+"%'");
        conecte.executaSql("select *from medico where nome like'%" + med.getPesquisa()+"%'");
        try {
            conecte.rs.first();
            
            med.setNome(conecte.rs.getString("nome"));
            med.setEspecialidade(conecte.rs.getString("especialidade"));
            med.setCrm(conecte.rs.getInt("crm"));
            med.setPlantao(conecte.rs.getString("plantao"));
            med.setCpf(conecte.rs.getString("cpf"));
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Médico não cadastrado");
        }
        conecte.desconecta();
            return med;
        
    }
}
