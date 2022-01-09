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
		setBounds(500, 300, 500, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        //Titulo
        JLabel lblDiseño=new JLabel("CARRITO");
        lblDiseño.setBounds(5, 5, 160, 40);
        contentPane.add(lblDiseño);

        //Menu de navegación
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

        // Seleccionar sucursal
        JLabel lblSucursal=new JLabel("Selecciona tu sucursal");
        lblSucursal.setBounds(50, 80, 160, 40);
        contentPane.add(lblSucursal);

        radio1=new JRadioButton();
        radio1.setText("Los Reyes Centro");
        radio1.setBounds(50,110,150,30);
        
        radio2=new JRadioButton();
        radio2.setText("La Magdalena");
        radio2.setBounds(50,140,120,30);
        
        radio3=new JRadioButton();
        radio3.setText("Ixtapaluca");
        radio3.setBounds(50,170,120,30);
        
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

				} catch(Exception error){
					//
				}//Fin del try-catch
			}//Fin de actionPerformed
        });//Fin de addActionListener

        btnGenerarCompra.setBounds(165, 210, 150, 29);
		contentPane.add(btnGenerarCompra);

    }

    public void muestra (ControlCarritoDeCompras control){
        this.control=control;
        JTextArea Cotizacion=new JTextArea("            Cotización\n"+control.muestraCarritodeCompra());
        Cotizacion.setBounds(270, 80, 200, 100);
        Cotizacion.setEditable(false);
        contentPane.add(Cotizacion);
        setVisible(true);
    }

}
