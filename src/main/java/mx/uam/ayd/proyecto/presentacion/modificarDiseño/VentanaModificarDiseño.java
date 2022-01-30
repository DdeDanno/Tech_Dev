package mx.uam.ayd.proyecto.presentacion.modificarDiseño;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
@Component
public class VentanaModificarDiseño extends JFrame {
	@Autowired
	private ControlModificarDiseño control;
    private JPanel contentPane;

    ArrayList<BufferedImage> img = new ArrayList<BufferedImage>();
	ArrayList<JLabel> p = new ArrayList<JLabel>();
	ArrayList<JButton> cambiar = new ArrayList<JButton>();
	ArrayList<JButton> borrar = new ArrayList<JButton>();
	ArrayList<Image> image = new ArrayList<Image>();
	int labelX, borrarX, cambiarX;
	int labelY, borrarY, cambiarY;


    public VentanaModificarDiseño(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMiAplicacion = new JLabel("Diseños JEHC");
		lblMiAplicacion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMiAplicacion.setBounds(227, 0, 141, 36);
		contentPane.add(lblMiAplicacion);

		//titulo Ventas
		JLabel lblNewLabel = new JLabel("Modificar Diseño");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 25, 190, 25);
		contentPane.add(lblNewLabel);
		

		// Boton diseño cliente
		JButton btnDiseñoCliente = new JButton("Añadir diseño");
		btnDiseñoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDiseñoCliente.setBackground(Color.LIGHT_GRAY);
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					subirImagen();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDiseñoCliente.setBounds(420, 335, 130, 20);	
		contentPane.add(btnDiseñoCliente);
       
		try {
            acomodaDiseños();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public int cuentaImagenes(){
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
        return lista.length;
	}

    public void leeImagen() throws IOException{
		img.clear();
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
		for( int i = 0; i < lista.length; i++ ){
			img.add(ImageIO.read(new File(lista[i].getPath())));
		}
	}


	public void reescalarImagen(){
		image.clear();
		for( int i = 0; i < img.size(); i++){
			image.add(img.get(i).getScaledInstance(130, 100, Image.SCALE_DEFAULT));
		}
	}

	public void inciaJlabel(){
		p.clear();
		labelX = 60; labelY = 60;
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JLabel jlablel = new JLabel(new ImageIcon(image.get(i)));
			p.add(jlablel);
			p.get(i).setBounds(labelX, labelY, 130, 100);
			contentPane.add(p.get(i));
			labelX = labelX + 160;
			if(labelX == 540){
				labelX = 60;
				if((cuenta % 3) == 0)
					labelY = labelY + 138;
			}
			
		}
	}

