package com.store.sysiems.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.store.sysiems.request.UsuarioRequest;



public interface UsuarioService {
	
	public Map<String, ?> agregar_usuario(UsuarioRequest usuario_req);
	public Map<String,?> obtener_usuarios();
	public Map<String,?> actualizar_usuario(UsuarioRequest usuario_req);
	public Map<String,?> eliminar_usuario(Long id);
	public Map<String,?> buscar_por_username(String username);
	public Map<String,?> buscar_por_id(Long id);

}
