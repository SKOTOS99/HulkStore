package com.store.sysiems.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "carrito")
public class CarritoEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", referencedColumnName = "id")
	//@Column(name="usuario_id")
	private ProductoEntity id_producto;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	//@Column(name="usuario_id")
	private UsuariosEntity id_usurio;
	
	@Column(name="fecha")
	private Timestamp fecha;
	
	public CarritoEntity() {}

	public CarritoEntity(ProductoEntity id_producto, UsuariosEntity id_usurio, Timestamp fecha) {
		super();
		this.id_producto = id_producto;
		this.id_usurio = id_usurio;
		this.fecha = fecha;
	}

	
	
	
	
}
