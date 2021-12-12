package mx.uam.ayd.proyecto.negocio.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;
    private String nombre;
    private String correo;
    private String telefono;
    private int num_pedidos;

}
