package com.store.sysiems.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class ProductoEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo_producto")
	private String tipo_producto;

	@Column(name="costo")
	private int costo;
	
	@Column(name="fecha")
	private Timestamp fecha;
	
	
	public ProductoEntity() {}


	public ProductoEntity(String nombre, String tipo_producto, int costo, Timestamp fecha) {
		super();
		this.nombre = nombre;
		this.tipo_producto = tipo_producto;
		this.costo = costo;
		this.fecha = fecha;
	}



	
	

}
