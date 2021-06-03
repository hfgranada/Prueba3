package com.Prueba.prueba.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the clientescartera database table.
 * 
 */
@Entity
@NamedQuery(name="Clientescartera.findAll", query="SELECT c FROM Clientescartera c")
public class Clientescartera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechavenc;

	private String idcliente;

	private String identificadordeuda;

	private String nombrecliente;

	private BigDecimal saldo;

	public Clientescartera() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechavenc() {
		return this.fechavenc;
	}

	public void setFechavenc(Date fechavenc) {
		this.fechavenc = fechavenc;
	}

	public String getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdentificadordeuda() {
		return this.identificadordeuda;
	}

	public void setIdentificadordeuda(String identificadordeuda) {
		this.identificadordeuda = identificadordeuda;
	}

	public String getNombrecliente() {
		return this.nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}