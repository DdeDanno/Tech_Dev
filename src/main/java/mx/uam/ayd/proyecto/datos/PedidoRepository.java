package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

public interface PedidoRepository extends CrudRepository <Pedido,Long>{
}
