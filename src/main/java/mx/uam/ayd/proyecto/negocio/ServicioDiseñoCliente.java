package mx.uam.ayd.proyecto.negocio;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.DiseñoClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.DiseñoCliente;

@Service
public class ServicioDiseñoCliente {
    
    @Autowired
    private DiseñoClienteRepository diseñoClienteRepository;
    public void SubirArchivo(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Por favor cargue su imagen: ");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png"));

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                DiseñoCliente diseñoCliente=new DiseñoCliente();
   //             diseñoCliente.setRutaArchivo(jfc.getSelectedFile().getAbsolutePath());
   //           diseñoCliente.setNombreCliente("Diseño cliente: ");
                diseñoClienteRepository.save(diseñoCliente);
            }
        }
    }
}
