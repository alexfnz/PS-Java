package br.com.banco.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_transferencia", nullable = false)
	private String data_transferencia;
	
	@Column(name = "valor", nullable = false)
	private String valor;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "nome_operador_transacao", nullable = false)
	private String nome_operador_transacao;
	
	@Column(name = "conta_id")
	private Long conta_id;
	
	@ManyToOne
	@JoinColumn(name = "conta_id_fk")
	private Conta conta;
	
	public Transferencia() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData_transferencia() throws ParseException {
		String data = data_transferencia.replace("+03", "");
		Date novaData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(novaData);
	}

	public void setData_transferencia(String data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
        DecimalFormat formato = new DecimalFormat("0.00");
		this.valor = formato.format(valor);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public Long getConta_id() {
		return conta_id;
	}

	public void setConta_id(Long conta_id) {
		this.conta_id = conta_id;
	}
	
}
