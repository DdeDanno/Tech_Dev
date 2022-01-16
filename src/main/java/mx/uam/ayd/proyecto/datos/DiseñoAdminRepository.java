package mx.uam.ayd.proyecto.datos;
import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.DiseñoAdmin;

public interface DiseñoAdminRepository extends CrudRepository <DiseñoAdmin,Long>{
    
}
