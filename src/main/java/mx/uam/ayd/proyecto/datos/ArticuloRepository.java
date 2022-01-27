package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Articulo;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {

    // public Articulo findByNombreArticulo(String NombreArticulo);

}
