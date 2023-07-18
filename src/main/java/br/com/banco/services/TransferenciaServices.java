package br.com.banco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaServices {
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	public TransferenciaServices(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }
	
    public List<Transferencia> buscarPorOperador(String nomeOperador) {
		return transferenciaRepository.buscarPorOperador(nomeOperador);
	}

    public List<Transferencia> buscarPorPeriodo(String dataInicio, String dataFim){
    	return transferenciaRepository.buscarPorPeriodo(dataInicio, dataFim);
    }

    public List<Transferencia> buscarPorNomeOperadorEPeriodo(String nomeOperador, String dataInicio, String dataFim){
    	return transferenciaRepository.buscarPorNomeOperadorEPeriodo(nomeOperador, dataInicio, dataFim);
    }
	
	public List<Transferencia> buscarTodas(){
		return transferenciaRepository.buscarTodas();
	}
	
	public String valorTotal() {
		return transferenciaRepository.valorTotal();
	}
	
	public String valorTotalPeriodo(String dataInicio, String dataFim) {
		return transferenciaRepository.valorTotalPeriodo(dataInicio, dataFim);
	}
}