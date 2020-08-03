/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import conection.ConexaoBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelBeans.BeansAgenda;
import modelBeans.ModelPac;

/**
 *
 * @author Caio Araújo
 */
public class DoaAgenda {
    BeansAgenda agenda = new BeansAgenda();
    ConexaoBanco conecte = new ConexaoBanco();
    ConexaoBanco conectePaciente = new ConexaoBanco();
    ConexaoBanco conecteMedico = new ConexaoBanco();
    
    int codMed;
    int codPac;

    
    public void Salvar(BeansAgenda agenda){
        BuscaMedico(agenda.getNome_mec());
        BuscaPaciente(agenda.getNome_pac());
        conecte.conexao();
        try{
        PreparedStatement pst = conecte.conn.prepareStatement("insert into agenda(pac_id, medico_id, motivo_agenda, turno_agenda, data_agenda, status_agenda)values(?,?,?,?,?,?)");
        pst.setInt(1, codPac);
        pst.setInt(2, codMed);
        pst.setString(3, agenda.getMotivo());
        pst.setString(4, agenda.getTurno());
        pst.setDate(5, new java.sql.Date(agenda.getData().getTime()));
        pst.setString(6, agenda.getStatus());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar agendamento"+ex);
        }
        conecte.desconecta();
    }
    public void BuscaMedico(String nomeMedico){
        conecteMedico.conexao();
        conecteMedico.executaSql("select *from medico where nome='"+nomeMedico+"'");
        try {
            conecteMedico.rs.first();
            codMed=conecteMedico.rs.getInt("crm");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Médico"+ex);
        }
    }
    
    public void BuscaPaciente(String nomePaciente){
        conectePaciente.conexao();
        conectePaciente.executaSql("select *from paciente where nome_pac='"+nomePaciente+"'");
        try {
            conectePaciente.rs.first();
            codPac=conectePaciente.rs.getInt("id_pac");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Paciente"+ex);
        }
    }
    
  }