package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

@ExtendWith(MockitoExtension.class)

public class ServicioClienteTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ServicioCliente servicio;
    
    @BeforeEach
	void setUp() throws Exception {
        LinkedList <Cliente> lista=new LinkedList<>();
        //Creamos al cliente
        Cliente cliente=new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellido("Hernandez Sanchez");
        cliente.setCorreo("CarlosHS@hotmail.com");
        cliente.setTelefono("5519895131");
        cliente.setNum_pedidos(5);
        clienteRepository.save(cliente);

        lista.add(cliente);
        when(clienteRepository.findAll()).thenReturn(lista);
	}

    @Test
    void actualizarNombre() throws Exception{
        //Probamos que se actualiza el nombre de manera satisfactoria
        Cliente cliente= servicio.actualizarDatos("Carlos", "Hernandez Perez","CarlosHS","@hotmail.com","5519895131");
        assertNotNull(cliente);
        //Probamos que no se puede actualizar un nombre de longitud menor que 4
        Exception error = Assertions.assertThrows(Exception.class, () -> {
        servicio.actualizarDatos("h", "Hernandez Perez","CarlosHS","@hotmail.com","5519895131");
        });
        System.out.println("error1"+error);
        //Probamos que no se puede actualizar un apellido de longitud menor que 4
        Exception error2 = Assertions.assertThrows(Exception.class, () -> {
            servicio.actualizarDatos("Daniel", "H","CarlosHS","@hotmail.com","5519895131");
            });
            System.out.println("error2"+error2);
        }

        @Test
        void actualizarCorreo() throws Exception{
        //Probamos que se actualiza el correo de manera satisfactoria
        Cliente cliente=servicio.actualizarDatos("Carlos", "Hernandez Perez","Carlos_123","@gmail.com","5519895131");
        assertNotNull(cliente);
        //Probamos que no se puede agregar @ en la primera parte del correo
        Exception error = Assertions.assertThrows(Exception.class, () -> {
            servicio.actualizarDatos("Carlos", "Hernandez Perez","Carlos_@HS","@hotmail.com","5519895131");
            });
            System.out.println(error);
        }

        @Test
        void actualizarTelefono() throws Exception{
        //Probamos que se actualiza el numero de manera satisfactoria
        Cliente cliente=servicio.actualizarDatos("Carlos", "Hernandez Perez","Carlos_123","@gmail.com","5591861879");
        assertNotNull(cliente);
        //Probamos que no podemos agregar un numero mayor que 10
        Exception error = Assertions.assertThrows(Exception.class, () -> {
            servicio.actualizarDatos("Carlos", "Hernandez Perez","Carlos_HS","@hotmail.com","55198951311");
            });
            System.out.println(error);
        //Probamos que no podemos agregar un numero menor que 10
        Exception error2 = Assertions.assertThrows(Exception.class, () -> {
            servicio.actualizarDatos("Carlos", "Hernandez Perez","Carlos_HS","@hotmail.com","1");
            });
            System.out.println(error2);
        }
    }
