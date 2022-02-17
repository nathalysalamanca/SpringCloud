package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

@Service("serviceFeing")//para ser usado en el qualifier
@Primary //se usa esta anotacion para definir el servicio que inyecta al controller - Rest template o feing 

public class ItemServiceFeing implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeing;
	
	@Override
	public List<Item> findAll() {
		return clienteFeing.listar().stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		return new Item(clienteFeing.detalle(id), cantidad);
	}

}
