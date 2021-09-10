package com.store.sysiems.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.store.sysiems.entity.UsuariosEntity;



public interface UsuarioDao extends CrudRepository<UsuariosEntity, Long>{
	
	@Query(value = "Select * from usuario where usuario=?1")
	public UsuariosEntity findByUsername(String username);

}
