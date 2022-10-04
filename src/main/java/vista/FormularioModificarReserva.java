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
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Logica.Catalogo;
import Logica.Reserva;
import Logica.convertirFecha;
import Persistencia.DAOReserva;

public class FormularioModificarReserva extends JFrame implements ActionListener {
	
	
	private JPanel contentPane;
	private String fechaCheckIn;
	private String fechaCkeckOut;
	private double valorReserva;
	private String formaPago;
	private String numeroReserva;
	private Reserva reserva;
	JButton btnCancelar, btnGuardar;
	JTextField txtNombre, txtApellido, txtTelefono, txtNumeroReserva, txtValorReserva, txtId;
	JDateChooser txtFechaNacimiento, txtFechaCheckIn, txtFechaCheckOut;
	Date fechaCheckInAux, fechaCheckOutAux, fechaNacimientoAux;
	convertirFecha conversorFecha = new convertirFecha();
	long resultado;
	
	public FormularioModificarReserva (Reserva reserva) { //Reserva reserva
		
		this.reserva = reserva;		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioModificarReserva.class.getResource("/IMG/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		
		Panel panelRegistro = new Panel();
		panelRegistro.setBackground(SystemColor.control);
		panelRegistro.setBounds(0, 0, 944, 609);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(10, 10, 105, 105);
		panelRegistro.add(labelLogo);
		labelLogo.setIcon(new ImageIcon(FormularioModificarReserva.class.getResource("/IMG/Ha-100px.png")));
			
		JLabel labelNumeroReserva = new JLabel("Numero reserva");
		labelNumeroReserva.setBounds(50, 130, 250, 30);
		labelNumeroReserva.setFont(new Font("Roboto", Font.BOLD, 20));
		labelNumeroReserva.setForeground(new Color(12, 138,199));
		panelRegistro.add(labelNumeroReserva);
		
		txtNumeroReserva = new JTextField();
		txtNumeroReserva.setBounds(50, 170, 250, 35);
		txtNumeroReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtNumeroReserva.setEnabled(false);
		txtNumeroReserva.setText(reserva.getNumeroReserva());
		panelRegistro.add(txtNumeroReserva);
		
		JLabel labelValorReserva = new JLabel("Valor de la Reserva");
		labelValorReserva.setBounds(330, 130, 250, 30);
		labelValorReserva.setForeground(new Color(12, 138,199)); // aqui coloco el color de la letra
		labelValorReserva.setFont(new Font("Roboto", Font.BOLD, 20)); // asi se configura tipo de letra tamaño
		panelRegistro.add(labelValorReserva);
		
		txtValorReserva = new JTextField();
		txtValorReserva.setBounds(330, 170, 250, 35);
		txtValorReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValorReserva.setEditable(false);
		txtValorReserva.setText(String.valueOf(reserva.getValorReserva()));
		panelRegistro.add(txtValorReserva);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(600, 130, 250, 30);
		labelNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelNombre.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(600, 170, 250, 35);
		txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtNombre.setText(String.valueOf(reserva.getNombre()));
		panelRegistro.add(txtNombre);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(50, 245, 250, 30);
		labelApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelApellido.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelApellido);
		 
		txtApellido = new JTextField();
		txtApellido.setBounds(50, 285, 250, 35);
		txtApellido.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtApellido.setText(String.valueOf(reserva.getApellido()));
		panelRegistro.add(txtApellido);
		
		JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
		labelFechaNacimiento.setBounds(330, 245, 250, 30);
		labelFechaNacimiento.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelFechaNacimiento.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelFechaNacimiento);
		
		txtFechaNacimiento = new JDateChooser();
		txtFechaNacimiento.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaNacimiento.getCalendarButton().setIcon(new ImageIcon(FormularioModificarReserva.class.getResource("/IMG/icon-reservas.png")));
		txtFechaNacimiento.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaNacimiento.setBounds(330, 285, 250, 35);
		
		fechaNacimientoAux =  conversorFecha.convertirStringAfecha(reserva.getFechaNacimiento());
				 
		//System.out.println(fechaNacimientoAux);

		txtFechaNacimiento.setDate(fechaNacimientoAux);
		panelRegistro.add(txtFechaNacimiento);
		
