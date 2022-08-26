package com.uce.edu.demo.tarea31.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "factura_electronica_deber31")
public class FacturaElectronica {
	
	@Id
	@Column(name = "factE_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factuE_id_seq")
	@SequenceGenerator(name = "factuE_id_seq", sequenceName = "factuE_id_seq", allocationSize = 1)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="factuE_id_fact")
	private Factura facturaOriginal;
	
	@Column(name = "factE_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "factE_monto")
	private BigDecimal monto;
	
	@OneToMany(mappedBy = "facturaE",fetch = FetchType.LAZY)
	private List<Detalle> detalles;

	@Override
	public String toString() {
		return "FacturaElectronica [id=" + id + ", facturaOriginal=" + facturaOriginal + ", fecha=" + fecha + ", monto="
				+ monto + ", detalles=" + detalles + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Factura getFacturaOriginal() {
		return facturaOriginal;
	}

	public void setFacturaOriginal(Factura facturaOriginal) {
		this.facturaOriginal = facturaOriginal;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

}
