package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

@Service
public class ServicioPedido {
    @Autowired
    PedidoRepository pedidoRepository;

    //Conseguimos el Folio correspondiente
    public String numFolio (int i){
    Pedido pedido=null;
    for(Pedido element:pedidoRepository.findAll()){
        if (element.getId_pedido()==i){
        pedido = element;
        }
    }
    String Folio=pedido.getFolio();
    return Folio;
    }

    //Conseguimos el Estatus del pago
    public boolean pago (int i){
        Pedido pedido=null;
        for(Pedido element:pedidoRepository.findAll()){
            if (element.getId_pedido()==i){
            pedido = element;
            }
        }
        return pedido.isEstatus_pago();
    }
    //Conseguimos el Estatus del diseño
    public boolean diseño (int i){ 
        Pedido pedido=null;
        for(Pedido element:pedidoRepository.findAll()){
            if (element.getId_pedido()==i){
            pedido = element;
            }
        }
        return pedido.isEstatus_diseño();
    }
    //Conseguimos el Estatus de Impresion
    public boolean imprimiendo (int i){
        Pedido pedido=null;
        for(Pedido element:pedidoRepository.findAll()){
            if (element.getId_pedido()==i){
            pedido = element;
            }
        }
        return pedido.isEstatus_imprimiendo();
    }
    //Conseguimos el Estatus del envio
    public boolean envio (int i){
        Pedido pedido=null;
        for(Pedido element:pedidoRepository.findAll()){
            if (element.getId_pedido()==i){
            pedido = element;
            }
        }
        return pedido.isEstatus_enviado();
    } 
    
    //Actualizar el Estatus del diseño
    public void actualizarDis(String estatus, int i){
        Pedido pedido=null;
        for(Pedido element:pedidoRepository.findAll()){
            if (element.getId_pedido()==i){
            pedido = element;
            }
        }
        if (estatus=="Completado")
        pedido.setEstatus_diseño(true);
        else
        pedido.setEstatus_diseño(false);

        pedidoRepository.save(pedido);
    }

        //Actualizar el Estatus de la impresion
        public void actualizarImp(String estatus, int i){
            Pedido pedido=null;
            for(Pedido element:pedidoRepository.findAll()){
                if (element.getId_pedido()==i){
                pedido = element;
                }
            }
            if (estatus=="Completado")
            pedido.setEstatus_imprimiendo(true);
            else
            pedido.setEstatus_imprimiendo(false); 

            pedidoRepository.save(pedido);
        }
}