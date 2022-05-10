package br.com.projeto.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.dao.JDBCClienteDAO;
import br.com.projeto.dao.JDBCProdutoDAO;
import br.com.projeto.dao.interfaces.ClienteDAO;
import br.com.projeto.dao.interfaces.ProdutoDAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.util.FabricaConexoes;

import java.util.logging.Level;
import java.util.logging.Logger;


public class FormClientes extends javax.swing.JFrame {

    FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
    ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
    ProdutoDAO produtoDAO = new JDBCProdutoDAO(fabricaConexoes);


   //DECLARAÇÃO DAS VARIAVEIS
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JButton btnSalvarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane painelDeGuiasjTabbedPane4;
    private javax.swing.JTable tabelaClientesjTable1;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtObs;

    public FormClientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
 
    //INICIALIZAÇÃO DOS COMPONENTES
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelDeGuiasjTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txtNome1 = new javax.swing.JTextField();
        btnListarClientes = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientesjTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        btnSalvarCliente = new javax.swing.JButton();
        btnRemoverCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1022, 637));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    txtNome1KeyReleased(evt);
                } catch (SQLException e) {
                   
                    e.printStackTrace();
                }
            }
        });

        btnListarClientes.setText("Listar");
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnListarClientesActionPerformed(evt);
                } catch (SQLException e) {
                   
                    e.printStackTrace();
                }
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnPesquisarActionPerformed(evt);
                } catch (SQLException e) {
                    
                    e.printStackTrace();
                }
            }
        });


        //CRIAÇÃO DA TABELA DE CLIENTES 
        tabelaClientesjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Email", "CPF", "Celular", "Endereço", "Obs"
            }
        ));
        tabelaClientesjTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesjTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientesjTable1);

        jLabel11.setText("Nome:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel11)
                        .addGap(240, 240, 240)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnListarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnListarClientes)
                .addGap(23, 23, 23))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(382, Short.MAX_VALUE)))
        );

        //CAMPOS DE TEXTO
        painelDeGuiasjTabbedPane4.addTab("Busca de clientes", jPanel3);

        jLabel2.setText("Codigo:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Email:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Celular:");

        jLabel7.setText("E:ndereco");

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel8.setText("Observacoes:");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        //BOTÃO PARA SALVAR CLIENTE
        btnSalvarCliente.setText("Salvar");
        btnSalvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSalvarClienteActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        //BOTÃO PARA REMOVER CLIENTE
        btnRemoverCliente.setText("Remover");
        btnRemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnRemoverClienteActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //BOTÃO PARA EDITAR CLIENTE
        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEditarClienteActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtObs))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(268, 268, 268))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(212, 212, 212))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnEditarCliente)
                .addGap(68, 68, 68)
                .addComponent(btnRemoverCliente)
                .addGap(74, 74, 74)
                .addComponent(btnSalvarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCliente)
                    .addComponent(btnRemoverCliente)
                    .addComponent(btnEditarCliente))
                .addGap(21, 21, 21))
        );

        painelDeGuiasjTabbedPane4.addTab("Dados do cliente", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDeGuiasjTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDeGuiasjTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

                                                   

    //FUNÇÃO QUE LISTA OS CLIENTES NA TABELA
    public void listar() throws SQLException {
        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        List<Cliente> lista = clienteDAO.listarCliente();
        DefaultTableModel dados = (DefaultTableModel) tabelaClientesjTable1.getModel();
        dados.setNumRows(0);

        for (Cliente c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getCpf(),
                c.getCelular(),
                c.getEndereco(),
                c.getObs(),});

        }
    }

    //BOTÃO SALVAR CLIENTE PEGANDO OS DADOS DOS CAMPOS
    private void btnSalvarClienteActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_btnSalvarClienteActionPerformed
        
        Cliente obj = new Cliente();
        obj.setNome(txtNome.getText());
        obj.setEmail(txtEmail.getText());
        obj.setCpf(txtCpf.getText());        
        obj.setCelular(txtCelular.getText());
        obj.setEndereco(txtEndereco.getText());
        obj.setObs(txtObs.getText());
        
        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        clienteDAO.cadastrarClientes(obj);
        
        
        
    }

    //BOTÃO QUE ATIVA A FUNÇÃO DE LISTAR OS CLIENTES
    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnListarClientesActionPerformed
       
        listar();
    }

    //BOTÃO QUE PESQUISA OS CLIENTES PELO NOME
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                             

        String nome = txtNome1.getText();
        Cliente obj = new Cliente();

        
        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        obj = clienteDAO.buscarCliente(nome);
        
        if(obj.getNome() != null){
            txtCodigo.setText(String.valueOf( obj.getId()));
            txtNome.setText(obj.getNome());
            txtEmail.setText(obj.getEmail());
            txtCpf.setText(obj.getCpf());
            txtCelular.setText(obj.getCelular());
            txtEndereco.setText(obj.getEndereco());
            txtObs.setText(obj.getObs());
            painelDeGuiasjTabbedPane4.setSelectedIndex(1);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não encontrado");
        }
    }

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    //BOTÃO QUE ATIVA A FUNÇÃO EXCLUIR CLIENTE
    private void btnRemoverClienteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnRemoverClienteActionPerformed
        
        Cliente obj = new Cliente();
        obj.setId(Integer.valueOf(txtCodigo.getText()));
        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        clienteDAO.excluirCliente(obj);
        
    }

    //BOTÃO QUE ATIVA A FUNÇÃO EXCLUIR CLIENTE
    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
                
        Cliente obj = new Cliente();

        obj.setNome(txtNome.getText());
        obj.setEmail(txtEmail.getText());
        obj.setCpf(txtCpf.getText());        
        obj.setCelular(txtCelular.getText());
        obj.setEndereco(txtEndereco.getText());
        obj.setObs(txtObs.getText());        
        obj.setId(Integer.valueOf(txtCodigo.getText()));

        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        clienteDAO.alterarCliente(obj);
    }

    //ESSA FUNÇÃO PEGA OS DADOS DOS CLIENTES CLICADO NA TABELA E JOGA PARA OS CAMPOS DO CADASTRO
    private void tabelaClientesjTable1MouseClicked(java.awt.event.MouseEvent evt) {  

        //FUNÇÃO QUE TROCA DE ABA                                                 
        painelDeGuiasjTabbedPane4.setSelectedIndex(1); 

        //PEGAR OS CAMPOS DAS ROW E JOGAR PARA OS CAMPOS DO CADASTRO
        txtCodigo.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 0).toString());
        txtNome.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 1).toString());
        txtEmail.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 2).toString());
        txtCpf.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 3).toString());
        txtCelular.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 4).toString());
        txtEndereco.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 5).toString());
        txtObs.setText(tabelaClientesjTable1.getValueAt(tabelaClientesjTable1.getSelectedRow(), 6).toString());


    }


    
    //METODO PARA BUSCAR O CLIENTE PELO NOME ENQUANTO VAI DIGITANDO
    private void txtNome1KeyReleased(java.awt.event.KeyEvent evt) throws SQLException {                                     
        String nome = "%" + txtNome1.getText() + "%";
        ClienteDAO clienteDAO = new JDBCClienteDAO(fabricaConexoes);
        List<Cliente> lista = clienteDAO.pesquisarNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tabelaClientesjTable1.getModel();
        dados.setNumRows(0);
        for(Cliente c : lista){
            dados.addRow(new Object[]{

                c.getId(),
                c.getNome(),
                c.getEmail(),
                c.getCpf(),
                c.getCelular(),
                c.getEndereco(),
                c.getObs()
            });

        }
         
        
    }
     

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormClientes().setVisible(true);
            }
        });
    }

 
    
    
}