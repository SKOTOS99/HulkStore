package com.store.sysiems.services;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.sysiems.dao.ExistenciasDao;
import com.store.sysiems.dao.ProductoDao;
import com.store.sysiems.entity.Existencias;
import com.store.sysiems.entity.ProductoEntity;
import com.store.sysiems.request.PorductoRequest;
import com.store.sysiems.request.UsuarioRequest;

@Service
public class ProductoServiceImplements  implements ProductoService{

	@Autowired
	public ProductoDao productoDao;
	
	@Autowired
	public ExistenciasDao existencias;
	
	@Override
	public Map<String, ?> obtener_producto() {
		Map<String,Object> objMap = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		List<ProductoEntity> productos = (List<ProductoEntity>) productoDao.findAll(); 

		if(productos.size()!=0) {
			objMap.put("Resultado","OK");
			objMap.put("Data", productos);
			objMap.put("Code", "00");
		}else {
			objMap.put("Resultado","No hay productos en inventario");
		}
		return objMap;
	}

	@Override
	public Map<String, ?> agregar_producto(PorductoRequest producto) {
		// TODO Auto-generated method stub
		Timestamp creado = new Timestamp(System.currentTimeMillis());
		Map<String,Object> objMap = new HashMap<String, Object>();
		ProductoEntity pro = new ProductoEntity(producto.getNombre(),producto.getTipo_producto(),producto.getCosto(),creado);
		
		productoDao.save(pro);
		
		//aqui se actualiza el numero de productos existentes
		Existencias existEntity = new Existencias(producto.getTipo_producto());
		existencias.save(existEntity);
		objMap.put("Resultado","OK");
	
		objMap.put("Code", "00");
		
		return objMap;
	}

	@Override
	public Map<String, ?> actualizar_producto(PorductoRequest producto) {
		Map<String,Object> objMap = new HashMap<String, Object>();
		ProductoEntity produc = productoDao.findById(producto.getId()).orElse(null);
		if(produc!=null) {
			produc.setNombre(producto.getNombre());
			produc.setTipo_producto(producto.tipo_producto);
			produc.setCosto(producto.getCosto());
			productoDao.save(produc);
			objMap.put("Resultado","OK");
			
			objMap.put("Code", "00");
		}else {
			objMap.put("Resultado","No existe el producto a modificar");
		}
		
		
		return objMap;
	}

	@Override
	public Map<String, ?> eliminar_producto(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object> objMap = new HashMap<String, Object>();
		ProductoEntity prod = productoDao.findById(id).orElse(null);
		if(prod!=null) {
			productoDao.deleteById(id);
			objMap.put("Resultado","OK");
			
			objMap.put("Code", "00");
		}else {
			objMap.put("Resultado","No existe el producto a eliminar");
			
			
		}
		
		
		return objMap;
	}

	@Override
	public Map<String, ?> buscar_producto_por_id(Long id) {
		Map<String,Object> objMap = new HashMap<String, Object>();
		ProductoEntity prod = productoDao.findById(id).orElse(null);
		if(prod!=null) {
			
			objMap.put("Resultado","OK");
			objMap.put("Data",prod);
			
			objMap.put("Code", "00");
		}else {
			objMap.put("Resultado","No existe el producto");
			
			
		}
		
		return objMap;
	}

	

}
