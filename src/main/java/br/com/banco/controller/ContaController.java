package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Conta;
import br.com.banco.services.ContaServices;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaServices conta;

	@GetMapping(produces = { "application/json" })
	public List<Conta> buscarTodas() {
		return conta.bustarTodas();
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public Optional<Conta> buscarPorId(Long id) {
		return conta.buscarPorId(id);
	}
}