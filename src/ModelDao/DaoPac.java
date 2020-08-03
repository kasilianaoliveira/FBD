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
import modelBeans.ModelPac;

/**
 *
 * @author kasil
 */
public class DaoPac {
    
    ConexaoBanco conecte = new ConexaoBanco();
    ConexaoBanco conecteBairro = new ConexaoBanco();
    ModelPac cad = new ModelPac();
    String nomeBairro; //para receber o nome do bairro e mostrar na tabela
    int cod_endereco; //para receber o cod da table endereco e passar para chave estrangeira em paciente

    
    
    public void Salvar(ModelPac cad) {
        buscarCodEnd(cad.getNomeBairro());
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("INSERT INTO paciente (nome_pac, sexo_pac, idade_pac, cpf_pac,telefone_pac,id_end) VALUES(?,?,?,?,?,?)");
            
            pst.setString(1, cad.getNome_pac());
            pst.setString(2, cad.getSexo());
            pst.setInt(3, cad.getIdade());
            pst.setString(4, cad.getCpf());
            pst.setString(5, cad.getTelefone());
            pst.setInt(6,cod_endereco);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
    }
    
    public void Alterar (ModelPac cad) {
        buscarCodEnd(cad.getNomeBairro());
        conecte.conexao();

        try {
            PreparedStatement pst = conecte.conn.prepareStatement("update paciente set nome_pac=?, sexo_pac=?, idade_pac=?, cpf_pac=?,telefone_pac=?,id_end=? where id_pac =?");
            
            pst.setString(1, cad.getNome_pac());
            pst.setString(2, cad.getSexo());
            pst.setInt(3, cad.getIdade());
            pst.setString(4, cad.getCpf());
            pst.setString(5, cad.getTelefone());
            pst.setInt(6,cod_endereco);
            pst.setInt(7, cad.getId_pac());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados!/nErro:" + ex.getMessage());
        }

        conecte.desconecta();
    }
 
    
    public void Excluir(ModelPac cad) {
        conecte.conexao();
        try {
            PreparedStatement pst = conecte.conn.prepareStatement("delete from paciente where id_pac =?");
            pst.setInt(1, cad.getId_pac());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados! /nErro:" + ex);
        }

        conecte.desconecta();
    }
    
    public ModelPac pesquisar(ModelPac cad){
        conecte.conexao();
        
        //conecte.executaSql("select crm,especialidade,plantao,tipo,cpf from medico inner join caduser on iduser = id_user where nome like'%"+med.getPesquisa()+"%'");
            conecte.executaSql("select *from paciente where nome_pac like'%" + cad.getPesquisar()+"%'");
        try {
            
            conecte.rs.first();
            
            //nome_pac=?, sexo_pac=?, idade_pac=?, cpf_pac=?,telefone_pac=?,id_end =? where id_pac=?");
            buscaNomeBairro(conecte.rs.getInt("id_end"));
            cad.setNome_pac(conecte.rs.getString("nome_pac"));
            cad.setSexo(conecte.rs.getString("sexo_pac"));
            cad.setIdade(conecte.rs.getInt("idade_pac"));
            cad.setCpf(conecte.rs.getString("cpf_pac"));
            cad.setTelefone(conecte.rs.getString("telefone_pac"));
            cad.setId_pac(conecte.rs.getInt("id_pac"));
            cad.setNomeBairro(nomeBairro);//está diferente pois a variavel tem armazenado as informações usando outros metodos
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Paciente não cadastrado"+e);
        }
        conecte.desconecta();
            return cad;
        
    }
    //paciente tem uma chave estrangeira endereço, para mostrar o nome na tela é necessario abrir uma nova conexao e selecionar o id e ligar ao cod que voce pega no metodo (BuscarCod)
    public void buscaNomeBairro(int cod){
        conecteBairro.conexao();            
        
        
        try {
            conecteBairro.executaSql("select *from endereco where id_endereco="+cod);
            conecteBairro.rs.first();
            nomeBairro= conecteBairro.rs.getString("bairro");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao buscar nome do bairro"+ex);
        }
        conecteBairro.desconecta();
    }
    
    //esse metedo serve para pegar o valor do id da table endereço e aplicar na variavel nome que servirá paea mostrar na table do paciente o nome do bairro
    public void buscarCodEnd(String nome){ 
        conecte.conexao();
        
        conecte.executaSql("select *from endereco where bairro='"+nome+"'");
        try {
            conecte.rs.first();
            cod_endereco = conecte.rs.getInt("id_endereco");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar bairro\n"+ex);
        }
        
        conecte.desconecta();
    }
}
