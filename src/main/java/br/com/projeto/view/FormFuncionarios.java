/*
 *  LINHA 355 - BOTÃO SALVAR FUNCIONARIO
 *  LINHA 398 - BOTÃO EDITAR FUNCIONARIO 
 *  LINHA 427 - INTERAÇÕES COM A TABELA
 */
package br.com.projeto.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.projeto.dao.JDBCFuncionarioDAO;
import br.com.projeto.dao.interfaces.FuncionarioDAO;
import br.com.projeto.model.Funcionario;
import br.com.projeto.util.FabricaConexoes;


public class FormFuncionarios extends javax.swing.JFrame {

    FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
    FuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO(fabricaConexoes);
   
    public FormFuncionarios() {
        initComponents();
    }

    public void listar() throws SQLException {
        FuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO(fabricaConexoes);
        List<Funcionario> lista = funcionarioDAO.listarFuncionario();
        DefaultTableModel dados = (DefaultTableModel) tabelaFuncionarios.getModel();
        dados.setNumRows(0);

        for (Funcionario c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getEmail(),                
                c.getCargo(),
                c.getNivel_acesso(),
                c.getObs(),});

        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelGuiasFuncionarios = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoFuncionario = new javax.swing.JTextField();
        txtNomeFuncionario = new javax.swing.JTextField();
        txtEmailFuncionario = new javax.swing.JTextField();
        txtCargoFuncionario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtObsFuncionario = new javax.swing.JTextField();
        txtSenhaFuncionario = new javax.swing.JPasswordField();
        cbAcessoFuncionario = new javax.swing.JComboBox<>();
        btnSalvarFuncionario = new javax.swing.JButton();
        btnEditarFuncionario = new javax.swing.JButton();
        btnRemoverFuncionario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtPesquisarNome = new javax.swing.JTextField();
        btnPesquisarFuncionario = new javax.swing.JButton();
        btnListarFuncionarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(1022, 637));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Funcionarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setText("Codigo");

        jLabel3.setText("Nome:");

        jLabel4.setText("Email:");

        jLabel5.setText("Cargo:");

        jLabel6.setText("Acesso:");

        jLabel7.setText("Senha:");

        txtCodigoFuncionario.setEditable(false);

        txtNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFuncionarioActionPerformed(evt);
            }
        });

        jLabel8.setText("Observação:");

        txtSenhaFuncionario.setText("jPasswordField1");

        cbAcessoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario" }));

        btnSalvarFuncionario.setText("Salvar");

        btnSalvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSalvarFuncionarioActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        btnEditarFuncionario.setText("Editar");
        btnEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEditarFuncionarioActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        btnRemoverFuncionario.setText("Remover");
        btnRemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
                    try {
                        btnRemoverFuncionarioActionPerformed(evt);
                    } catch (SQLException e) {
                       
                        e.printStackTrace();
                    }
                
        }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmailFuncionario)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(326, 326, 326))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSenhaFuncionario)
                            .addComponent(txtCargoFuncionario)
                            .addComponent(cbAcessoFuncionario, 0, 210, Short.MAX_VALUE)))
                    .addComponent(txtObsFuncionario)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnRemoverFuncionario)
                        .addGap(120, 120, 120)
                        .addComponent(btnEditarFuncionario)
                        .addGap(133, 133, 133)
                        .addComponent(btnSalvarFuncionario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(306, 306, 306))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAcessoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtEmailFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(60, 60, 60))
                    .addComponent(txtObsFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarFuncionario)
                    .addComponent(btnEditarFuncionario)
                    .addComponent(btnRemoverFuncionario))
                .addGap(31, 31, 31))
        );

        painelGuiasFuncionarios.addTab("Daods de Funcionários", jPanel2);

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Email", "Cargo", "Acesso", "Obs"
            }
        ));
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);

        jLabel9.setText("Nome:");

        txtPesquisarNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarNomeMouseClicked(evt);
            }
        });
        txtPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarNomeActionPerformed(evt);
            }
        });

        btnPesquisarFuncionario.setText("Pesquisar");
        btnPesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarFuncionarioActionPerformed(evt);
            }
        });

        btnListarFuncionarios.setText("Listar ");
        btnListarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFuncionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarFuncionario))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(btnListarFuncionarios)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisarFuncionario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListarFuncionarios)
                .addGap(47, 47, 47))
        );

        painelGuiasFuncionarios.addTab("Busca de Funcionarios", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelGuiasFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(painelGuiasFuncionarios)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncionarioActionPerformed

    private void btnSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSalvarFuncionarioActionPerformed
        //BOTÃO QUE SALVA O FUNCIONARIO
        Funcionario obj = new Funcionario();
        
        obj.setNome(txtNomeFuncionario.getText());
        obj.setEmail(txtEmailFuncionario.getText());
        obj.setSenha(txtSenhaFuncionario.getText());        
        obj.setCargo(txtCargoFuncionario.getText());
        obj.setNivel_acesso(cbAcessoFuncionario.getSelectedItem().toString());
        obj.setObs(txtObsFuncionario.getText());
        
        FuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO(fabricaConexoes);
        funcionarioDAO.cadastrarFuncionario(obj);
        
        
    }//GEN-LAST:event_btnSalvarFuncionarioActionPerformed

    private void btnListarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFuncionariosActionPerformed
        // BOTAO PARA LISTAR FUNCIONARIOS NA TABELA
        try {
            listar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                //
    }//GEN-LAST:event_btnListarFuncionariosActionPerformed

    private void btnRemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnRemoverFuncionarioActionPerformed
        //BOTAO PRA REMOVER FUNCIONARIO

        Funcionario obj = new Funcionario();
        obj.setId(Integer.valueOf(txtCodigoFuncionario.getText()));
        FuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO(fabricaConexoes);

        funcionarioDAO.excluirFuncionario(obj);




    }//GEN-LAST:event_btnRemoverFuncionarioActionPerformed

    private void btnEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnEditarFuncionarioActionPerformed
        // BOTAO PARA EDITAR FUNCIONARIO
         
        Funcionario obj = new Funcionario();
        obj.setNome(txtNomeFuncionario.getText());
        obj.setEmail(txtEmailFuncionario.getText());
        obj.setSenha(txtSenhaFuncionario.getText());        
        obj.setCargo(txtCargoFuncionario.getText());
        obj.setNivel_acesso(cbAcessoFuncionario.getSelectedItem().toString());
        obj.setObs(txtObsFuncionario.getText());
        
        obj.setId(Integer.valueOf(txtCodigoFuncionario.getText()));

        FuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO(fabricaConexoes);
        funcionarioDAO.alterarFuncionario(obj);
    }//GEN-LAST:event_btnEditarFuncionarioActionPerformed

    private void btnPesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarFuncionarioActionPerformed
        // BOTAO PRA PESQUISAR FUNCIONARIO
    }

    private void txtPesquisarNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarNomeMouseClicked
        // CLICAR NO MOUSE E IR PRA TELA DE CADASTRO
    }

    private void txtPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarNomeActionPerformed
        // PESQUISAR NOME ENQUANTO VAI DIGITANDO
    }

    //INTERAÇÕES COM A TABELA
    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        // CLICAR NO MOUSE E ALTERAR TABELA + PREENCHE A TABELA COM OS VALORES DA LINHA CLICADA
        painelGuiasFuncionarios.setSelectedIndex(0);
        txtCodigoFuncionario.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 0).toString());
        txtNomeFuncionario.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 1).toString());
        txtEmailFuncionario.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 2).toString());
        txtCargoFuncionario.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 3).toString());
        cbAcessoFuncionario.setSelectedItem(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 4).toString());
        txtObsFuncionario.setText(tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 5).toString());
        
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

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
            java.util.logging.Logger.getLogger(FormFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarFuncionario;
    private javax.swing.JButton btnListarFuncionarios;
    private javax.swing.JButton btnPesquisarFuncionario;
    private javax.swing.JButton btnRemoverFuncionario;
    private javax.swing.JButton btnSalvarFuncionario;
    private javax.swing.JComboBox<String> cbAcessoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane painelGuiasFuncionarios;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTextField txtCargoFuncionario;
    private javax.swing.JTextField txtCodigoFuncionario;
    private javax.swing.JTextField txtEmailFuncionario;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtObsFuncionario;
    private javax.swing.JTextField txtPesquisarNome;
    private javax.swing.JPasswordField txtSenhaFuncionario;
    // End of variables declaration//GEN-END:variables
}
