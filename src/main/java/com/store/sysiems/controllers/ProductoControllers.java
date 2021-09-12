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

import com.store.sysiems.request.PorductoRequest;
import com.store.sysiems.services.ExistenciasService;
import com.store.sysiems.services.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductoControllers {
	
	@Autowired
	public ProductoService prodServ;
	
	@Autowired 
	public ExistenciasService existServ;
	
	@GetMapping("/productos")
	@ApiOperation(value = "Lista de productos")
	public Map<String,?> obtener_productos(){
		return prodServ.obtener_producto();
	}
	
	@PostMapping("/productos")
	@ApiOperation(value = "agregar producto")
	public Map<String,?> agregar_productos(@RequestBody PorductoRequest usr){
		return prodServ.agregar_producto(usr);
	}

	@PutMapping("/productos")
	@ApiOperation(value = "Actualiza registro de producto")
	public Map<String,?> actualizar_productos(@RequestBody PorductoRequest usr){
		return prodServ.actualizar_producto(usr);
	}
	
	@DeleteMapping("/productos/{id}")
	@ApiOperation(value="borrar producto por id")
	public Map<String,?> eliminar_usuario(@PathVariable Long id){
		return prodServ.eliminar_producto(id);
	}
	
	@GetMapping("/producto/{id}")
	@ApiOperation(value = "Lista de productos por id")
	public Map<String,?> obtener_usuario_id(@PathVariable Long id){
		return prodServ.buscar_producto_por_id(id);
	}
	
	
	@GetMapping("/contarPorducto/{nombre}")
	@ApiOperation(value = "cuenta el producto")
	public Map<String,?> obtener_cantidad_producto(@PathVariable String nombre){
		return existServ.obtener_cifras(nombre);
	}
	
	
	

}
