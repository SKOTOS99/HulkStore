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
@Table(name = "usuario")
public class UsuariosEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String nombre;
	
	@Column(name = "apellido_paterno")
	private String apellido_paterno;
	
	@Column(name = "apellido_materno")
	private String apellido_materno;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "usuario")
	private String usuario;
	
	public UsuariosEntity() {}

	public UsuariosEntity(String nombre, String apellido_paterno, String apellido_materno, int edad,
			String usuario) {
		super();
		
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.edad = edad;
		this.usuario = usuario;
	}
	
	
	
}
