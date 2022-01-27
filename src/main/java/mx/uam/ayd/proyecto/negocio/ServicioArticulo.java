package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ArticuloRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Articulo;

@Slf4j
@Service
public class ServicioArticulo {

    @Autowired
    private ArticuloRepository articuloRepository;

    public Articulo CrearArticulo(String NombreArticulo, String TotalPiezas) {

        Articulo articulo = new Articulo();

        int piezas = Integer.parseInt(TotalPiezas);
        articulo.setNombreArticulo(NombreArticulo);
        articulo.setTotalPiezas(piezas);

        articuloRepository.save(articulo);

        System.out.println("nombre del articulo: " + articulo.getNombreArticulo() + "   " + "Piezas: "
                + articulo.getTotalPiezas());

        /*
         * List<Articulo> articulos = recuperaArticulos();
         * Articulo Resultado = articulos.get(0);
         * Articulo Resultado2 = articulos.get(1); //quitar esta línea
         * System.out.println(Resultado);
         * if (Resultado == Resultado2) {
         * throw new IllegalArgumentException("Este articulo ya existe");
         * 
         * }
         */
        return articulo;
    }

    public Articulo BorraArticulo(String NombreArticulo) {
        Articulo articulo = new Articulo();
        // List<Articulo> articulos = recuperaArticulos();
        if (articulo.getNombreArticulo() == NombreArticulo) {
            articuloRepository.delete(articulo);

        } else {
            // throw new IllegalArgumentException("Este articulo no existe");
        }
        System.out.println("nombre del articulo: " + articulo.getNombreArticulo() + "   " + "Piezas: "
                + articulo.getTotalPiezas());

        return articulo;
    }

    public Articulo ActualizaArticulo(String NombreArticulo, String TotalPiezas) {
        Articulo articulo = new Articulo();
        int piezas = Integer.parseInt(TotalPiezas);
        articulo.setNombreArticulo(NombreArticulo);
        articulo.setTotalPiezas(piezas);
        if (articulo.getNombreArticulo() == NombreArticulo) {
            articuloRepository.save(articulo);

        } else {
            throw new IllegalArgumentException("Este articulo ya existe");
        }
        System.out.println("nombre del articulo: " + articulo.getNombreArticulo() + "   " + "Piezas: "
                + articulo.getTotalPiezas());
        return articulo;
    }

    public List<Articulo> recuperaArticulos() {

        List<Articulo> articulos = new ArrayList<>();

        for (Articulo articulo : articuloRepository.findAll()) {
            articulos.add(articulo);
        }

        return articulos;
    }

}
