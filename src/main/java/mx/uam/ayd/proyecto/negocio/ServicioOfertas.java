package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.OfertasRepository;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

@Service

public class ServicioOfertas {

    @Autowired
    private OfertasRepository ofertasRepository;

    File archivo;

        /*
        * Método para buscar la imagen desde nuestro ordenador, comenzando la búsqueda
        * desde el escritorio, solo se aceptan imágenes con la extensión .jpg
        */
    public ImageIcon BuscarImagenes(){

        ImageIcon imagen = new ImageIcon();

            //Empezamos la búsqueda de los archivos desde el escritorio
        JFileChooser jfchooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        jfchooser.setDialogTitle("Cargando imágenes...");
        jfchooser.setAcceptAllFileFilterUsed(false);
        jfchooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg"));

        int resultado = jfchooser.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION){

            archivo = jfchooser.getSelectedFile();

            //Hacemos un try-catch para evitar un apuntador nulo
            try {
                
                imagen = new ImageIcon(archivo.toString());
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Error al buscar la imagen " + e);

            }//Fin del try-cacth

        }// Fin del if resultado

        return imagen;
        
    }// Fin del método BuscarImagenes


    public void EliminarImagenes(){
        //Método para eliminar imagenes
    }//Fin del método EliminarImagenes
    
}// Fin del la clase ServicioOfertas
