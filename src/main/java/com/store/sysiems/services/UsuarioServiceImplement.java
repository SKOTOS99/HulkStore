package com.store.sysiems.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.sysiems.dao.UsuarioDao;
import com.store.sysiems.entity.UsuariosEntity;
import com.store.sysiems.request.UsuarioRequest;


@Service
public class UsuarioServiceImplement implements UsuarioService{
	
	@Autowired
	public UsuarioDao usrDao;

	@Override
	public Map<String, ?> agregar_usuario(UsuarioRequest usuario_req) {
		// TODO Auto-generated method stub
		
		Map<String,Object> objMap = new HashMap<String, Object>();
		
		UsuariosEntity usuario = new UsuariosEntity(usuario_req.getNombre(),usuario_req.getApellido_paterno(),usuario_req.getApellido_materno(),usuario_req.getEdad(),usuario_req.getUsuario());
		usrDao.save(usuario);
		objMap.put("Resultado", "OK");
		objMap.put("Codigo", "00");
		
		
		return objMap;
	}

	@Override
	public Map<String, ?> obtener_usuarios() {
		// TODO Auto-generated method stub
		
		Map<String,Object> objMap = new HashMap<String, Object>();
		
		List<UsuariosEntity> usuarios = (List<UsuariosEntity>) usrDao.findAll();
		if(usuarios.size()!=0) {
			objMap.put("Resultado", "OK");
			objMap.put("Data", usuarios);
			objMap.put("Codigo","00");
		}else {
			objMap.put("Resultado","No hay usuarios que mostrar");
		}
		return objMap;
	}

	@Override
	public Map<String, ?> actualizar_usuario(UsuarioRequest usuario_req) {
		
		Map<String,Object> objMap = new HashMap<String, Object>();
		
		UsuariosEntity usuario = usrDao.findById(usuario_req.getId()).orElse(null);
		if(usuario!=null) {
			usuario.setNombre(usuario_req.getNombre());
			usuario.setApellido_paterno(usuario_req.getApellido_paterno());
			usuario.setApellido_materno(usuario_req.getApellido_materno());
			usuario.setEdad(usuario_req.getEdad());
			usuario.setUsuario(usuario_req.getUsuario());
			usrDao.save(usuario);
			objMap.put("Resultado", "OK");
			objMap.put("Codigo","00");
		}else {
			objMap.put("Resultado", "No existe el usuairo a modificar");
		}
		
		return objMap;
	}

	@Override
	public Map<String, ?> eliminar_usuario(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object> objMap = new HashMap<String, Object>();
		UsuariosEntity usuario = usrDao.findById(id).orElse(null);
		if(usuario !=null) {
			usrDao.deleteById(id);
			objMap.put("Resultado", "OK");
			objMap.put("Codigo","00");
		}else {
			objMap.put("Resultado", "No existe el usuario a eliminar");
		}
	
		return objMap;
	}

	@Override
	public Map<String, ?> buscar_por_username(String username) {
		// TODO Auto-generated method stub
		Map<String,Object> objMap = new HashMap<String, Object>();
		UsuariosEntity usuario = usrDao.findByUsername(username);
		if(usuario !=null) {
			objMap.put("Resultado", "OK");
			objMap.put("Data", usuario);
			objMap.put("Codigo","00");
		}else {
			objMap.put("Resultado","No existe el usuario");
		}
		
		return objMap;
	}

	@Override
	public Map<String, ?> buscar_por_id(Long id) {
		Map<String,Object> objMap = new HashMap<String, Object>();
		UsuariosEntity usuario = usrDao.findById(id).orElse(null);
		if(usuario!=null) {
		objMap.put("Resultado", "OK");
		objMap.put("Data", usuario);
		objMap.put("Codigo","00");
		}else {
			objMap.put("Resultado","No existe el usuario");
		}
		
		// TODO Auto-generated method stub
		return objMap;
	}
	
	
	
	
	
	
	

}
