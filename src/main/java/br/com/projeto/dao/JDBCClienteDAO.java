package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.dao.interfaces.ClienteDAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.util.FabricaConexoes;

public class JDBCClienteDAO implements ClienteDAO {

    //CRIAÇÃO DA DEPENDENCIA
    private FabricaConexoes fabricaConexoes;

    public JDBCClienteDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public void cadastrarClientes(Cliente obj) throws Exception {
        try{
            Connection con = fabricaConexoes.getConnection();

            String sql = "INSERT INTO tb_clientes (nome, email, cpf, celular, endereco, obs) values (?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getObs());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso");
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar cliente: " +erro);
            
        }
        
    }

    @Override
    public void alterarCliente(Cliente obj) {
        try {

            Connection con = fabricaConexoes.getConnection();

            String sql = "UPDATE tb_clientes SET nome=?, email=?, cpf=?, celular=?, endereco=?, obs=? WHERE ativo=1 AND id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getObs());
            stmt.setInt(7, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cliente Alterado com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro"+ e);
        }
        
    }

    @Override
    public Cliente buscarCliente(String nome) {
        try {

            Connection con = fabricaConexoes.getConnection();
            String sql = "SELECT * FROM tb_clientes WHERE nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();

            while(rs.next()){
                    obj.setId(rs.getInt("id"));

                    obj.setNome(rs.getString("nome"));            
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));           
                    obj.setCelular(rs.getString("celular"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setObs(rs.getString("obs"));
                }           
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro"+e);
        }
        return null;
    }

    @Override
    public Cliente buscarClienteCPF(String cpf) {
        try {

            Connection con = fabricaConexoes.getConnection();

            String sql = "SELECT * FROM tb_clientes WHERE ativo=1 AND cpf=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            Cliente obj = new Cliente();
            while(rs.next()){
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));            
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));           
                    obj.setCelular(rs.getString("celular"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setObs(rs.getString("obs"));
                }           
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+e);
        }
        return null;
    }

    @Override
    public Cliente buscarClienteId(String id) {
        try {
            Connection con = fabricaConexoes.getConnection();

            String sql = "SELECT * FROM tb_clientes WHERE ativo=1 AND id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();

            while(rs.next()){
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));            
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));           
                    obj.setCelular(rs.getString("celular"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setObs(rs.getString("obs"));
                }           
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro"+e);
        }
        return null;
    }

    @Override
    public void excluirCliente(Cliente obj) {
        try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "UPDATE tb_clientes SET ativo=0 WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cliente Excluido com Sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir cliente"+e);
        }
        
    }

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();

            String sql = "select * from tb_clientes WHERE ativo=1";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            Cliente obj = new Cliente();
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));            
            obj.setCpf(rs.getString("cpf"));
            obj.setEmail(rs.getString("email"));           
            obj.setCelular(rs.getString("celular"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setObs(rs.getString("obs"));            
            
            lista.add(obj);
            }
            return lista;            
            
        } catch (SQLException e) {
            throw new RuntimeException("erro ao criar a lista de clientes!!" +e);
        }
    }

    @Override
    public List<Cliente> pesquisarNome(String nome) {
        try {
            Connection con = fabricaConexoes.getConnection();

            List<Cliente> lista = new ArrayList<>();
            String sql = "SELECT * FROM tb_clientes where ativo=1 AND nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setObs(rs.getString("obs"));

                lista.add(obj);
               
            }

             return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao criar lista: "+e);
            throw new RuntimeException("erro ao criar a lista:" +e);
        }
    }
    
}
