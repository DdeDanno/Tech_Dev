package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

public interface ProductoRepository extends CrudRepository <Producto,Long>{
}
