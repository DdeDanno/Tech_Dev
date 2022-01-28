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
        String nombre_cliente=cliente.getNombre();
        return nombre_cliente;
    }
    //Conseguimos el apellido del cliente
    public String apellidoCliente (){
        Cliente cliente=null;
       for(Cliente element:clienteRepository.findAll()){
            cliente = element;
    }
        String apellido_cliente=cliente.getApellido();
        return apellido_cliente;
    }
    //Conseguimos el correo del cliente
    public String correoCliente (){
        Cliente cliente=null;
       for(Cliente element:clienteRepository.findAll()){
            cliente = element;
    }
        String correo_cliente=cliente.getCorreo();
        return correo_cliente;
    }
    //Conseguimos el telefono del cliente
    public String telefonoCliente (){
        Cliente cliente=null;
       for(Cliente element:clienteRepository.findAll()){
            cliente = element;
    }
        String telefono_cliente=cliente.getTelefono();
        return telefono_cliente;
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
/**
 * 
 * Comienzan los metodos par actualizar los datos
 * 
 */

    //Verificamos para guardar los datos del nombre y apellido
    public Cliente actualizarDatos(String nombre, String apellido, String correo1, 
    String correo2, String telefono){
        int tam=correo1.length();
        char caracteres[]=correo1.toCharArray();
        //Inicializamos al cliente
        Cliente cliente=null;
         //Buscamos al cliente en la base de datos
         for(Cliente element:clienteRepository.findAll()){
            cliente = element;
        }
        //Verificamos que los datos no sean invalidos
        //Verificamos que el nombre no sea demasiado corto
        if (nombre.length()<4){
            throw new IllegalArgumentException("El nombre es demasiado corto ingrese un nombre valido");
        }
        //Verificamos que el apellido no sea demasiado corto
        if (apellido.length()<4){
            throw new IllegalArgumentException("El apellido es demasiado corto ingrese un apellido valido");
        }
        //Verificamos que la primera parte del correo no contenga @
        for (int i=0;i<tam;i++){
            if (caracteres[i]== '@')
            throw new IllegalArgumentException("Por favor, evite el uso de @ en su correo");
        }
        //Verificamos que el numero sea valido (10 digitos)
        if (telefono.length()!=10){
            throw new IllegalArgumentException("Por favor, ingrese un numero valido (10 digitos)");
        }
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo1+correo2);
        cliente.setTelefono(telefono);
        clienteRepository.save(cliente);
        return cliente;
    }   
}
