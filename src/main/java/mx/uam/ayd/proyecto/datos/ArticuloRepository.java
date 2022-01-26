package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Articulo;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {

    // public List<Articulo> getAll(); // recupera todos los articulos y los pone en
    // una lista

    // public Articulo findByName(String nombre);
    // public Articulo findByNaArticulo(String NombreArticulo);

}
