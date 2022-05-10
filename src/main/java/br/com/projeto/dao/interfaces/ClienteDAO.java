package br.com.projeto.dao.interfaces;
import java.util.List;
import br.com.projeto.model.Cliente;

public interface ClienteDAO {

    public void cadastrarClientes(Cliente obj) throws Exception;
    public void alterarCliente(Cliente obj);
    public Cliente buscarCliente(String nome);
    public Cliente buscarClienteCPF(String cpf);
    public Cliente buscarClienteId(String id);
    public void excluirCliente(Cliente obj);
    public List<Cliente> listarCliente();
    public List<Cliente> pesquisarNome(String nome);
}
    
   
