package com.store.sysiems.services;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.sysiems.dao.CarritoDao;
import com.store.sysiems.dao.ProductoDao;
import com.store.sysiems.dao.UsuarioDao;
import com.store.sysiems.entity.CarritoEntity;
import com.store.sysiems.entity.ProductoEntity;
import com.store.sysiems.entity.UsuariosEntity;
import com.store.sysiems.request.CarritoRequest;

@Service
public class CarritoServiceImplement implements CarritoService{

	@Autowired
	public CarritoDao carritoDao;
	
	@Autowired
	public ProductoDao productDao;
	
	@Autowired
	public UsuarioDao usrDao;
	
	@Override
	public Map<String, ?> agregar_pruducto(CarritoRequest carrito) {
		
		Map<String,Object> objMap = new HashMap<String, Object>();
		
		ProductoEntity producto = productDao.findById(carrito.getId_producto()).orElse(null);
		UsuariosEntity usuario = usrDao.findById(carrito.getId_usuario()).orElse(null);
		Timestamp creado = new Timestamp(System.currentTimeMillis());
		CarritoEntity carritoEntity = new CarritoEntity(producto, usuario, creado);
		carritoDao.save(carritoEntity);
		objMap.put("Resultado", "OK");
		objMap.put("producto", carritoEntity);
		
		// TODO Auto-generated method stub
		return objMap;
	}

	@Override
	public Map<String, ?> obtener_carrito(Long id) {
		
		Map<String,Object> objMap = new HashMap<String, Object>();
		CarritoEntity carrito = carritoDao.obtener_carrito(id);
		if(carrito!=null) {
			objMap.put("Resultado", "OK");
			objMap.put("producto", carrito);
		}else {
			objMap.put("Resultado", "No existen productos agregados al carrito");
		
		}
		// TODO Auto-generated method stub
		return objMap;
	}
	
	

}
