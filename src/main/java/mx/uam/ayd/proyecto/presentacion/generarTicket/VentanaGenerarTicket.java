package mx.uam.ayd.proyecto.presentacion.generarTicket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
    JButton btn;
    //Constructor de la clase
    public VentanaGenerarTicket(){

        //Para que la ventana anterior no se cierre al cerrar esta ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        //Titulo
        JLabel lblDiseño=new JLabel("CARRITO");
        lblDiseño.setBounds(5, 5, 160, 40);
        contentPane.add(lblDiseño);

        //Menu Navegacion
		JMenuBar menuNav= new JMenuBar ();
		menuNav.setBounds(5, 35, 500, 30);
		contentPane.add(menuNav);
		JMenu menu1,menu2,menu3,menu4,menu5;
		menu1=new JMenu("Inicio");
		menuNav.add(menu1);
		menu2=new JMenu("Productos");
		menuNav.add(menu2);
		menu3=new JMenu("Diseños");
		menuNav.add(menu3);
		menu4=new JMenu("Nosotros");
		menuNav.add(menu4);
		menu5=new JMenu("Perfil");
		menuNav.add(menu5);

        //Seleccionar forma de pago
        JLabel labelSucursal=new JLabel("Selecciona tu forma de pago");
        labelSucursal.setBounds(35, 80, 200, 40);
        contentPane.add(labelSucursal);

        radio1=new JRadioButton();
        radio1.setText("Pago en línea");
        radio1.setBounds(50,110,150,30);
        radio1.setEnabled(false);
        
        radio2=new JRadioButton();
        radio2.setText("Otro");
        radio2.setBounds(50,140,120,30);
        
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

        btnFinalizarCompra.setBounds(165, 210, 150, 29);
		contentPane.add(btnFinalizarCompra);

    }//Fin del Contructor

    //Método para mostrar la vista previa del total de la compra
    public void muestra (ControlGenerarTicket control){
        this.control=control;
        JTextArea Cotizacion=new JTextArea(control.muestraCarrito());
        Cotizacion.setBounds(270, 80, 200, 100);;
        contentPane.add(Cotizacion);
        setVisible(true);
    }//Fin del método muestra

}//Fin de la clase VentanaGenerarTicket
