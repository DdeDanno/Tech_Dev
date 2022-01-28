package mx.uam.ayd.proyecto.negocio;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.OfertasRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Ofertas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ServicioOfertasTest {

    @Mock
    private OfertasRepository ofertasRepository;

    // No es necesario instanciar servicioOfertas
    @InjectMocks
    private ServicioOfertas servicioOfertas;

    @BeforeEach
    void preparaPrueba(){
        //
    }//Fin del BeforeEach

    @Test
    void TestBuscarImagenes(){

        /*
        *   1. Id: Prueba uno 
        *   2. Objetivo: Probar que se puede buscar una imagen desde el ordenador
        *   3. Precondiciones: El label está vacío
        *   4. Valor esperado: Un objeto tipo ImageIcon
        */

        //Recupero el valor que me devuelve mi método BuscarImagenes
        ImageIcon imagenMetodo = servicioOfertas.BuscarImagenes();

        //Creamos una imagen sustituta
        ImageIcon imagenPrueba = new ImageIcon(imagenMetodo.toString());

        //assertEquals(imagenPrueba, imagenMetodo, "La imagen fue agregada correctamente");

    }//Fin del Test



}//Fin de la clase ServicioOfertasTest
