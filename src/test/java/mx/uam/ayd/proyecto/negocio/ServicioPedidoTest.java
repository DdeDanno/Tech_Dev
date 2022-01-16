package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

@ExtendWith(MockitoExtension.class)
class ServicioPedidoTest {
    @Mock
    private PedidoRepository pedidoRepository;
    @InjectMocks
    private ServicioPedido servicioPedido;

    @BeforeEach
    void setUp() throws Exception{
    }
    @AfterEach
	void tearDown() throws Exception {
	}

    @Test
    void ActualizarEstatusDisTest(){
        //Pedido 1
        Pedido pedido1=new Pedido();
        pedido1.setFolio("1111111");
        pedido1.setEstatus_pago(true);
        pedido1.setEstatus_diseño(false);
        pedido1.setEstatus_imprimiendo(false);
        pedido1.setEstatus_enviado(false);
        
        pedidoRepository.save(pedido1);

        //Pedido 2
        Pedido pedido2=new Pedido();
        pedido2.setFolio("2222222");
        pedido2.setEstatus_pago(true);
        pedido2.setEstatus_diseño(true);
        pedido2.setEstatus_imprimiendo(false);
        pedido2.setEstatus_enviado(false);
        
        pedidoRepository.save(pedido2);

        //El diseñador seleccionaria lo siguiente en el comboBox
        String estatus1="Completado";
        String estatus2="En curso";
        //Prueba que se seleccionan bien en cada caso del estatus
        if (estatus1=="Completado"){
        pedido1.setEstatus_diseño(true);
        assertTrue(pedido1.isEstatus_diseño());    
        }
        else
        pedido1.setEstatus_diseño(false); 

        if (estatus2=="Completado")
        pedido2.setEstatus_diseño(true);
        else{
        pedido2.setEstatus_diseño(false);
        assertFalse(pedido2.isEstatus_diseño());
    } 
    }

    @Test
    void ActualizarEstatusImpTest(){
        //Pedido 1
        Pedido pedido1=new Pedido();
        pedido1.setFolio("1111111");
        pedido1.setEstatus_pago(true);
        pedido1.setEstatus_diseño(true);
        pedido1.setEstatus_imprimiendo(false);
        pedido1.setEstatus_enviado(false);
        
        pedidoRepository.save(pedido1);

        //Pedido 2
        Pedido pedido2=new Pedido();
        pedido2.setFolio("2222222");
        pedido2.setEstatus_pago(true);
        pedido2.setEstatus_diseño(true);
        pedido2.setEstatus_imprimiendo(true);
        pedido2.setEstatus_enviado(false);
        
        pedidoRepository.save(pedido2);
        //El diseñador seleccionaria lo siguiente en el comboBox
        String estatus1="Completado";
        String estatus2="En curso";
        //Prueba que se seleccionan bien en cada caso del estatus
        if (estatus1=="Completado"){
        pedido1.setEstatus_imprimiendo(true);
        assertTrue(pedido1.isEstatus_imprimiendo());    
        }
        else
        pedido1.setEstatus_diseño(false); 

        if (estatus2=="Completado")
        pedido2.setEstatus_diseño(true);
        else{
        pedido2.setEstatus_imprimiendo(false);;
        assertFalse(pedido2.isEstatus_imprimiendo());
            } 
    }
}
