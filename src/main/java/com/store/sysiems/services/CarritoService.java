package com.store.sysiems.services;

import java.util.Map;

import com.store.sysiems.request.CarritoRequest;

public interface CarritoService {
	
	public Map<String,?> agregar_pruducto(CarritoRequest carrito);
	public Map<String,?> obtener_carrito(Long id);
}
