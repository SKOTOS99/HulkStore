package com.store.sysiems.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.store.sysiems.entity.UsuariosEntity;



public interface UsuarioDao extends CrudRepository<UsuariosEntity, Long>{
	
	@Query(value = "Select * from usuario where usuario=?1", nativeQuery=true)
	public UsuariosEntity findByUsername(String username);

}
