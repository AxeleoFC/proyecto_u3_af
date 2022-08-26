package com.uce.edu.demo.tarea31.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto_deber31")
public class Producto {
	
	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produ_id_seq")
	@SequenceGenerator(name = "produ_id_seq", sequenceName = "produ_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@Column(name = "prod_invetario")
	private Integer invetario;
	
	@OneToMany(mappedBy = "producto",fetch = FetchType.LAZY)
	private List<Detalle> detalles;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", invetario=" + invetario
				+ ", detalles=" + detalles + "]";
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Integer getInvetario() {
		return invetario;
	}

	public void setInvetario(Integer invetario) {
		this.invetario = invetario;
	}

}
