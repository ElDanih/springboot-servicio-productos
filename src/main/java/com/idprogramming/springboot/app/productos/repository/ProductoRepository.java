package com.idprogramming.springboot.app.productos.repository;

import org.springframework.data.repository.CrudRepository;

import com.idprogramming.springboot.app.productos.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
