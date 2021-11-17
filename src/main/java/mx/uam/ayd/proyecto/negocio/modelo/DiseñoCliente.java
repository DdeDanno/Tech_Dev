package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import lombok.Data;

@Entity
@Data
public class DiseñoCliente {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_cliente;
    private String nombreCliente;
    private String rutaArchivo;

}
