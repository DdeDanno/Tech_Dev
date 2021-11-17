package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Producto {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_producto;
    private String tipo_producto;
    private String categoria;
    private String nombre_diseño;
    private String material;
    private String tamaño;
    private float precio;

}
