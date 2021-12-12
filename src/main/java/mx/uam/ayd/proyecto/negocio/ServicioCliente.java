package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

@Service
public class ServicioCliente {
    @Autowired
    private ClienteRepository clienteRepository;

    //Conseguimos el nombre del cliente
    public String nombreCliente (){
        Cliente cliente=null;
       for(Cliente element:clienteRepository.findAll()){
            cliente = element;
    }
        String nombre_cliente=cliente.getNombre()+"!";
        return nombre_cliente;
    }

       //Conseguimos el numero de pedidos
       public int numPedidos (){
        Cliente cliente=null;
        for(Cliente element:clienteRepository.findAll()){
            cliente = element;
        }
        int num=cliente.getNum_pedidos();
        return num;
        }
}
