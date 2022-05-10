/*
 * LINHA 153 - ITENS DO MENU
 */

package br.com.projeto.view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class FormMenu extends javax.swing.JFrame {
    
    public String usuarioLogado;
    public String userLogado;

    
    public FormMenu() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/imagens/fotoagrotop.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        menuClientes.setText("Clientes");
        menuClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setText("Controle de Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuClientes.add(jMenuItem1);

        jMenuBar1.add(menuClientes);

        menuFuncionarios.setText("Funcionarios");
        menuFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem2.setText("Controle de Funcionarios");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuFuncionarios.add(jMenuItem2);

        jMenuBar1.add(menuFuncionarios);

        menuProdutos.setText("Produtos");
        menuProdutos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem3.setText("Cadastro de Produtos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuProdutos.add(jMenuItem3);

        jMenuBar1.add(menuProdutos);

        menuVendas.setText("Vendas");
        menuVendas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem4.setText("PDV 01");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuVendas.add(jMenuItem4);

        jMenuBar1.add(menuVendas);

        jMenu5.setText("Relatorios e Informações");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });

        jMenuItem5.setText("Clientes com conta em aberto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Informações de Produtos");
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1857, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }

    //FUNÇÃO QUE É ATIVADA AO INICIAR O PROGRRAMA, 
    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        //DEFINI TELA CHEIA PARA O PROGRAMA
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
        this.setVisible(true);
    }

    //MENU QUE DA ACESSO AO FORM DE VENDAS
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        
        FormVendas v = new FormVendas();
        v.setVisible(true);
    }

    //MENU QUE DA ACESSO AO FORM DE FUNCIONARIOS
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        FormFuncionarios f = new FormFuncionarios();
        f.setVisible(true);
    }

    //MENU QUE DA ACESSO AO FORM DE CLIENTES
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        FormClientes c = new FormClientes();
        c.setVisible(true);
    }

    //MENU QUE DA ACESSO AO FORM DE PRODUTOS
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        FormProdutos p = new FormProdutos();
        p.setVisible(true);
    }

    //MENU QUE DA ACESSO AO FORM DE RELATÓRIOS
    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        Relatorios r = new Relatorios();
        r.setVisible(false);
    }

    //MENU QUE DA ACESSO AO FORM DE RELATORIOS DE CLIENTES
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        RelatoriosClientes rc = new RelatoriosClientes();
        rc.setVisible(true);
    }

   
    //[SWING]
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // [SWING] DECLARAÇÃO DE VARIAVEIS
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuFuncionarios;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuVendas;
}
