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
    public Cliente actualizarNombre(String nombre, String apellido){
        //Inicializamos al cliente
        Cliente cliente=null;
         //Buscamos al cliente en la base de datos
         for(Cliente element:clienteRepository.findAll()){
            cliente = element;
    }
        //Verificamos que el nombre y apellido sean validos
        if (nombre.length()<4){
            throw new IllegalArgumentException("El nombre es demasiado corto \n ingrese un nombre valido");
        }
        if (apellido.length()<4){
            throw new IllegalArgumentException("El apellido es demasiado corto \n ingrese un apellido valido");
        }

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        clienteRepository.save(cliente);
        return cliente;
    }

    //Verificamos para guardar los datos del correo
    public void actualizarCorreo(String nombre,String correo){
        //Inicializamos al cliente
        Cliente cliente=null;
         //Buscamos al cliente en la base de datos
        for(Cliente element:clienteRepository.findAll()){
            if (element.getNombre()==nombre)
             cliente = element;
        }
        String [] correoSolo=correo.split("@");
        String correoSolo1=correoSolo[0];
   
        int tam=correoSolo1.length();
        char caracteres[]=correoSolo1.toCharArray();
        //Verificamos que la primera parte del correo no contenga @
        for (int i=0;i<tam;i++){
            if (caracteres[i]== '@')
            System.out.println("No debe contener @");
        }

        cliente.setCorreo(correo);
        clienteRepository.save(cliente);
    }

    public void actualizarTelefono(String nombre, String telefono){
        //Inicializamos al cliente
        Cliente cliente=null;
        //Buscamos al cliente en la base de datos
        for(Cliente element:clienteRepository.findAll()){
            if (element.getNombre()==nombre)
            cliente = element;
        }
        cliente.setTelefono(telefono);
        clienteRepository.save(cliente);
    }
   
}
