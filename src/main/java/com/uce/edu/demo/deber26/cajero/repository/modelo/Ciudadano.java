package com.uce.edu.demo.deber26.cajero.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Ciudadano2")
@Table(name = "ciudadano2")
public class Ciudadano {
	@Id
	@Column(name = "ciuda_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciuda_id_seq")
	@SequenceGenerator(name = "ciuda_id_seq", sequenceName = "ciuda_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "ciuda_nombre")
	private String nombre;
	
	@Column(name = "ciuda_apellido")
	private String apellido;
	
	@OneToOne(mappedBy = "ciudadano")
	private Cliente cliente;

	@Override
	public String toString() {
		return "Ciudadano [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cliente=" + cliente + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
