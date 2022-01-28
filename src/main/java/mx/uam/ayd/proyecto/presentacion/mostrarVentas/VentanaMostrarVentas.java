package mx.uam.ayd.proyecto.presentacion.mostrarVentas;

import java.awt.Font;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;


@SuppressWarnings("serial")
@Component
public class VentanaMostrarVentas extends JFrame{
    @Autowired
    private ControlMostrarVentas control;
    @Autowired
    PedidoRepository pedidoRepository;
    private JPanel contentPane;
    private JTextField txtFolio;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtFecha;

    public VentanaMostrarVentas(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Nombre empresa
		JLabel lblMiAplicacin = new JLabel("Diseños JEHC");
		lblMiAplicacin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMiAplicacin.setBounds(227, 0, 141, 36);
		contentPane.add(lblMiAplicacin);

        //titulo Ventas
		JLabel lblNewLabel = new JLabel("Ventas realizadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 190, 25);
		contentPane.add(lblNewLabel);

        //Comienzan los titulos de los encabezados
		txtFolio = new JTextField();
		txtFolio.setEditable(false);
		txtFolio.setText("| FOLIO |");
		txtFolio.setBounds(60, 107, 55, 20);
		contentPane.add(txtFolio);
		txtFolio.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setText("| PRODUCTO |");
		txtProducto.setColumns(10);
		txtProducto.setBounds(143, 107, 91, 20);
		contentPane.add(txtProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setText("| CANTIDAD |");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(257, 107, 91, 20);
		contentPane.add(txtCantidad);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setText("| FECHA DE COMPRA |");
		txtFecha.setColumns(10);
		txtFecha.setBounds(370, 107, 145, 20);
		contentPane.add(txtFecha);
		//Terminan los titulos de los encabezados
    }

    public void muestra (ControlMostrarVentas control){
        int y = 140, y2 = 140, y3 = 140, y4 = 140;
        int contador = 0,nVentas = 0;

        for(Pedido element:pedidoRepository.findAll()){
            element.getFolio();
            nVentas++;
        }

        //Mostrando folios
        JLabel label[] = new JLabel[nVentas];
        for(Pedido element:pedidoRepository.findAll()){
            label[contador] = new JLabel(element.getFolio());
            label[contador].setFont(new Font("Tahoma", Font.PLAIN, 15));
            label[contador].setBounds(50, y, 78, 14);
            contentPane.add(label[contador]);
            y = y + 24; 
            contador++;
        }

        //Mostrando productos
        JLabel label2[] = new JLabel[nVentas];
        String[] producto = {"Lona", "Lona", "Tazas", "Tazas"};
        for(int i = 0; i < nVentas; i++){
            label2[i] = new JLabel(producto[i]);
            label2[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
            label2[i].setBounds(170, y2, 40, 14);
            contentPane.add(label2[i]);
            y2 = y2 + 24; 
        }

        //Mostrando cantidad
        JLabel label3[] = new JLabel[nVentas];
        String[] cantidad = {"1", "2", "5", "2"};
        for(int i = 0; i < nVentas; i++){
            label3[i] = new JLabel(cantidad[i]);
            label3[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
            label3[i].setBounds(295, y3, 40, 14);
            contentPane.add(label3[i]);
            y3 = y3 + 24; 
        }

        //Mostrando fecha
        JLabel label4[] = new JLabel[nVentas];
        String[] fecha = {"19/10/2021", "24/08/2021", "01/08/2021", "10/06/2021"};
        for(int i = 0; i < nVentas; i++){
            label4[i] = new JLabel(fecha[i]);
            label4[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
            label4[i].setBounds(400, y4, 80, 14);
            contentPane.add(label4[i]);
            y4 = y4 + 24; 
        }

        this.control=control;
        setVisible(true);
    }
}
