package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.dao.interfaces.ProdutoDAO;
import br.com.projeto.model.Produto;
import br.com.projeto.util.FabricaConexoes;

public class JDBCProdutoDAO implements ProdutoDAO {

    //CRIAÇÃO DA DEPENDENCIA
    private FabricaConexoes fabricaConexoes;  
	public JDBCProdutoDAO(FabricaConexoes fabricaConexoes) {
		this.fabricaConexoes = fabricaConexoes;
	}

	@Override
	public void cadastrarProduto(Produto obj) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "insert into tb_produtos(descricao,qtd, precoCompra, precoVenda,  validade, promocao, categoria, obs) values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getDescricao());            
            stmt.setInt(2, obj.getQtd());
            stmt.setDouble(3, obj.getPrecoCompra());
            stmt.setDouble(4, obj.getPrecoVenda());
            stmt.setString(5, obj.getValidade());
            stmt.setString(6, obj.getPromocao());
            stmt.setString(7, obj.getCategoria());
            stmt.setString(8, obj.getObs());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto Cadastrado com sucesso");
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar produto" +e);
        }
		
	}

	@Override
	public Produto buscarProduto(String nome) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql ="select id, descricao, precoVenda, qtd, categoria from tb_produtos WHERE ativo=1 AND descricao=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
              
            Produto obj = new Produto();
               
            if(rs.next()){
               
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPrecoVenda(rs.getDouble("precoVenda"));
                obj.setQtd(rs.getInt("qtd"));            
            }
              return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"um erro ao buscar o produto aconteceu!" +e);
            return null;
        }
	}

	@Override
	public void alterarProduto(Produto obj) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "update tb_produtos set descricao=?, qtd=?, precoCompra=?, precoVenda=?,  validade=?, promocao=?, categoria=?, obs=? where ativo=1 AND id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setInt(2, obj.getQtd());
            stmt.setDouble(3, obj.getPrecoCompra());
            stmt.setDouble(4, obj.getPrecoVenda());
            stmt.setString(5, obj.getValidade());
            stmt.setString(6, obj.getPromocao());
            stmt.setString(7, obj.getCategoria());
            stmt.setString(8, obj.getObs());

            stmt.setInt(9, obj.getId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto Alterado com sucesso");

        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null,"ERRO AO ALTERAR PRODUTO"+e);
        }
		
	}

	@Override
	public void excluirProduto(Produto obj) {
		try {
            Connection con = fabricaConexoes.getConnection();
            String sql = "UPDATE tb_produtos SET ativo=0 where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null,"Produto Excluido com sucesso");

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"ERRO" +e);
        }
		
	}

	@Override
	public List<Produto> listarProdutosValidade() {
		try {
            List<Produto>listaValidade = new ArrayList<>();

            Connection con = fabricaConexoes.getConnection();
            String sql = "CALL `procedure_validade`(); ";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Produto obj = new Produto();

                obj.setValidade(rs.getString("validade"));
                obj.setDescricao(rs.getString("descricao"));                
                obj.setQtd(rs.getInt("qtd"));                
                obj.setPromocao(rs.getString("promocao")); 

                listaValidade.add(obj);
            }
            return listaValidade;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public List<Produto> listarProdutos() {
		try {
            List<Produto>lista = new ArrayList<>();

            Connection con = fabricaConexoes.getConnection();
            String sql = "select * from tb_produtos WHERE ativo=1";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Produto obj = new Produto();

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPrecoCompra(rs.getDouble("precoCompra"));
                obj.setPrecoVenda(rs.getDouble("precoVenda"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setValidade(rs.getString("validade"));
                obj.setPromocao(rs.getString("promocao"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setObs(rs.getString("obs"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public List<Produto> pesquisarProduto(String nome) {
		try {
            List<Produto> lista = new ArrayList<>();
            Connection con = fabricaConexoes.getConnection();
            String sql = "SELECT * FROM tb_produtos WHERE ativo=1 AND descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto obj = new Produto();

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPrecoCompra(rs.getDouble("precoCompra"));
                obj.setPrecoVenda(rs.getDouble("precoVenda"));
                obj.setQtd(rs.getInt("qtd"));
                obj.setValidade(rs.getString("validade"));
                obj.setPromocao(rs.getString("promocao"));
                obj.setCategoria(rs.getString("categoria"));
                obj.setObs(rs.getString("obs"));
                lista.add(obj);

            }
            return lista;
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
	}
    
}
