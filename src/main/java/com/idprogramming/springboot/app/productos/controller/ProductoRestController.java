package com.idprogramming.springboot.app.productos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.idprogramming.springboot.app.productos.entity.Producto;

import com.idprogramming.springboot.app.productos.service.ProductoService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api")
public class ProductoRestController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
    public List<Producto> findAll(){
        return productoService.findAll();
    }
	
	@GetMapping("/productos/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
		Producto producto = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try{
        	producto = productoService.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje", "El producto con el ID: " + id + " no existe");
            response.put("error", e.getMessage() + " " + e.getMostSpecificCause());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(producto == null){
            response.put("mensaje", "El producto con el ID: " + id + " no existe");
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

}
