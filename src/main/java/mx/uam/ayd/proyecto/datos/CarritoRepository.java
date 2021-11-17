package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Carrito;

public interface CarritoRepository extends CrudRepository<Carrito,Long>{
    
}