		JLabel labelNacionalidad = new JLabel("Nacionalidad");
		labelNacionalidad.setBounds(600, 245, 250, 30);
		labelNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelNacionalidad.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelNacionalidad);
		
		final JComboBox txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(600, 285, 250, 35);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		txtNacionalidad.setSelectedItem(reserva.getNacionalidad());
		panelRegistro.add(txtNacionalidad);
		
		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(50, 340, 250, 30);
		labelTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelTelefono.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelTelefono);
		 
		txtTelefono = new JTextField();
		txtTelefono.setBounds(50, 380, 250, 35);
		txtTelefono.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtTelefono.setText(String.valueOf(reserva.getTelefono()));
		panelRegistro.add(txtTelefono);
		
		JLabel labelCheckin = new JLabel("Fecha de Check In");
		labelCheckin.setBounds(330, 340, 250, 30);
		labelCheckin.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelCheckin.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelRegistro.add(labelCheckin);
		
		txtFechaCheckIn = new JDateChooser();
		txtFechaCheckIn.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaCheckIn.getCalendarButton().setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/icon-reservas.png")));
		txtFechaCheckIn.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFechaCheckIn.setBounds(330, 380, 250, 35);
		
		
		fechaCheckInAux = conversorFecha.convertirStringAfecha(reserva.getFechaCheckIn()); 
		//System.out.println(fechaCheckInAux);
		
		txtFechaCheckIn.setDate(fechaCheckInAux);
		panelRegistro.add(txtFechaCheckIn);
		
		final JLabel labelCheckOut = new JLabel("Fecha de Check Out");
		labelCheckOut.setBounds(600, 340, 250, 30);
		labelCheckOut.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelCheckOut.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelRegistro.add(labelCheckOut);
		
		txtFechaCheckOut = new JDateChooser();
		txtFechaCheckOut.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaCheckOut.getCalendarButton().setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/icon-reservas.png")));
		txtFechaCheckOut.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 14));
		txtFechaCheckOut.setBounds(600, 380, 250, 35);
		
		
		fechaCheckOutAux = conversorFecha.convertirStringAfecha(reserva.getFechaCheckOut()); 
		//System.out.println(fechaCheckOutAux);
			
		
		txtFechaCheckOut.setDate(fechaCheckOutAux);
		panelRegistro.add(txtFechaCheckOut);
		
		JLabel labelFormaPago = new JLabel("Forma de Pago");
		labelFormaPago.setBounds(50, 435, 250, 30);
		labelFormaPago.setForeground(Color.BLACK); // aqui coloco el color de la letra
		labelFormaPago.setFont(new Font("Serif", Font.PLAIN, 18)); // asi se configura tipo de letra tamaño
		panelRegistro.add(labelFormaPago);
		
		final JComboBox txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(50, 475, 250, 35);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta Credito", "Tarjeta Debito", "Dinero en efectivo"}));
		txtFormaPago.setSelectedItem(reserva.getFormaPago());
		panelRegistro.add(txtFormaPago);
		
		txtId = new JTextField();
		txtId.setBounds(50, 520, 250, 35);
		txtId.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtId.setText(String.valueOf(reserva.getIdtreservas()));
		panelRegistro.add(txtId);
		
		btnGuardar = new JButton();
		btnGuardar.setBounds(450, 520, 40, 40);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnGuardar.setIcon(new ImageIcon(FormularioModificarReserva.class.getResource("/IMG/disquete.png")));
		panelRegistro.add(btnGuardar);
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen y abre la pantalla con todos los datos de la reserva seleccionada
		btnGuardar.addMouseListener(new MouseAdapter() {
									
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(txtFechaCheckIn.getDate() == null || txtFechaCheckOut.getDate() == null || txtNombre.getText().equals("")
								|| txtApellido.getText().equals("") || txtNacionalidad.getSelectedItem().equals("")
								|| txtTelefono.getText().equals("") || txtFormaPago.getSelectedItem().equals("") ||
								txtFechaNacimiento.getDate() == null)
								 {
							
							JOptionPane.showConfirmDialog(null, "todos los campos deben ser diligenciados",
					                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
					                JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							
							// tomo los campos de fecha que vienen en el format dd/MM/yyyy y los paso a yyyy-MM-dd que es como se requiere en la base de datos
							
							Date DateFechaCheckIn = txtFechaCheckIn.getDate();
							Date DateFechaCheckOut = txtFechaCheckOut.getDate();
							Date DateFechaNacimiento = txtFechaCheckOut.getDate();
												
							String FechaCheckInConvertidad = conversorFecha.convertiFecha(DateFechaCheckIn);
							String FechaCheckOutConvertidad = conversorFecha.convertiFecha(DateFechaCheckOut);
							String FechaNacimientoConvertidad = conversorFecha.convertiFecha(DateFechaNacimiento);
														
							// convierto el valor del campo en un double.
							
							long fecha1 = 	DateFechaCheckIn.getTime();
							System.out.println("dias: " + fecha1);
							long fecha2 = DateFechaCheckOut.getTime();
							System.out.println("dias: " + fecha2);
							resultado = (fecha2 - fecha1)/86400000; //el valor se obtiene en milisegundos, con el valor de abajo corresponde a un dia en millisegundos)

							System.out.println(resultado);

							if(resultado <1) {

								JOptionPane.showConfirmDialog(null, "la fecha de Check Out no puede ser igual o menor que la Fecha de Check In",
										"CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
										JOptionPane.INFORMATION_MESSAGE);

								txtValorReserva.setText("0");
								resultado = 0;
								
								} else {
									
									System.out.println(FormularioReserva.valorNoche);
									String valor = String.valueOf(resultado*FormularioReserva.valorNoche);
									//System.out.println(valor);
									txtValorReserva.setText(valor);

										}

													
							int idtreservas = Integer.parseInt(txtId.getText());
							String Nombre = txtNombre.getText();
							String Apellido = txtApellido.getText();
							String Nacionalidad = String.valueOf(txtNacionalidad.getSelectedItem());
							double valorReserva = Double.parseDouble(txtValorReserva.getText());
							String formaPago = String.valueOf(txtFormaPago.getSelectedItem());
							String Telefono = txtTelefono.getText();
							String numeroReserva = txtNumeroReserva.getText();
							
							
							Reserva r = new Reserva(idtreservas, FechaCheckInConvertidad, FechaCheckOutConvertidad, valorReserva, formaPago, Nombre, Apellido,
									FechaCheckInConvertidad, Nacionalidad, Telefono, numeroReserva);
							
							
					
							Catalogo catalogo = new Catalogo();
							if(catalogo.actualizarReserva(idtreservas, r)) {
								
								//System.out.println("exito");
								Icon icon = new ImageIcon(FormularioModificarReserva.class.getResource("/IMG/lOGO-50PX.png"));
								int respuesta = JOptionPane.showConfirmDialog(null, "Datos guardados correctamente",
										"Mensaje de confirmacion", JOptionPane.CLOSED_OPTION,
										JOptionPane.INFORMATION_MESSAGE,icon);
									if(respuesta == 0) {
									        FormularioAdmin f = new FormularioAdmin();
									        f.setVisible(true);
									        dispose();
										        }
								
								
							}else {
								
								System.out.println("no exitoso");
							}
					 
						}
							
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						btnGuardar.setBackground(Color.lightGray);
						//labelExit.setForeground(Color.white);
					}			
					@Override
					public void mouseExited(MouseEvent e) {
						btnGuardar.setBackground(Color.white);
					     //labelExit.setForeground(Color.black);
					}
									
					});
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(510, 520, 40, 40);
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(FormularioModificarReserva.class.getResource("/IMG/cancelar.png")));
		panelRegistro.add(btnCancelar);
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de cierra la pantalla cancelando la operacion
		btnCancelar.addMouseListener(new MouseAdapter() {
											
							@Override
							public void mouseClicked(MouseEvent e) {
								
								FormularioBusquedad formularioBusquedad = new FormularioBusquedad();
								formularioBusquedad.setVisible(true);
								dispose();
									}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								btnCancelar.setBackground(Color.lightGray);
								//labelExit.setForeground(Color.white);
							}			
							@Override
							public void mouseExited(MouseEvent e) {
								btnCancelar.setBackground(Color.white);
							     //labelExit.setForeground(Color.black);
							}
											
							});
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
