package com.store.sysiems.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.sysiems.request.CarritoRequest;
import com.store.sysiems.services.CarritoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CarritoController {
	
	@Autowired
	public CarritoService carritoSer;
	
	@GetMapping("/carrito/{id}")
	@ApiOperation(value = "obtener productos del carrito")
	public Map<String,?> obtener_producto(@PathVariable Long id){
		return carritoSer.obtener_carrito(id);
	}
	
	@PostMapping("/carrito")
	@ApiOperation(value = "agregar productos al carrito")
	public Map<String,?> agregar_producto(@RequestBody CarritoRequest carrito){
		return carritoSer.agregar_pruducto(carrito);
	}

}
