package com.store.sysiems.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.store.sysiems.entity.CarritoEntity;

public interface CarritoDao extends CrudRepository<CarritoEntity, Long>{
	
	
	@Query(value="select * from carrito where id_usuario = ?1",nativeQuery=true)
	public CarritoEntity obtener_carrito(Long id);

}
