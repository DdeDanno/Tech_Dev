package mx.uam.ayd.proyecto.presentacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.proyecto.presentacion.modificarDiseño.VentanaModificarDiseño;

class VentanaModificarDiseñoTest {
    
    private VentanaModificarDiseño modificarDiseño; //clase a probar

    @BeforeEach
    void preparaTest(){
        modificarDiseño = new VentanaModificarDiseño();
    }

    /** 
    *Objetivo: corroborar que el método leeImagene funcione
    *en este caso, que obtenga la cantidad de imagenes que hay en la carpeta 
    *
    **/

    @Test
    void testLeeImagene(){
        int cantidadImagenes = modificarDiseño.cuentaImagenes();

        assertEquals(3, cantidadImagenes, "No es la cantidad de imagenes deseada");
    }

}
