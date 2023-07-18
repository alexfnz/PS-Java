package br.com.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaServices {
	
	@Autowired
	ContaRepository contaRepository;

	public List<Conta> bustarTodas() {
		return contaRepository.findAll();
	}
	
	public Optional<Conta> buscarPorId(Long id) {
		return contaRepository.findById(id);
	}
}