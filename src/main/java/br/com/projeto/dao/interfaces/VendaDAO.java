package br.com.projeto.dao.interfaces;
import br.com.projeto.model.Vendas;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface VendaDAO {

    public void cadastrarVenda(Vendas obj) throws SQLException;
    public List<Vendas> listarVendaFiadas() throws Exception;
    public List<Vendas> historicoVendas(LocalDate data_inicio, LocalDate data_fim) throws SQLException;

}
   