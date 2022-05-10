package br.com.projeto.dao.interfaces;
import java.util.List;
import br.com.projeto.model.Produto;

public interface ProdutoDAO { 

    public void cadastrarProduto(Produto obj);
    public Produto buscarProduto(String nome);
    public void alterarProduto(Produto obj);
    public void excluirProduto(Produto obj);
    public List<Produto>listarProdutosValidade();
    public List<Produto>listarProdutos();
    public List<Produto> pesquisarProduto(String nome);
}
    