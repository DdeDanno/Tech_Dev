package mx.uam.ayd.proyecto.presentacion.modificarDiseño;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;

@SuppressWarnings ("serial")
@Component
public class VentanaModificarDiseños extends JFrame{
    private JPanel contentPane;
    private ControlModificarDiseños control;
	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;

	ArrayList<BufferedImage> img = new ArrayList<BufferedImage>();
	ArrayList<JLabel> p = new ArrayList<JLabel>();
	ArrayList<JButton> cambiar = new ArrayList<JButton>();
	ArrayList<JButton> borrar = new ArrayList<JButton>();
	ArrayList<Image> image = new ArrayList<Image>();
	int labelX = 30, borrarX = 30, cambiarX = 90;
	int labelY = 60, borrarY = 160, cambiarY = 160;

    public VentanaModificarDiseños (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMiAplicacin = new JLabel("Modificar Diseño");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);

		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(10, 23, 500, 30);
		contentPane.add(menuNav);
		JButton menu1,menu2,menu3,menu4,iniSesion;
		
		menu1=new JButton("Inicio");
		menu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu1);
		menu2=new JButton("Productos");
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu2);
		menu3=new JButton("Diseños");
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		iniSesion = new JButton("Registrarse");
		iniSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(iniSesion);
		menu4=new JButton("Carrito");
		menu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu4);

		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.inicia();
				} catch(Exception error){
					System.out.println("Error");	
				}
			}
		});
		// Boton diseño cliente
		JButton btnDiseñoCliente = new JButton("Añadir diseño");
		btnDiseñoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDiseñoCliente.setBackground(Color.LIGHT_GRAY);
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.SubirArchivo();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDiseñoCliente.setBounds(330, 320, 130, 20);	
		contentPane.add(btnDiseñoCliente);
          

		//Boton perfil NECESARIO PARA HU:ESTATUS DEL PEDIDO NO BORRAR
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.perfil();
			}
		});
		btnPerfil.setBounds(414, 23, 65, 30);
		btnPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(btnPerfil);

		// Listenes para mandar a llamar al controlAgregarUsuario
		iniSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controlAgregarUsuario.inicia();

			}
		});
       
		try {	
			
			for( int i = 0; i < 6; i++ ){
				img.add(ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\"+(i+1)+".png")));
			}
			
			reescalarImagen();
			inciaJlabel();
			btnBorrar();
			btnCambiar();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

    public void muestra (ControlModificarDiseños control){
        this.control=control;
        setVisible(true);
    }

	public void reescalarImagen(){
		for( int i = 0; i < img.size(); i++){
			image.add(img.get(i).getScaledInstance(130, 100, Image.SCALE_DEFAULT));
		}
	}

	public void inciaJlabel(){
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JLabel jlablel = new JLabel(new ImageIcon(image.get(i)));
			p.add(jlablel);
			p.get(i).setBounds(labelX, labelY, 130, 100);
			contentPane.add(p.get(i));
			labelX = labelX + 150;
			if(labelX == 480){
				labelX = 30;
				if((cuenta % 3) == 0)
					labelY = labelY + 138;
			}
			
		}
	}

	public void acomodaDiseños(){
		int cuenta = 0;
		int cuenta1 = 0;
		int cuenta2 = 0;
		labelX = 30; borrarX = 30; cambiarX = 90;
		labelY = 60; borrarY = 160; cambiarY = 160;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			p.get(i).setBounds(labelX, labelY, 130, 100);
			contentPane.add(p.get(i));
			labelX = labelX + 150;
			if(labelX == 480){
				labelX = 30;
				if((cuenta % 3) == 0)
					labelY = labelY + 138;
			}
		}

		for( int i = 0; i < img.size(); i++){
			cuenta1 = cuenta1 + 1;
			borrar.get(i).setBounds(borrarX, borrarY, 60, 18);
			borrar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(borrar.get(i));
			borrarX = borrarX + 150;
			if(borrarX == 480){
				borrarX = 30;
				if((cuenta1 % 3) == 0)
					borrarY = borrarY + 138;
			}
			borrar.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int elemento = borrar.indexOf(e.getSource());
					borrarElemento(elemento);
				}});
		}

		for( int i = 0; i < img.size(); i++){
			cuenta2 = cuenta2 + 1;
			cambiar.get(i).setBounds(cambiarX, cambiarY, 70, 18);
			cambiar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(cambiar.get(i));
			cambiarX = cambiarX + 150;
			if(cambiarX == 540){
				cambiarX = 90;
				if((cuenta2 % 3) == 0)
					cambiarY = cambiarY + 138;
			}
			
		}

		
	}

	public void btnBorrar() {
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JButton btnBorrar = new JButton("Borrar");
			borrar.add(btnBorrar);
			borrar.get(i).setBounds(borrarX, borrarY, 60, 18);
			borrar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(borrar.get(i));
			borrarX = borrarX + 150;
			if(borrarX == 480){
				borrarX = 30;
				if((cuenta % 3) == 0)
					borrarY = borrarY + 138;
			}

			borrar.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int elemento = borrar.indexOf(e.getSource());
					borrarElemento(elemento);
				}});
		}	
	}

	public void btnCambiar() {
		int	cuenta = 0;
		for( int i = 0; i < img.size(); i++){
			cuenta = cuenta + 1;
			JButton btnCambiar = new JButton("Cambiar");
			cambiar.add(btnCambiar);
			cambiar.get(i).setBounds(cambiarX, cambiarY, 70, 18);
			cambiar.get(i).setFont(new Font("Tahoma", Font.PLAIN, 9));
			contentPane.add(cambiar.get(i));
			cambiarX = cambiarX + 150;
			if(cambiarX == 540){
				cambiarX = 90;
				if((cuenta % 3) == 0)
					cambiarY = cambiarY + 138;
			}
			
		}	
	}


	public void borrarElemento(int elemento){
		
		System.out.println(img.size());
		cambiar.remove(elemento);
		borrar.remove(elemento);
		img.remove(elemento);
		p.remove(elemento);
		image.remove(elemento);
		acomodaDiseños();
		System.out.println(elemento);
		System.out.println(cambiar.size());
		System.out.println(borrar.size());
		System.out.println(img.size());
		System.out.println(p.size());
		System.out.println(image.size());
	}

}
