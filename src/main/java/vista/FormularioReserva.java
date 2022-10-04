package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Logica.convertirFecha;



public class FormularioReserva extends JFrame implements ActionListener {
	
	
	JPanel contentPane;
	public static final double valorNoche = 130000; // establezco el valor por noche, se coloca double por si requiere estar con decimales
	
	
	JDateChooser txtFechaCheckIn;
	JDateChooser txtFechaCheckOut;
	JTextField txtValorReserva;
	public static int numeroReserva;
	
	
	
	public FormularioReserva()
    {
        // se establecen los parametros del formulario
        
        setTitle("HOTEL ALURA");       // establecemos el titulo dela ventana
        
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso no hace nada
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioReserva.class.getResource("/IMG/aH-40px.png"))); // aqui se coloca una imagen en el titulo
		setBounds(100, 100, 910, 537);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso salir(null);             // con este comando se coloca en el centro la ventana
        setLayout(null);                         // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
        
        
       iniciarComponentes();
    }
	
	
	public void iniciarComponentes( ) {
		
		contentPane = new JPanel(); // crea un nuevo panel
		contentPane.setLayout(null); // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // genera bordes en el panel
		setContentPane(contentPane); // con esta instruccion no es requerido add(contentPane); ya que el elemento se posiciona en todo el elemento padre
		contentPane.setBounds(0, 0, 910, 537);
		//contentPane.setBackground(Color.green);
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true); esto quita la barra de titulo
		
		JPanel panelImg = new JPanel();
		panelImg.setBackground(SystemColor.window);
		panelImg.setBounds(415, 0, 910, 537);
		contentPane.add(panelImg);
		//panelImg.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		panelImg.setLayout(null);
		  
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 0, 495, 537);
		imagenFondo.setIcon(new ImageIcon(FormularioReserva.class.getResource("/IMG/reservas-img-3.png")));
		panelImg.add(imagenFondo);
		
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(SystemColor.lightGray);
		panelbotones.setBounds(0, 0, 415, 537);
		//panelbotones.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		contentPane.add(panelbotones);
		panelbotones.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(305, 10, 102, 102);
		logo.setIcon(new ImageIcon(FormularioReserva.class.getResource("/IMG/Ha-100px.png")));
		panelbotones.add(logo);
		
		final JLabel labelReservas = new JLabel("Sistema de Reservas");
		labelReservas.setBounds(100, 90, 220, 30);
		labelReservas.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelReservas.setFont(new Font("Serif", Font.PLAIN, 24)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelReservas);
		
		final JLabel labelCheckin = new JLabel("Fecha de Check In");
		labelCheckin.setBounds(50, 130, 250, 30);
		labelCheckin.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelCheckin.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelCheckin);
		
		txtFechaCheckIn = new JDateChooser();
		txtFechaCheckIn.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaCheckIn.getCalendarButton().setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/icon-reservas.png")));
		txtFechaCheckIn.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFechaCheckIn.setBounds(50, 165, 250, 35);
		panelbotones.add(txtFechaCheckIn);
		
		final JLabel labelCheckOut = new JLabel("Fecha de Check Out");
		labelCheckOut.setBounds(50, 210, 250, 30);
		labelCheckOut.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelCheckOut.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelCheckOut);
		
		txtFechaCheckOut = new JDateChooser();
		txtFechaCheckOut.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaCheckOut.getCalendarButton().setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/icon-reservas.png")));
		txtFechaCheckOut.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFechaCheckOut.setBounds(50, 245, 250, 35);
		panelbotones.add(txtFechaCheckOut);
		
		
		txtFechaCheckOut.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent e) {
                
				Date fechaFinal = txtFechaCheckOut.getDate();
				Date fechaInicial = txtFechaCheckIn.getDate();
				
				if(fechaFinal == null || fechaInicial == null ) {
					System.out.println("esperando fecha");
					
				}else {
							
					long fecha1 = 	fechaFinal.getTime();
					//System.out.println("dias: " + fecha1);
					long fecha2 = fechaInicial.getTime();
					//System.out.println("dias: " + fecha2);
					long resultado = (fecha1 - fecha2)/86400000; //el valor se obtiene en milisegundos, con el valor de abajo corresponde a un dia en millisegundos)
					
					//System.out.println(resultado);
					
					if(resultado <1) {
						
						JOptionPane.showConfirmDialog(null, "la fecha de Check Out no puede ser igual o menor que la Fecha de Check In",
				                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
				                JOptionPane.INFORMATION_MESSAGE);
						
						txtValorReserva.setText("0");
						resultado = 0;
						
					}else {
						
						String valor = String.valueOf(resultado*valorNoche);
						txtValorReserva.setText(valor);
					}
					
					
				}
			}	
			
				
			
		});
		
		final JLabel labelValorReserva = new JLabel("Valor de la Reserva");
		labelValorReserva.setBounds(50, 290, 250, 30);
		labelValorReserva.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelValorReserva.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelValorReserva);
		
		txtValorReserva = new JTextField();
		txtValorReserva.setBounds(50, 325, 250, 35);
		txtValorReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValorReserva.setEditable(false);
		panelbotones.add(txtValorReserva);
		

		final JLabel labelFormaPago = new JLabel("Forma de Pago");
		labelFormaPago.setBounds(50, 370, 250, 30);
		labelFormaPago.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelFormaPago.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelFormaPago);
		
		final JComboBox txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(50, 405, 250, 35);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta Credito", "Tarjeta Debito", "Dinero en efectivo"}));
		panelbotones.add(txtFormaPago);
		
		
		final JButton botonReservas = new JButton("Continuar");
		botonReservas.setBounds(50, 455, 120, 35);
		panelbotones.add(botonReservas);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonReservas.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(txtFechaCheckIn.getDate() == null || txtFechaCheckOut.getDate() == null || txtValorReserva.getText().equals("") || txtValorReserva.getText().equals("0")) {
							
							JOptionPane.showConfirmDialog(null, "todos los campos deben ser diligenciados y la fecha de Check Out debe ser posterior a la de Check In",
					                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
					                JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							
							Date DateFechaCheckIn = txtFechaCheckIn.getDate();
							Date DateFechaCheckOut = txtFechaCheckOut.getDate();
							
							convertirFecha conversorFecha = new convertirFecha();
							
							String FechaCheckInConvertidad = conversorFecha.convertiFecha(DateFechaCheckIn);
							String FechaCheckOutConvertidad = conversorFecha.convertiFecha(DateFechaCheckOut);
							
							double ValorReserva = Double.parseDouble(txtValorReserva.getText());
							
							String FormaPago = String.valueOf(txtFormaPago.getSelectedItem());
							
							numeroReserva++;
							
							SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMdd");
							Calendar calendar = Calendar.getInstance();

					        Date dateObj = calendar.getTime();
							String prueba = dtf.format(dateObj);
							String NumeroReserva = "HA" + prueba + String.valueOf(numeroReserva);
														
							FormularioRegistroHuesped formularioRegistroHuesped = new FormularioRegistroHuesped(FechaCheckInConvertidad, FechaCheckOutConvertidad, ValorReserva, FormaPago, NumeroReserva);
							formularioRegistroHuesped.setVisible(true);
							dispose();
							
							
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						botonReservas.setBackground(Color.lightGray);
						
					}			
					@Override
					public void mouseExited(MouseEvent e) {
						botonReservas.setBackground(Color.white);
						
					}
					
				});
		
		final JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(180, 455, 120, 35);
		panelbotones.add(botonCancelar);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonCancelar.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						FormularioAdmin formularioAdmin = new FormularioAdmin();
						formularioAdmin.setVisible(true);
						dispose();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						botonCancelar.setBackground(Color.lightGray);
						
					}			
					@Override
					public void mouseExited(MouseEvent e) {
						botonCancelar.setBackground(Color.white);
						
					}
					
				});
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
