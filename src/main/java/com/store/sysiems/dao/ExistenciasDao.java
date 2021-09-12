package com.store.sysiems.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.store.sysiems.entity.Existencias;


public interface ExistenciasDao extends CrudRepository<Existencias, Long>{
	
	
	@Query(value="select count(*) from producto_existente where nombre = ?1",nativeQuery=true)
	public int contrar_mercacnia(String producto);

}
