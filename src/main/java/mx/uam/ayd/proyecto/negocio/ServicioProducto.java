package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Service
public class ServicioProducto {
    @Autowired
    private ProductoRepository productoRepository;

    public void nuevoProducto(String categoria,String nombre_diseño,String material, float precio, String tamaño, String tipo_producto){
        Producto producto1=new Producto();
        producto1.setCategoria(categoria);
        producto1.setNombre_diseño(nombre_diseño);
        producto1.setMaterial(material);
        producto1.setPrecio(precio);
        producto1.setTamaño(tamaño);
        producto1.setTipo_producto(tipo_producto); 

        productoRepository.save(producto1);
    }
    
}
