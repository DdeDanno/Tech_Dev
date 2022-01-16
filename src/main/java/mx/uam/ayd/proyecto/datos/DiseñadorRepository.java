package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Diseñador;

public interface DiseñadorRepository extends CrudRepository <Diseñador,Long> {
    
}
