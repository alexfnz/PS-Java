package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

	@Query("SELECT t FROM Transferencia t WHERE t.nome_operador_transacao LIKE %:nome_operador_transacao%")
    List<Transferencia> buscarPorOperador(@Param("nome_operador_transacao") String nomeOperador);
	
	@Query("SELECT t FROM Transferencia t WHERE (:dataInicio IS NULL OR t.data_transferencia >= :dataInicio) AND (:dataFim IS NULL OR t.data_transferencia <= :dataFim)")
    List<Transferencia> buscarPorPeriodo(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
	
	@Query("SELECT t FROM Transferencia t WHERE t.nome_operador_transacao LIKE %:nomeOperador% AND (:dataInicio IS NULL OR t.data_transferencia >= :dataInicio) AND (:dataFim IS NULL OR t.data_transferencia <= :dataFim)")
    List<Transferencia> buscarPorNomeOperadorEPeriodo(@Param("nomeOperador") String nomeOperador, @Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
	
	@Query("SELECT t FROM Transferencia t INNER JOIN Conta c ON c.id_conta = t.conta_id")
	List<Transferencia> buscarTodas();
	
	@Query("SELECT SUM(t.valor) FROM Transferencia t")
	String valorTotal();
	
	@Query("SELECT SUM(t.valor) FROM Transferencia t WHERE (:dataInicio IS NULL OR t.data_transferencia >= :dataInicio) AND (:dataFim IS NULL OR t.data_transferencia <= :dataFim)")
	String valorTotalPeriodo(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
}