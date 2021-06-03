package com.Prueba.prueba.domain;

import java.math.BigDecimal;
import java.util.Date;


public class inputCliente {

	private Integer id;
	private String email;
	private String fechavenc;
	private String idcliente;
	private String identificadordeuda;
	private String nombrecliente;
	private BigDecimal saldo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechavenc() {
		return fechavenc;
	}
	public void setFechavenc(String fechavenc) {
		this.fechavenc = fechavenc;
	}
	public String getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}
	public String getIdentificadordeuda() {
		return identificadordeuda;
	}
	public void setIdentificadordeuda(String identificadordeuda) {
		this.identificadordeuda = identificadordeuda;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
}
