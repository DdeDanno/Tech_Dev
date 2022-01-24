package mx.uam.ayd.proyecto.presentacion.actualizarInformación;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;

@Component
public class controlActualizarInformacion {
    @Autowired
    private ventanaActualizarInformacion ventana;
    @Autowired
    private ServicioCliente servicioCliente;

    public void inicia (){
        ventana.muestra(this);
    }
    //Metodos para obtener los datos
    public String obtenerNombre(){
        return servicioCliente.nombreCliente();
    }
    public String obtenerApellido(){
        return servicioCliente.apellidoCliente();
    }
    public String obtenerCorreopart1(){
        String correo=servicioCliente.correoCliente();
        String [] correoSolo=correo.split("@");
        String correoSolo1=correoSolo[0];
        return correoSolo1;
    }
    public String obtenerCorreopart2(){
        String correo=servicioCliente.correoCliente();
        String [] correoSolo=correo.split("@");
        String correoSolo2=correoSolo[1];
        return correoSolo2;
    }
    public String obtenerTelefono(){
        return servicioCliente.telefonoCliente();
    }
    //Metodos para actualizar los datos
    public void actualizarNombre(String nombre, String apellido){
        try{
            servicioCliente.actualizarNombre(nombre,apellido);
        }
        catch(Exception exception){
        ventana.muestraDialogoConMensaje(exception.getMessage());
        }
        
        termina();
    }

    public void actualizarCorreo(String nombre, String correo){
        servicioCliente.actualizarCorreo(nombre, correo);
    }

    public void actualizarTelefono(String nombre, String telefono){
        servicioCliente.actualizarTelefono(nombre, telefono);
    }

    public void termina() {
		ventana.setVisible(false);
	}
}
