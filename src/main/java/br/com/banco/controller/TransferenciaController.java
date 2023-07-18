package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.services.TransferenciaServices;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaServices transferencia;
	
	@GetMapping(produces = { "application/json" })
	public List<Transferencia> buscarTodas(@RequestParam(value = "nomeOperador", required = false) String nomeOperador,
			@RequestParam(value = "dataInicio", required = false) String dataInicio,
			@RequestParam(value = "dataFim", required = false) String dataFim){
				
		if (nomeOperador != null && (dataInicio != null || dataFim != null)) {
	        return transferencia.buscarPorNomeOperadorEPeriodo(nomeOperador, dataInicio, dataFim);
	    } else if (dataInicio != null && dataFim != null) {
	        return transferencia.buscarPorPeriodo(dataInicio, dataFim);
	    } else if (nomeOperador != null) {
	        return transferencia.buscarPorOperador(nomeOperador);
	    } else {
	        return transferencia.buscarTodas();
	    }
	}
	
	@GetMapping("/valorTotalPeriodo")
	public String valorTotalPeriodo(@RequestParam(value = "dataInicio", required = false) String dataInicio, @RequestParam(value = "dataFim", required = false) String dataFim) {
		return transferencia.valorTotalPeriodo(dataInicio, dataFim);
	}
	
	@GetMapping("/valorTotal")
	public String valorTotal() {
		return transferencia.valorTotal();
	}
}