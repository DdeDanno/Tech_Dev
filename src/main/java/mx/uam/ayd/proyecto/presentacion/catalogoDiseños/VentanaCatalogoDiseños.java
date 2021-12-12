package mx.uam.ayd.proyecto.presentacion.catalogoDiseños;

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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.*;

import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;


@SuppressWarnings ("serial")
@Component
public class VentanaCatalogoDiseños extends JFrame{
    private JPanel contentPane;
    private ControlCatalogoDiseños control;
	JLabel ineg1, ineg2, ieven1, ieven2, iotr1, iotr2;
    public VentanaCatalogoDiseños (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setBounds(200, 5, 440, 16);
		contentPane.add(lblMiAplicacin);

		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(5, 20, 500, 30);
		contentPane.add(menuNav);
		JMenu menu1,menu2,menu4,menu5,menu6;
		JButton menu3;
		menu1=new JMenu("Inicio");
		menuNav.add(menu1);
		menu2=new JMenu("Productos");
		menuNav.add(menu2);
		menu3=new JButton("Diseños");
		menu3.setBackground(Color.GRAY);
		menu3.setBorder(null);
		menu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuNav.add(menu3);
		menu4=new JMenu("¿Preguntas?");
		menuNav.add(menu4);
		menu5=new JMenu("Perfil");
		menuNav.add(menu5);
		menu6=new JMenu("Carrito");
		menuNav.add(menu6);

		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					control.inicia();
				} catch(Exception error){
					System.out.println("Error");	
				}
			}
		});

		JMenuBar menuClasificacion= new JMenuBar ();
		menuClasificacion.setBounds(90, 50, 500, 30);
		contentPane.add(menuClasificacion);
		JButton m1,m2,m3,m4;
		m1=new JButton("Todos");
		m1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m1.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m1);
		m2=new JButton("Eventos");
		m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m2.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m2);
		m3=new JButton("Negocios");
		m3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m3.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m3);
		m4=new JButton("Otros");
		m4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		m4.setBackground(Color.LIGHT_GRAY);
		menuClasificacion.add(m4);

		// Imagen
		BufferedImage n1,n2,ev1,ev2,o1,o2;
		
		try {
			n1 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\2.jpg"));
			Image neg1 = n1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ineg1= new JLabel(new ImageIcon(neg1));
			ineg1.setBounds(50, 85, 100, 100);
			contentPane.add(ineg1);

			n2 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\3.jpg"));
			Image neg2 = n2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ineg2= new JLabel(new ImageIcon(neg2));
			ineg2.setBounds(200, 85, 100, 100);
			contentPane.add(ineg2);

			ev1 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\4.jpg"));
			Image even1 = ev1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ieven1= new JLabel(new ImageIcon(even1));
			ieven1.setBounds(350, 85, 100, 100);
			contentPane.add(ieven1);

			ev2 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\5.jpg"));
			Image even2 = ev2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ieven2= new JLabel(new ImageIcon(even2));
			ieven2.setBounds(50, 200, 100, 100);
			contentPane.add(ieven2);

			o1 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\1.jpg"));
			Image otr1 = o1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			iotr1= new JLabel(new ImageIcon(otr1));
			iotr1.setBounds(200, 200, 100, 100);
			contentPane.add(iotr1);

			o2 = ImageIO.read(new File("D:\\ESCUELA\\UAM\\Ingenieria de Software\\6.jpg"));
			Image otr2 = o2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			iotr2= new JLabel(new ImageIcon(otr2));
			iotr2.setBounds(350, 200, 100, 100);
			contentPane.add(iotr2);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		m1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ineg1.setVisible(false);
				ineg2.setVisible(false);
				ieven1.setVisible(false);
				ieven2.setVisible(false);
				iotr1.setVisible(false);
				iotr2.setVisible(false);

				ineg1.setBounds(50, 85, 100, 100);
				ineg2.setBounds(200, 85, 100, 100);
				ieven1.setBounds(350, 85, 100, 100);
				ieven2.setBounds(50, 200, 100, 100);
				iotr1.setBounds(200, 200, 100, 100);
				iotr2.setBounds(350, 200, 100, 100);

				ineg1.setVisible(true);
				ineg2.setVisible(true);
				ieven1.setVisible(true);
				ieven2.setVisible(true);
				iotr1.setVisible(true);
				iotr2.setVisible(true);
			}
			
		});

		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ineg1.setVisible(false);
				ineg2.setVisible(false);
				ieven1.setVisible(false);
				ieven2.setVisible(false);
				iotr1.setVisible(false);
				iotr2.setVisible(false);

				ieven1.setBounds(50, 85, 100, 100);
				ieven2.setBounds(200, 85, 100, 100);

				ieven1.setVisible(true);
				ieven2.setVisible(true);
			}
		});

		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ineg1.setVisible(false);
				ineg2.setVisible(false);
				ieven1.setVisible(false);
				ieven2.setVisible(false);
				iotr1.setVisible(false);
				iotr2.setVisible(false);

				ineg1.setBounds(50, 85, 100, 100);
				ineg2.setBounds(200, 85, 100, 100);

				ineg1.setVisible(true);
				ineg2.setVisible(true);
			}
		});

		m4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ineg1.setVisible(false);
				ineg2.setVisible(false);
				ieven1.setVisible(false);
				ieven2.setVisible(false);
				iotr1.setVisible(false);
				iotr2.setVisible(false);

				iotr1.setBounds(50, 85, 100, 100);
				iotr2.setBounds(200, 85, 100, 100);

				iotr1.setVisible(true);
				iotr2.setVisible(true);
			}
			
		});

		// Boton diseño cliente
        JButton btnDiseñoCliente = new JButton("Deseo hacer mi propio diseño");
		btnDiseñoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDiseñoCliente.setBackground(Color.LIGHT_GRAY);
		btnDiseñoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.carritoDeCompras();;
			}
		});
        btnDiseñoCliente.setBounds(273, 310, 210, 29);
		contentPane.add(btnDiseñoCliente);
    }

    public void muestra (ControlCatalogoDiseños control){
        this.control=control;
        setVisible(true);
    }
}
