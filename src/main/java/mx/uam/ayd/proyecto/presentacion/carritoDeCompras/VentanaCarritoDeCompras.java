package mx.uam.ayd.proyecto.presentacion.carritoDeCompras;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.Font;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@SuppressWarnings("serial")
@Component
public class VentanaCarritoDeCompras extends JFrame{
    private JPanel contentPane;

    @Autowired
    private ControlCarritoDeCompras control;
    

    JRadioButton radio1,radio2,radio3;
    JButton button;

    public VentanaCarritoDeCompras (){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        //Titulo
        JLabel lblDiseno=new JLabel("Diseños JEHC");
        lblDiseno.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDiseno.setBounds(220, 5, 160, 40);
        contentPane.add(lblDiseno);

        //Menu de navegación
        JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(1, 35, 590, 50);
		contentPane.add(menuNav);
		
        JButton botonInicio = new JButton("Inicio");
        botonInicio.setBounds(1, 35, 50, 40);
        menuNav.add(botonInicio);

        JButton botonProductos = new JButton("Productos");
        botonProductos.setBounds(36, 35, 70, 40);
        menuNav.add(botonProductos);

        JButton botonDisenos = new JButton("Diseños");
        botonDisenos.setBounds(71, 35, 60, 40);
        menuNav.add(botonDisenos);

        JButton botonNosotros = new JButton("Nosotros");
        botonNosotros.setBounds(106, 35, 60, 40);
        menuNav.add(botonNosotros);

        JButton botonPerfil = new JButton("Perfil");
        botonPerfil.setBounds(141, 35, 60, 40);
        menuNav.add(botonPerfil);


        // Seleccionar sucursal
        JLabel lblSucursal=new JLabel("Selecciona tu sucursal");
        lblSucursal.setBounds(35, 110, 200, 40);
        contentPane.add(lblSucursal);

        radio1=new JRadioButton();
        radio1.setText("Los Reyes Centro");
        radio1.setBounds(50,140,150,30);
        
        radio2=new JRadioButton();
        radio2.setText("La Magdalena");
        radio2.setBounds(50,170,120,30);
        
        radio3=new JRadioButton();
        radio3.setText("Ixtapaluca");
        radio3.setBounds(50,200,120,30);
        
        add(radio1);
        add(radio2);
        add(radio3);

        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radio1);
        grupoRadioBotones.add(radio2);
        grupoRadioBotones.add(radio3);

        // Boton de generar compra
        JButton btnGenerarCompra = new JButton("Generar compra");
        btnGenerarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try{
					control.generarTicket();
                    setVisible(false);
				} catch(Exception error){
					//
				}//Fin del try-catch
			}//Fin de actionPerformed
        });//Fin de addActionListener

        btnGenerarCompra.setBounds(270, 300, 150, 30);
		contentPane.add(btnGenerarCompra);

    }

    public void muestra (ControlCarritoDeCompras control){
        this.control=control;
        JTextArea Cotizacion=new JTextArea("            Cotización\n"+control.muestraCarritodeCompra());
        Cotizacion.setBounds(250, 100, 200, 150);
        Cotizacion.setEditable(false);
        contentPane.add(Cotizacion);
        setVisible(true);
    }

}
