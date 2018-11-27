package model.entities;

import model.exception.DomainException;

public class Account {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public Account() {};

	public Account(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getnumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	
	public void saque(Double valor) {
		if(valor > saldo) {
			throw new DomainException("o valor excede o limite para saque.");
		}
		if(valor > limiteDeSaque) {
			throw new DomainException("saldo insuficiente.");
		}
		saldo -= valor;
	}

	@Override
	public String toString() {
		return "Conta numero: "
				+ numero 
				+ ", titular: "
				+ titular 
				+ ", saldo: "
				+ saldo 
				+ ", limiteDeSaque: "
				+ limiteDeSaque;
	}
	
}
