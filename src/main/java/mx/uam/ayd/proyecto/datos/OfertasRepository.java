package mx.uam.ayd.proyecto.datos;
import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Ofertas;

public interface OfertasRepository extends CrudRepository <Ofertas, Long> {
    
}
