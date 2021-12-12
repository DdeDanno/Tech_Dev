package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pedido;
    private String folio;
    private boolean estatus_pago;
    private boolean estatus_diseño;
    private boolean estatus_imprimiendo;
    private boolean estatus_enviado;
}
