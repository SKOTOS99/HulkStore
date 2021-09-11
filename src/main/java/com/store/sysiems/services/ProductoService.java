package com.store.sysiems.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.sysiems.dao.ProductoDao;
import com.store.sysiems.request.PorductoRequest;


public interface ProductoService {

	public Map<String ,?> obtener_producto();
	public Map<String,?> agregar_producto(PorductoRequest producto);
	public Map<String, ?> actualizar_producto(PorductoRequest producto);
	public Map<String,?> eliminar_producto(Long id);
	public Map<String,?> buscar_producto_por_id(Long id);
	
}
