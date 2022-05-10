package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.dao.interfaces.VendaDAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Vendas;
import br.com.projeto.util.FabricaConexoes;

public class JDBCVendaDAO implements VendaDAO{

    //CRIAÇÃO DA DEPENDENCIA
    private FabricaConexoes fabricaConexoes;
    public JDBCVendaDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public void cadastrarVenda(Vendas obj) throws SQLException {
        try{
            Connection con = fabricaConexoes.getConnection();

            String sql = "insert into tb_vendas(data_venda, total_venda, obs, nome_cliente, nome_funcionario,forma_pagamento) values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, obj.getData_venda());
            stmt.setDouble(2, obj.getTotal_venda());
            stmt.setString(3, obj.getObs());
            stmt.setString(4, obj.getNome_cliente());
            stmt.setString(5, obj.getNome_funcionario());
            stmt.setString(6, obj.getForma_pagamento());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null,"Venda Cadastrada com sucesso");
            
            
        
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR VENDA" +e);
        }
        
    }

    @Override
    public List<Vendas> listarVendaFiadas()throws Exception {
        List<Vendas> lista = new ArrayList<>();
        try {
            Connection con = fabricaConexoes.getConnection();

            String sql = "select * from tb_vendas WHERE forma_pagamento='Credito Loja' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            Vendas obj = new Vendas();
            obj.setId(rs.getInt("id"));
            obj.setData_venda(rs.getString("data_venda"));        
            obj.setTotal_venda(rs.getDouble("total_venda"));
            obj.setNome_cliente(rs.getString("nome_cliente"));        
            obj.setForma_pagamento(rs.getString("forma_pagamento"));
            
            
            lista.add(obj);
            }
            return lista;
            
            
        } catch (SQLException e) {
            throw new RuntimeException("erro ao criar a lista de clientes!!" +e);
        }
    }

    @Override
    public List<Vendas> historicoVendas(LocalDate data_inicio, LocalDate data_fim) throws SQLException{
        List<Vendas>lista = new ArrayList<>();
        Connection con = fabricaConexoes.getConnection();

            String sql = "select id, date_format(data_venda, '%d/%m/%y') as data_formatada, nome_cliente, total_venda, forma_pagamento from tb_vendas where data_venda BETWEEN ? and ?";

            PreparedStatement stmt;            
            stmt = con.prepareStatement(sql);            
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            Vendas obj = new Vendas();
                Cliente c = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setData_venda(rs.getString("data_formatada"));
                obj.setNome_cliente(rs.getString("nome_cliente"));
                obj.setTotal_venda(rs.getDouble("total_venda"));
                obj.setForma_pagamento(rs.getString("forma_pagamento"));
                
                obj.setCliente(c);
                lista.add(obj);                
            }
            return lista;
    }
    
}
