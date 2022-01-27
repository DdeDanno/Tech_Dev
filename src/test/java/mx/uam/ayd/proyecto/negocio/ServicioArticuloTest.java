package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.ArticuloRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Articulo;

@ExtendWith(MockitoExtension.class)
public class ServicioArticuloTest {

    @Mock
    private ArticuloRepository articuloRepository;

    @InjectMocks
    private ServicioArticulo servicioArticulo;

    @BeforeEach
    void preparaPrueba() {
        // System.out.println("El valor de articuloRepository es :" +
        // articuloRepository);
        // servicioArticulo = new ServicioArticulo();
    }

    @Test
    void testCrearArticulo() {
        // Prueba 1
        // Objetivo: Probar que se crea un articulo nuevo
        // Precondiciones: No existen Articulos

        Articulo articulo = new Articulo();
        articulo.setNombreArticulo("tazas");
        articulo.setTotalPiezas(12);

        // Valor Esperado: El nuevo articulo
        Articulo resultado = servicioArticulo.CrearArticulo("tazas", "12");

        assertEquals(articulo, resultado);

    }

    @Test
    void testBorraArticulo() {
        // Prueba 2
        // Objetivo: Probar borrar un articulo
        // Precondiciones: Existe un articulo

        // aqui simulamos un articulo que fue creado
        Articulo articulo = new Articulo();
        articulo.setNombreArticulo("tazas");
        articulo.setTotalPiezas(12);

        // Valor esperado: El articulo borrado
        Articulo resultado = servicioArticulo.BorraArticulo("tazas");

        // Articulo después de ser borrado
        Articulo articulo1 = new Articulo();
        articulo1.setNombreArticulo(null);
        articulo1.setTotalPiezas(0);

        assertEquals(articulo1, resultado);
    }

    @Test
    void testActualizaArticulo() {
        // Prueba 3
        // Objetivo: Probar actualizar un articulo
        // Precondiciones: Existe un articulo

        // Creamos un articulo
        Articulo articulo = new Articulo();
        articulo.setNombreArticulo("tazas");
        articulo.setTotalPiezas(12);

        // Valor esperado: El Articulo Actualizado
        Articulo resultado = servicioArticulo.ActualizaArticulo("tazas", "24");

        // Articulo después de ser actualizado
        Articulo articulo1 = new Articulo();
        articulo1.setNombreArticulo("tazas");
        articulo1.setTotalPiezas(24);

        assertEquals(articulo1, resultado);

    }

}