package mx.uam.ayd.proyecto.negocio;

import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.CarritoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.negocio.modelo.Carrito;

@Service
public class ServicioVenta {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Método que crea el pdf
    public void creaFormato() throws MalformedURLException, IOException {
        Document documento = new Document();
        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/Desktop/formato.pdf"));

            documento.open();
            
            //Logo
            //Image logo = Image.getInstance("src/main/imagenes/logo.png");

            //Encabezado
            PdfPTable encabezado = new PdfPTable(1);
            encabezado.setWidthPercentage(90);
            encabezado.getDefaultCell().setBorder(0);
            encabezado.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado.addCell("Formato de pago\n\n\n");
            //encabezado.addCell(logo);

            documento.add(encabezado);

            //Información del cliente
            PdfPTable tablaDatos = new PdfPTable(3);
            tablaDatos.setWidthPercentage(100);
            //tablaDatos.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            tablaDatos.addCell("    Nombre");
            tablaDatos.addCell("    Cantidad a pagar");
            tablaDatos.addCell("    Fecha Límite");

            documento.add(tablaDatos);

            PdfPTable tablaInfoCliente = new PdfPTable(3);
            tablaInfoCliente.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            tablaInfoCliente.setHorizontalAlignment(Element.ALIGN_CENTER);

            // nombre
            tablaInfoCliente.addCell("Perengano Pérez");
            /*
            * Provicional. Obtenemos los datos del primer usuario
            * en el repositorio
            *
            for(Usuario user:usuarioRepository.findAll()){
                if(user.getIdUsuario()==1){
                    String nombreCliente = user.getNombre() + user.getApellido();
                    tablaInfoCliente.addCell(nombreCliente);
                    
                }
            }
            */

            // cuenta total
            Carrito carrito=null;
            for(Carrito element:carritoRepository.findAll()){
                if(element.getId_carrito() == 1){
                    carrito = element;
                }
            }
            tablaInfoCliente.addCell(""+carrito.getPrecio_tot());

            // fecha límite
            Paragraph fechaLimite = new Paragraph();
            fechaLimite.add(Chunk.NEWLINE);

            Calendar calendario = Calendar.getInstance();
            Date fechaActual = new Date();
            calendario.setTime(fechaActual);
            calendario.add(Calendar.DAY_OF_YEAR, 7);

            fechaLimite.add(new SimpleDateFormat("dd/MM/yyyy").format(calendario.getTime()));
            tablaInfoCliente.addCell(fechaLimite);

            documento.add(tablaInfoCliente);

            //Información para el cliente
            Paragraph infoBancos = new Paragraph();
            infoBancos.add(Chunk.NEWLINE);
            infoBancos.add("\nProdrá realizar su pago en las siguientes dependencias bancarias\n\n\n");

            documento.add(infoBancos);

            //Bancos 1er parte
            PdfPTable bancos = new PdfPTable(2);
            bancos.setWidthPercentage(100);
            bancos.addCell("    BBVA\n"+"No. Cuenta: 523472486184");
            bancos.addCell("    Banorte\n"+"No. Cuenta: 764358321364");

            documento.add(bancos);

            PdfPTable bancos2 = new PdfPTable(2);
            bancos2.setWidthPercentage(100);
            bancos2.addCell("   Banamex\n"+"No. Cuenta: 836426527352776");
            bancos2.addCell("   Santander\n"+"No. Cuenta: 123324364747");

            documento.add(bancos2);
            
            //Notas de importancia
            Paragraph notas = new Paragraph();
            notas.add(Chunk.NEWLINE);
            notas.add("\n\n\n       I M P O R T A N T E\n"
            + "- El pago lo debes realizar por la cantidad que se indica, antes de la fecha límite.\n"
            + "- Los pagos realizados después de esta fecha no serán válidos.\n"
            + "- El pago deberá realizarse en una sola exhibición.\n"
            + "- Sólo se admiten pagos en moneda nacional.\n"
            + "- Conserva tu comprobante de pago.\n"
            + "- Recuerda subir tu comprobante de pago para continuar con tu pedido.");

            documento.add(notas);

            documento.close();

            //usuarioRepository.save(documento);

            JOptionPane.showMessageDialog(null, "Archivo creado con éxito\n" +
            "Verifique su escritorio");

        } catch (DocumentException | FileNotFoundException e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null, "Error al crear formato");
        }
    }//Fin de imprimeFormato

}//Fin de ServicioVenta