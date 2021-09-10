package com.store.sysiems.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.sysiems.request.UsuarioRequest;
import com.store.sysiems.services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UsuariosControllers {
	
	@Autowired
	public UsuarioService usrServ;
	
	@GetMapping("/usuarios")
	@ApiOperation(value = "Lista de usuarios")
	public Map<String,?> obtener_usuarios(){
		return usrServ.obtener_usuarios();
	}
	
	@PostMapping("/usuarios")
	@ApiOperation(value = "agregar usuairos")
	public Map<String,?> agregar_usuario(@RequestBody UsuarioRequest usr){
		return usrServ.agregar_usuario(usr);
	}
	
	@PutMapping("/usuario/{id}")
	@ApiOperation(value = "Actualiza registro de usuario")
	public Map<String,?> actualizar_usuario(@RequestBody UsuarioRequest usr){
		return usrServ.actualizar_usuario(usr);
	}
	
	@DeleteMapping("/usuario/{id}")
	@ApiOperation(value="borrar usuario por id")
	public Map<String,?> eliminar_usuario(@PathVariable Long id){
		return usrServ.eliminar_usuario(id);
	}
	
	@GetMapping("/usuarios/{id}")
	@ApiOperation(value = "Lista de usuario por id")
	public Map<String,?> obtener_usuario_id(@PathVariable Long id){
		return usrServ.buscar_por_id(id);
	}
	
	@GetMapping("/usuarios/{username}")
	@ApiOperation(value = "Lista de usuario por username")
	public Map<String,?> obtener_usuario_username(@PathVariable String username){
		return usrServ.buscar_por_username(username);
	}
	
	
	

}
