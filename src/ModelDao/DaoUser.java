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
public class DaoUser {
    ConexaoBanco conecte = new ConexaoBanco();
    ModelUser cad = new ModelUser();

    public void Inserir(ModelUser med) {
        conecte.conexao();
        PreparedStatement pst = null;
        try {
            pst = conecte.conn.prepareStatement("INSERT INTO CadUser (nome_user,cpf, senha, tipo) VALUE(?,?,?,?)");
            pst.setString(1, med.getNome());
            pst.setString(2, med.getCpf());
            pst.setString(3, med.getSenha());
            pst.setString(4, med.getTipo());

   
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dos dados!/nErro:" + ex);
        } finally {
            conecte.desconecta();
        }
    }

    public void Alterar(ModelUser med) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("update caduser set nome_user=?,cpf=?, senha=?, tipo=? where id_user=?");
            pst.setString(1, med.getNome());
            pst.setString(2, med.getCpf());
            pst.setString(3, med.getSenha());
            pst.setString(4, med.getTipo());
            pst.setInt(5, med.getId_user());

            
            
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!/nErro:" + ex);
        } finally {
            conecte.desconecta();
        }
    }

    public void Excluir(ModelUser user) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("delete from caduser where id_user =?");
            pst.setInt(1, user.getId_user());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados! /nErro:" + ex);
        }

        conecte.desconecta();
    }

    public void Salvar(ModelUser med) {
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("INSERT INTO caduser (nome_user,cpf, senha, tipo) VALUES(?,?,?,?)");
            
            pst.setString(1, med.getNome());
            pst.setString(2, med.getCpf());
            pst.setString(3, med.getSenha());
            pst.setString(4, med.getTipo());

            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
    }
    
    public ModelUser pesquisar(ModelUser mod){
        conecte.conexao();
        
        //conecte.executaSql("select crm,especialidade,plantao,tipo,cpf from medico inner join caduser on iduser = id_user where nome like'%"+med.getPesquisa()+"%'");
        conecte.executaSql("select *from caduser where nome_user like'%" + mod.getPesquisa()+"%'");
        try {
            conecte.rs.first();
            
            mod.setId_user(conecte.rs.getInt("id_user"));
            mod.setNome(conecte.rs.getString("nome_user"));
            mod.setCpf(conecte.rs.getString("cpf"));
            mod.setSenha(conecte.rs.getString("senha"));
            mod.setTipo(conecte.rs.getString("tipo"));
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
        }
        conecte.desconecta();
            return mod;
        
    }
    
}
