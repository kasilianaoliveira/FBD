/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ModelDao.DaoMedico;
import ModelDao.Table;
import conection.ConexaoBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelBeans.ModelMed;
import modelBeans.ModelUser;

/**
 *
 * @author kasil
 */
public class CadastroMedico1 extends javax.swing.JFrame {

    ModelMed med = new ModelMed();
    DaoMedico dao = new DaoMedico();
    //ModelUser user = new ModelUser();
    ConexaoBanco conecte = new ConexaoBanco();
    int flag = 0;
    
    public CadastroMedico1() {
        initComponents();
        atualizarTabela("select *from medico order by nome");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextPlantao = new javax.swing.JTextField();
        jLabelMedico = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelEspecialidade = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jFormattedCrm = new javax.swing.JFormattedTextField();
        jTextEspecialidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelMedico3 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jLabelcpf = new javax.swing.JLabel();
        jFormattedCpf = new javax.swing.JFormattedTextField();
        quadro = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextPlantao.setEnabled(false);
        getContentPane().add(jTextPlantao, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 170, -1));

        jLabelMedico.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMedico.setText("Plantão:");
        getContentPane().add(jLabelMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crm :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, -1, -1));

        jLabelEspecialidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEspecialidade.setText("Especialidade:");
        getContentPane().add(jLabelEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 710, -1));

        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 820, 130));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, -1, -1));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, -1, -1));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, -1, -1));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, -1, -1));

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 570, -1, -1));

        jFormattedCrm.setEnabled(false);
        getContentPane().add(jFormattedCrm, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 100, -1));

        jTextEspecialidade.setEnabled(false);
        getContentPane().add(jTextEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/4.png"))); // NOI18N
        jLabel1.setToolTipText("Cadastro Médico");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, -1));

        jLabelMedico3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMedico3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMedico3.setText("Nome:");
        getContentPane().add(jLabelMedico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        jTextNome.setEnabled(false);
        getContentPane().add(jTextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 220, -1));

        jLabelcpf.setBackground(new java.awt.Color(255, 255, 255));
        jLabelcpf.setForeground(new java.awt.Color(255, 255, 255));
        jLabelcpf.setText("CPF:");
        getContentPane().add(jLabelcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        try {
            jFormattedCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedCpf.setEnabled(false);
        getContentPane().add(jFormattedCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 90, -1));

        quadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Rectangle 49_1.png"))); // NOI18N
        getContentPane().add(quadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Desktop - 19.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1370, 740));

        setSize(new java.awt.Dimension(1380, 769));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        //se o usuario quer realmente excluir
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if(resposta == JOptionPane.YES_OPTION){
            med.setCrm(Integer.parseInt(jFormattedCrm.getText()));
            dao.Excluir(med);
            
            jTextNome.setText("");
            jTextEspecialidade.setText("");
            jFormattedCrm.setText("");
            jTextPlantao.setText("");
            jFormattedCpf.setText("");
            jTextFieldPesquisar.setText("");
            
            atualizarTabela("select *from medico order by nome");

            jButtonNovo.setEnabled(true);
            jButtonAlterar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
   
        
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextNome.setEnabled(!true);//ativa os campos
        jTextEspecialidade.setEnabled(!true);
        jFormattedCrm.setEnabled(!true);
        jTextPlantao.setEnabled(!true);
        jFormattedCpf.setEnabled(!true);

        
        jButtonSalvar.setEnabled(!true);//desativa o botao de salvar
        jButtonCancelar.setEnabled(!true);
        
        jButtonNovo.setEnabled(true);
        
        jButtonAlterar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        
        jTextNome.setText("");
        jTextEspecialidade.setText("");//limpa os campos
        jFormattedCrm.setText("");
        jTextFieldPesquisar.setText("");

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        flag = 2;
        jTextNome.setEnabled(true);//ativa os campos
        jTextEspecialidade.setEnabled(true);
        jTextPlantao.setEnabled(true);
        jFormattedCpf.setEnabled(true);
        
        
        jButtonSalvar.setEnabled(true);//ativa o botao de salvar
        jButtonCancelar.setEnabled(true);
        jButtonAlterar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        atualizarTabela("select *from medico order by nome");
        
       // jFormattedCrm.setText("");
        
        
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        
       // jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       if(jTextPlantao.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Preencha o nome para continuar");// se for vazio avisará
           jTextPlantao.requestFocus(); // para usuario ver o campo q falta
       }else if(jTextEspecialidade.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Preencha sua especialidade para continuar");
           jTextEspecialidade.requestFocus();
        }else if(jFormattedCpf.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Preencha seu CPF para continuar");
           jFormattedCpf.requestFocus();   
       }else if(jFormattedCrm.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Preencha o crm para continuar");
           jFormattedCrm.requestFocus();
        }else
        if(flag == 1){
            med.setNome(jTextNome.getText());
            med.setEspecialidade(jTextEspecialidade.getText());
            med.setCrm(Integer.parseInt(jFormattedCrm.getText()));
            med.setPlantao(jTextPlantao.getText());
            med.setCpf(jFormattedCpf.getText());
            
            dao.Salvar(med);
            
            jTextNome.setText("");
            jTextEspecialidade.setText("");//limpa os campos
            jFormattedCrm.setText("");
            jTextPlantao.setText("");
            jFormattedCpf.setText("");
            
            jTextNome.setEnabled(false);
            jTextEspecialidade.setEnabled(false);
            jFormattedCrm.setEnabled(false);//desativa os campos
            jTextPlantao.setEnabled(false);
            jFormattedCpf.setEnabled(false);
            
            jButtonSalvar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            atualizarTabela("select *from medico order by nome");
             
       }else{
            med.setCrm(Integer.parseInt(jFormattedCrm.getText()));
            med.setNome(jTextNome.getText());
            med.setEspecialidade(jTextEspecialidade.getText());
            med.setPlantao(jTextPlantao.getText());
            med.setCpf(jFormattedCpf.getText());
            
            dao.Alterar(med);

            jTextNome.setEnabled(false);
            jTextEspecialidade.setEnabled(false);
            jFormattedCrm.setEnabled(false);
            jTextPlantao.setEnabled(false);
            jFormattedCpf.setEnabled(false);
            
            jButtonSalvar.setEnabled(false);

            jTextNome.setText("");
            jTextEspecialidade.setText("");
            jFormattedCrm.setText("");
            jTextPlantao.setText("");
            jFormattedCpf.setText("");
            jTextFieldPesquisar.setText("");

            jButtonNovo.setEnabled(true);
            jButtonAlterar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            atualizarTabela("select *from medico order by nome");
       }
       
       
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        
        jTextNome.setEnabled(true);
        jTextEspecialidade.setEnabled(true);
        jFormattedCrm.setEnabled(true);
        jTextPlantao.setEnabled(true);
        jFormattedCpf.setEnabled(true);

        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        
        jTextNome.setText("");
        jTextEspecialidade.setText("");
        jFormattedCrm.setText("");
        jTextPlantao.setText("");
        jFormattedCpf.setText("");
        
        atualizarTabela("select *from medico order by nome");
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        med.setPesquisa(jTextFieldPesquisar.getText());
        ModelMed model = dao.pesquisar(med);
        
        jTextNome.setText(model.getNome());
        jFormattedCrm.setText(String.valueOf(model.getCrm())); //transforma int em String
        jTextEspecialidade.setText(model.getEspecialidade());
        jTextPlantao.setText(String.valueOf(model.getPlantao()));
        jFormattedCpf.setText(model.getCpf());
        
        jButtonAlterar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        //conecte.executaSql("select crm,especialidade,plantao,tipo from medico inner join caduser on iduser = id_user where nome like'%"+med.getPesquisa()+"%'");
        atualizarTabela("select *from medico where nome like'%" + med.getPesquisa()+"%'");

        

   
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMouseClicked
                
       String nomeMed = ""+jTableMedico.getValueAt(jTableMedico.getSelectedRow(),0 );//oq for selecionado e vai colocar na string
        conecte.conexao();
        conecte.executaSql("select *from medico where nome ='"+nomeMed+"'");
        try {
 
            if(conecte.rs.first()){//vai pegar o primeiro clique e vai verificar se é depois verifcar no banco se realmente tem esses dados
                
                jTextNome.setText(conecte.rs.getString("nome"));
                jTextEspecialidade.setText(conecte.rs.getString("especialidade"));
                jFormattedCrm.setText(String.valueOf(conecte.rs.getInt("crm")));
                jTextPlantao.setText(conecte.rs.getString("plantao"));
                jFormattedCpf.setText(conecte.rs.getString("cpf"));
                //jPasswordConfirme.setText(conecte.rs.getString("login_id"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o dado"+ex);//caso de erro aparece uma mensagem
        }
        jButtonAlterar.setEnabled(true);//habilita botoes
        //jButtonSalvar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        conecte.desconecta();
        
    }//GEN-LAST:event_jTableMedicoMouseClicked

    public void atualizarTabela(String SQL){
        //dados = new ArrayList(); 
        ArrayList dados = new ArrayList();      
        String[] Colunas = new String[]{"Nome","Especialidade","Crm", "Plantão/Horas", "CPF"};//nome das colunas
        
        conecte.conexao();
        conecte.executaSql(SQL);
        
        try {
            conecte.rs.first();
             do{
                 dados.add(new Object[]{
                     
                     conecte.rs.getString("nome"),//pega do banco
                     conecte.rs.getString("especialidade"),    
                     conecte.rs.getInt("crm"),
                     conecte.rs.getString("plantao"),
                     conecte.rs.getString("cpf")
                 });
            }while(conecte.rs.next());//quando passar para o proximo para
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Verifique se escreveu corretamente");
        }
        
        Table tab = new Table(dados, Colunas);

        jTableMedico.setModel(tab);
        jTableMedico.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTableMedico.getColumnModel().getColumn(0).setResizable(false);
        jTableMedico.getColumnModel().getColumn(1).setPreferredWidth(190);
        jTableMedico.getColumnModel().getColumn(1).setResizable(false);
        jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableMedico.getColumnModel().getColumn(2).setResizable(false);
        jTableMedico.getColumnModel().getColumn(3).setPreferredWidth(170);
        jTableMedico.getColumnModel().getColumn(3).setResizable(false);
        jTableMedico.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableMedico.getColumnModel().getColumn(4).setResizable(false);

        jTableMedico.getTableHeader().setReorderingAllowed(false);//não vai poder reorganizar as ordem das colunas
        jTableMedico.setAutoResizeMode(jTableMedico.AUTO_RESIZE_OFF);//O usuario não vai poder modificar o tamanho da tabela
        jTableMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//so vai poder selecionar um dado por vez

        conecte.desconecta();

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMedico1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMedico1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundo;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedCpf;
    private javax.swing.JFormattedTextField jFormattedCrm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEspecialidade;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelMedico3;
    private javax.swing.JLabel jLabelcpf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextEspecialidade;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextPlantao;
    private javax.swing.JLabel quadro;
    // End of variables declaration//GEN-END:variables
}