/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ModelDao.DoaAgenda;
import ModelDao.Table;
import conection.ConexaoBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelBeans.BeansAgenda;

/**
 *
 * @author kasil
 */
public class Agendamento extends javax.swing.JFrame {
    ConexaoBanco conecte = new ConexaoBanco();
    BeansAgenda agenda = new BeansAgenda();

    public Agendamento() {
        initComponents();
        preencherMedicos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jComboBoxMedico = new javax.swing.JComboBox<>();
        jTextFieldMotivo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePac = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        quadro = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Paciente:");

        jLabel3.setText("Médico:");

        jLabel4.setText("Data:");

        jLabel5.setText("Motivo:");

        jLabel6.setText("Turno:");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));

        jComboBoxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTablePac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePac);

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 588, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTurno, 0, 1, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCancelar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonFinalizar)
                        .addGap(283, 283, 283)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizar)
                    .addComponent(jButtonCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 710, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agendamento.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        quadro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Rectangle 49_1.png"))); // NOI18N
        getContentPane().add(quadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Desktop - 19.png"))); // NOI18N
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1360, 740));

        setSize(new java.awt.Dimension(1360, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void preencherMedicos(){
        conecte.conexao();
        conecte.executaSql("select *from medico order by nome");
        try {
            conecte.rs.first();
            jComboBoxMedico.removeAllItems();
            do{
               jComboBoxMedico.addItem(conecte.rs.getString("nome"));
            }while(conecte.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher Medicos"+ex);
        }
        conecte.desconecta();
    }
    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        agenda.setNome_pac(jTextFieldPaciente.getText());
        agenda.setNome_mec((String) jComboBoxMedico.getSelectedItem());
        agenda.setTurno((String) jComboBoxTurno.getSelectedItem());
        agenda.setMotivo(jTextFieldMotivo.getText());
        agenda.setData(jDateChooser2.getDate());
        agenda.setStatus("Aberto");
        DoaAgenda dao = new DoaAgenda();
        dao.Salvar(agenda);
        
        //dispose();
        jTextFieldPaciente.setText(""); 
        jDateChooser2.setDate(null);
        jTextFieldMotivo.setText("");
        jComboBoxTurno.setEnabled(!true);
        jComboBoxMedico.setEnabled(!true);
        jDateChooser2.setEnabled(!true);
        jTextFieldMotivo.setEnabled(!true);
        jButtonFinalizar.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarTabela("select id_pac, nome_pac, idade_pac, cpf_pac, telefone_pac, bairro from paciente inner join endereco on id_end=id_endereco where nome_pac like'%" + jTextFieldPaciente.getText()+"%'");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacMouseClicked
        String nomePac = ""+jTablePac.getValueAt(jTablePac.getSelectedRow(),1);//oq for selecionado e vai colocar na string
        conecte.conexao();
        conecte.executaSql("select *from paciente where nome_pac ='"+nomePac+"'");
        try {
            conecte.rs.first();
            jTextFieldPaciente.setText(conecte.rs.getString("nome_pac"));

                conecte.desconecta();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar o dados"+ex);
        }
        conecte.desconecta();
        jComboBoxTurno.setEnabled(true);
        jComboBoxMedico.setEnabled(true);
        jDateChooser2.setEnabled(true);
        jTextFieldMotivo.setEnabled(true);
        jButtonFinalizar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }//GEN-LAST:event_jTablePacMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldPaciente.setText(""); 
        jDateChooser2.setDate(null);
        jTextFieldMotivo.setText("");
        jComboBoxTurno.setEnabled(!true);
        jComboBoxMedico.setEnabled(!true);
        jDateChooser2.setEnabled(!true);
        jTextFieldMotivo.setEnabled(!true);
        jButtonFinalizar.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public void atualizarTabela(String SQL){
        //dados = new ArrayList(); 
        ArrayList dados = new ArrayList();      
        String[] Colunas = new String[]{"ID","Nome","Idade", "CPF", "Telefone","Bairro"};//nome das colunas
        
        conecte.conexao();
        conecte.executaSql(SQL);
        
        try {
            conecte.rs.first();
             do{
                 dados.add(new Object[]{
                     
                     conecte.rs.getString("id_pac"),
                     conecte.rs.getString("nome_pac"),//pega do banco
                     conecte.rs.getString("idade_pac"),
                     conecte.rs.getString("cpf_pac"),
                     conecte.rs.getString("telefone_pac"), 
                     conecte.rs.getString("bairro")
                     
                 });
            }while(conecte.rs.next());//quando passar para o proximo para
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Verifique se escreveu corretamente");
        }
        
        Table tab = new Table(dados, Colunas);

        jTablePac.setModel(tab);
        jTablePac.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePac.getColumnModel().getColumn(0).setResizable(false);
        jTablePac.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTablePac.getColumnModel().getColumn(1).setResizable(false);
        jTablePac.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTablePac.getColumnModel().getColumn(2).setResizable(false);
        jTablePac.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTablePac.getColumnModel().getColumn(3).setResizable(false);
        jTablePac.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTablePac.getColumnModel().getColumn(4).setResizable(false);
        jTablePac.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTablePac.getColumnModel().getColumn(5).setResizable(false);


        jTablePac.getTableHeader().setReorderingAllowed(false);//não vai poder reorganizar as ordem das colunas
        jTablePac.setAutoResizeMode(jTablePac.AUTO_RESIZE_OFF);//O usuario não vai poder modificar o tamanho da tabela
        jTablePac.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//so vai poder selecionar um dado por vez

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
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JComboBox<String> jComboBoxMedico;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePac;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    private javax.swing.JLabel quadro;
    // End of variables declaration//GEN-END:variables
}
