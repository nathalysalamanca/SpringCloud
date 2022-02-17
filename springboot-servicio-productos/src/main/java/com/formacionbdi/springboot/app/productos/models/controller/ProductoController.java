package com.formacionbdi.springboot.app.productos.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService service;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return service.findAll();
	}
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return service.findById(id);
	}
}
