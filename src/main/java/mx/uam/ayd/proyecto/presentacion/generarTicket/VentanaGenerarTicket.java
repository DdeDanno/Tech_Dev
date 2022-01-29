package mx.uam.ayd.proyecto.presentacion.generarTicket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

@Component
public class VentanaGenerarTicket extends JFrame{
    
    private JPanel contentPane;

    @Autowired
    private ControlGenerarTicket control;

    JRadioButton radio1, radio2;
    
    //Constructor de la clase
    public VentanaGenerarTicket(){

        //Para que la ventana anterior no se cierre al cerrar esta ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Panel
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

        //Menu Navegacion
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


        //Seleccionar forma de pago
        JLabel labelSucursal=new JLabel("Selecciona tu forma de pago");
        labelSucursal.setBounds(35, 110, 200, 40);
        contentPane.add(labelSucursal);

        radio1=new JRadioButton();
        radio1.setText("Pago en línea");
        radio1.setBounds(50,140,150,30);
        radio1.setEnabled(false);
        
        radio2=new JRadioButton();
        radio2.setText("Otro");
        radio2.setBounds(50,170,120,30);
        
        add(radio1);
        add(radio2);

        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radio1);
        grupoRadioBotones.add(radio2);

        //Botón de Finalizar compra
        JButton btnFinalizarCompra = new JButton("Finalizar compra");
        btnFinalizarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				try{
					control.imprimeTicket();
				} catch(Exception error){
					//
				}//Fin del try-catch
			}//Fin de actionPerformed
        });//Fin de addActionListener

        btnFinalizarCompra.setBounds(270, 300, 150, 30);
		contentPane.add(btnFinalizarCompra);

    }//Fin del Contructor

    //Método para mostrar la vista previa del total de la compra
    public void muestra (ControlGenerarTicket control){
        this.control=control;
        JTextArea Cotizacion=new JTextArea("Folio: \n"
        +"Nombre: \n"
        +"Télefono: \n"
        +"E-mail: \n"
        +"             Cotización\n" +control.muestraCarrito());

        Cotizacion.setBounds(250, 100, 200, 150);
        Cotizacion.setEditable(false);
        contentPane.add(Cotizacion);
        setVisible(true);
    }//Fin del método muestra

}//Fin de la clase VentanaGenerarTicket