	public void btnBorrar() {
		borrar.clear();	
		borrarX = 60; borrarY = 160;
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JButton btnBorrar = new JButton("Borrar");
			borrar.add(btnBorrar);
			borrar.get(i).setBounds(borrarX, borrarY, 60, 18);
			borrar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(borrar.get(i));
			borrarX = borrarX + 160;
			if(borrarX == 540){
				borrarX = 60;
				if((cuenta % 3) == 0)
					borrarY = borrarY + 138;
			}

			borrar.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int elemento = borrar.indexOf(e.getSource());
					try {
						borrarElemento(elemento);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}});
		}	
	}

	public void btnCambiar() {
		cambiar.clear();
		cambiarX = 120; cambiarY = 160;
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JButton btnCambiar = new JButton("Cambiar");
			cambiar.add(btnCambiar);
			cambiar.get(i).setBounds(cambiarX, cambiarY, 70, 18);
			cambiar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(cambiar.get(i));
			cambiarX = cambiarX + 160;
			if(cambiarX == 600){
				cambiarX = 120;
				if((cuenta % 3) == 0)
					cambiarY = cambiarY + 138;
			}

			cambiar.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int elemento = cambiar.indexOf(e.getSource());
					try {
						actualizarImagen(elemento);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}});
			
		}	
	}

	public void acomodaDiseños() throws IOException{
		leeImagen();
		reescalarImagen();
		inciaJlabel();
		btnBorrar();
		btnCambiar();
	}
	
    public void borraImagen(int elemento){

        try{

            File archivo = new File("src\\main\\resources\\imagenesDiseños\\"+"diseño"+(elemento+1)+".png");

            boolean estatus = archivo.delete();

            if (!estatus) {

                System.out.println("Error no se ha podido eliminar el  archivo");

           }else{

                System.out.println("Se ha eliminado el diseño exitosamente");

           }

        }catch(Exception e){

           System.out.println(e);

        }

    }

	public void renombrarImagenes(){
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
		for( int i = 0 ; i < lista.length ; i++ ){
			File archivo = new File(lista[i].getPath());
			File nuevoNombre = new File("src\\main\\resources\\imagenesDiseños\\diseño"+(i+1)+".png");
			archivo.renameTo(nuevoNombre);	
		}
	}

	
	public void subirImagen() throws IOException{
		JFileChooser elegirArchivo = new JFileChooser();
		elegirArchivo.showOpenDialog(elegirArchivo);
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
		try {
            String ruta = elegirArchivo.getSelectedFile().getAbsolutePath();
			if(elegirArchivo.getSelectedFile().getName().endsWith(".png")){
				FileInputStream in = new FileInputStream(ruta);
				FileOutputStream out = new FileOutputStream("src\\main\\resources\\imagenesDiseños\\diseño"+(lista.length+1)+".png"); 
				byte[] buf = new byte[1024];
				int len;
	
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}     
				
				in.close();
				out.close();
			}else{
				JOptionPane.showMessageDialog(null, "El archivo debe ser .png", "Diferente formato", JOptionPane.WARNING_MESSAGE);
			}
			
        } 
		catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } 
		catch (Exception e) {
            System.out.println(e.getMessage());
        }
		for( int i = 0 ; i < lista.length ; i++ ){	
			contentPane.remove(p.get(i));
			contentPane.remove(cambiar.get(i));
			contentPane.remove(borrar.get(i));
		}
		acomodaDiseños();
		this.repaint();
	}

	public void actualizarImagen(int elemento) throws IOException{
		JFileChooser elegirArchivo = new JFileChooser();
		elegirArchivo.showOpenDialog(elegirArchivo);
		try {
            String ruta = elegirArchivo.getSelectedFile().getAbsolutePath();
			if(elegirArchivo.getSelectedFile().getName().endsWith(".png")){
				borraImagen(elemento);
				FileInputStream in = new FileInputStream(ruta);
				FileOutputStream out = new FileOutputStream("src\\main\\resources\\imagenesDiseños\\diseño"+(elemento+1)+".png"); 
				byte[] buf = new byte[1024];
				int len;
	
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}     
				
				in.close();
				out.close();
			}else{
				JOptionPane.showMessageDialog(null, "El archivo debe ser .png", "Diferente formato", JOptionPane.WARNING_MESSAGE);
			}
			
        } 
		catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } 
		catch (Exception e) {
            System.out.println(e.getMessage());
        }
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
		for( int i = 0 ; i < lista.length ; i++ ){	
			contentPane.remove(p.get(i));
			contentPane.remove(cambiar.get(i));
			contentPane.remove(borrar.get(i));
		}
		acomodaDiseños();
		this.repaint();
	}


	public void borrarElemento(int elemento) throws IOException{
		File carpeta = new File("src\\main\\resources\\imagenesDiseños"); 
		File[] lista = carpeta.listFiles();
		for( int i = 0 ; i < lista.length ; i++ ){	
			contentPane.remove(p.get(i));
			contentPane.remove(cambiar.get(i));
			contentPane.remove(borrar.get(i));
		}
		borraImagen(elemento);
		this.repaint();
		renombrarImagenes();
		acomodaDiseños();
		this.repaint();
	}

	public void muestra (ControlModificarDiseño control){
        this.control = control;
        setVisible(true);
    }
    

}

