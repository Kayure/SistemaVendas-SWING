package br.com.projeto.dao.interfaces;
import java.sql.SQLException;
import java.util.List;
import br.com.projeto.model.Funcionario;

public interface FuncionarioDAO{

    public void cadastrarFuncionario(Funcionario obj) throws SQLException;
    public void alterarFuncionario(Funcionario obj);
    public void efetuarLogin(String email, String senha);
    public void excluirFuncionario(Funcionario obj);
    public List<Funcionario> listarFuncionario();


} 