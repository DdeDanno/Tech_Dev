package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.DiseñoCliente;

public interface DiseñoClienteRepository extends CrudRepository <DiseñoCliente,Long>{
    
}
