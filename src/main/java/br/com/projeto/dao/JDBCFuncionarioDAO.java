package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.dao.interfaces.FuncionarioDAO;
import br.com.projeto.model.Funcionario;
import br.com.projeto.util.FabricaConexoes;
import br.com.projeto.view.FormMenu;
import br.com.projeto.view.FormVendas;
import br.com.projeto.view.Login;

public class JDBCFuncionarioDAO implements FuncionarioDAO {

    //CRIAÇÃO DA DEPENDENCIA
    private FabricaConexoes fabricaConexoes; 
    public JDBCFuncionarioDAO(FabricaConexoes fabricaConexoes) {
		this.fabricaConexoes = fabricaConexoes;
	}
	

	@Override
	public void cadastrarFuncionario(Funcionario obj) throws SQLException {
        try{
            Connection con = fabricaConexoes.getConnection();
            String sql = "INSERT INTO tb_funcionarios (nome, email, senha, cargo, nivel_acesso, obs) values (?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getCargo());
            stmt.setString(5, obj.getNivel_acesso());
            stmt.setString(6, obj.getObs());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado com sucesso");
            System.out.println("Funcionario Cadastrado");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Funcionario: " +erro);            
        }        
		
	}

	@Override
	public void alterarFuncionario(Funcionario obj) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "UPDATE tb_funcionarios SET nome=?, email=?, senha=?, cargo=?, nivel_acesso=?, obs=? WHERE ativo=1 AND id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getCargo());
            stmt.setString(5, obj.getNivel_acesso());
            stmt.setString(6, obj.getObs());
            stmt.setInt(7, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Funcionario Alterado com Sucesso");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar"+ e);
        }
		
	}

	@Override
	public void efetuarLogin(String email, String senha) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "SELECT * FROM tb_funcionarios where email=? and senha=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                if(rs.getString("nivel_acesso").equals("Administrador")){

                    FormMenu menu = new FormMenu();                                      

                    JOptionPane.showMessageDialog(null, "Administrador logado: ");                    
                    
                    menu.usuarioLogado = rs.getString("nome");
                    menu.setVisible(true);                    
                   
                } 
                else if(rs.getString("nivel_acesso").equals("Usuario")){
                    JOptionPane.showMessageDialog(null, "Usuario logado");

                    FormMenu menu = new FormMenu();
                    FormVendas venda = new FormVendas();

                    menu.usuarioLogado = rs.getString("nome");
                    venda.userLogado = rs.getString("nome");
                    //DEIXA O MENU DE FUNCIONARIOS INATIVO CASO NAO SEJA ADM
                    menu.jMenuItem2.setEnabled(false);
                    menu.setVisible(true);
                    
                }
                
            }
                else{
                    Login login = new Login();
                    JOptionPane.showMessageDialog(null, "Erro, verificar dados");
                    login.setVisible(true);
                } 

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao se logar" +e);
        }
		
	}

	@Override
	public void excluirFuncionario(Funcionario obj) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "UPDATE tb_funcionarios SET ativo=0 where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Funcionario Excluido com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir Funcionario"+e);
        }
		
	}

	@Override
	public List<Funcionario> listarFuncionario() {
		List<Funcionario> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();

            String sql = "select * from tb_funcionarios WHERE ativo=1";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

            Funcionario obj = new Funcionario();
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));            
            obj.setEmail(rs.getString("email"));                      
            obj.setCargo(rs.getString("cargo"));
            obj.setNivel_acesso(rs.getString("nivel_acesso"));
            obj.setObs(rs.getString("obs"));
            
            
            lista.add(obj);
            }
            return lista;
            
            
        } catch (SQLException e) {
            throw new RuntimeException("erro ao criar a lista de clientes!!" +e);
        }
		
	}
    
}
