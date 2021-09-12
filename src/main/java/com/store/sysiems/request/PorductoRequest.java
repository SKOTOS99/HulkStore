package com.store.sysiems.request;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class PorductoRequest {

	
	
	public Long id;
	public String nombre;
	public String tipo_producto;
	public int costo;
	
}
