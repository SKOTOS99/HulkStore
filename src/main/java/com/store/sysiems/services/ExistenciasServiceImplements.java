package com.store.sysiems.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.sysiems.dao.ExistenciasDao;

@Service
public class ExistenciasServiceImplements implements ExistenciasService{
	
	@Autowired
	public ExistenciasDao existDao;

	@Override
	public Map<String, ?> obtener_cifras(String producto) {
		// TODO Auto-generated method stub
		Map<String,Object> objMap = new HashMap<String, Object>();
		
		int valor = existDao.contrar_mercacnia(producto);
		
		
		objMap.put("Resultado", "OK");
		objMap.put("Producto",producto);
		objMap.put("valor",valor);
		
		
		return objMap;
	}

}
