package mx.uam.ayd.proyecto.presentacion.modificarDiseño;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
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
       
		// Boton diseño cliente
        JButton btnDiseñoCliente = new JButton("Añadir diseño");
		btnDiseñoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDiseñoCliente.setBackground(Color.LIGHT_GRAY);
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.carritoDeCompras();
			}
		});
        btnDiseñoCliente.setBounds(330, 320, 130, 20);	
		contentPane.add(btnDiseñoCliente);	
		try {
			
			for( int i = 0; i < 6; i++ ){
				img.add(ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\"+(i+1)+".png")));
			}
			
			reescalarImagen();
			inciaJlabel();
			btnBorrar();
			btnCambiar();
			// Image neg1 = n1.getScaledInstance(130, 100, Image.SCALE_DEFAULT);
			// ineg1= new JLabel(new ImageIcon(neg1));
			// ineg1.setBounds(30, 60, 130, 100);
			// contentPane.add(ineg1);
			// btnDiseñoCliente.setBounds(30, 160, 60, 18);
			// btnDiseñoCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
			// contentPane.add(btnDiseñoCliente);
			// boton1.setBounds(90, 160, 70, 18);
			// boton1.setFont(new Font("Tahoma", Font.PLAIN, 9));
			// contentPane.add(boton1);

			// ev1 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\5.png"));
			// Image even2 = ev1.getScaledInstance(130, 100, Image.SCALE_DEFAULT);
			// ieven1= new JLabel(new ImageIcon(even2));
			// ieven1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			// ieven1.setBounds(30, 190, 130, 100);
			// contentPane.add(ieven1);

			
		} catch (IOException e1) {
			
			e1.printStackTrace();
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

}
