package mx.uam.ayd.proyecto.negocio.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carrito;
    private String tipo_producto;
    private int cantidad_producto;
    private float precio_ind;
    private float precio_tot;
}
