package com.idprogramming.springboot.app.productos.service;
import java.util.List;

import com.idprogramming.springboot.app.productos.entity.Producto;

public interface ProductoService {

    public List<Producto> findAll();    
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);

}
