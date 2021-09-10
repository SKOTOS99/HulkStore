package com.store.sysiems.request;



import lombok.Data;



@Data
public class UsuarioRequest {
	
	
	private Long id;
	
	private String nombre;
	
	private String apellido_paterno;
	
	private String apellido_materno;
	
	private int edad;
	
	private String usuario;

}
