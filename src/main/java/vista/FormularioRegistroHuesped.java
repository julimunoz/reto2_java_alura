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

import com.toedter.calendar.JDateChooser;

import Logica.Catalogo;
import Logica.Reserva;
import Logica.convertirFecha;
import Persistencia.DAOReserva;

public class FormularioRegistroHuesped extends JFrame implements ActionListener {
	
	
	private JPanel contentPane;
	private String fechaCheckIn;
	private String fechaCkeckOut;
	private double valorReserva;
	private String formaPago;
	private String numeroReserva;
	
	public FormularioRegistroHuesped (final String fechaCheckIn, final String fechaCkeckOut, final double valorReserva, final String formaPago, final String numeroReserva) {
		
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCkeckOut = fechaCkeckOut;
		this.valorReserva = valorReserva;
		this.formaPago = formaPago;
		this.numeroReserva = numeroReserva;
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioRegistroHuesped.class.getResource("/IMG/aH-40px.png")));
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
		
		JPanel panelImg = new JPanel();
		panelImg.setBounds(0, 0, 477, 609);
		panelImg.setBackground(SystemColor.control);
		contentPane.add(panelImg);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(0, 0, 477, 609);
		panelImg.add(labelImagen);
		labelImagen.setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/registro.png")));
		
		Panel panelRegistro = new Panel();
		panelRegistro.setBackground(SystemColor.control);
		panelRegistro.setBounds(477, 0, 944, 609);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(340, 5, 130, 100);
		panelRegistro.add(labelLogo);
		labelLogo.setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/Ha-100px.png")));
		
		JLabel labelTitulo = new JLabel("Registro Huesped");
		labelTitulo.setBounds(130, 15, 250, 30);
		labelTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		labelTitulo.setForeground(new Color(12, 138,199));
		panelRegistro.add(labelTitulo);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(60, 55, 100, 30);
		labelNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelNombre.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelNombre);
		 
		final JTextField txtNombre = new JTextField();
		txtNombre.setBounds(60, 90, 245, 35);
		txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 17));
		panelRegistro.add(txtNombre);
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(60, 130, 235, 30);
		labelApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelApellido.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelApellido);
		 
		final JTextField txtApellido = new JTextField();
		txtApellido.setBounds(60, 165, 245, 35);
		txtApellido.setFont(new Font("Roboto Black", Font.BOLD, 17));
		panelRegistro.add(txtApellido);
		
		JLabel labelFechaNacimiento = new JLabel("Fecha Nacimiento");
		labelFechaNacimiento.setBounds(60, 205, 235, 30);
		labelFechaNacimiento.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelFechaNacimiento.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelFechaNacimiento);
		
		final JDateChooser txtFechaNacimiento = new JDateChooser();
		txtFechaNacimiento.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaNacimiento.getCalendarButton().setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/icon-reservas.png")));
		txtFechaNacimiento.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaNacimiento.setBounds(60, 240, 245, 35);
		panelRegistro.add(txtFechaNacimiento);
		
		JLabel labelNacionalidad = new JLabel("Nacionalidad");
		labelNacionalidad.setBounds(60, 280, 235, 30);
		labelNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelNacionalidad.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelNacionalidad);
		
		final JComboBox txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(60, 315, 245, 35);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		panelRegistro.add(txtNacionalidad);
		
		JLabel labelTelefono = new JLabel("Telefono");
		labelTelefono.setBounds(60, 355, 235, 30);
		labelTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelTelefono.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelTelefono);
		 
		final JTextField txtTelefono = new JTextField();
		txtTelefono.setBounds(60, 390, 245, 35);
		txtTelefono.setFont(new Font("Roboto Black", Font.BOLD, 17));
		panelRegistro.add(txtTelefono);
		
		JLabel labelNumeroReserva = new JLabel("Numero de Reserva");
		labelNumeroReserva.setBounds(60, 430, 235, 30);
		labelNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		labelNumeroReserva.setForeground(SystemColor.textInactiveText);
		panelRegistro.add(labelNumeroReserva);
		 
		final JTextField txtNumeroReserva = new JTextField();
		txtNumeroReserva.setBounds(60, 470, 245, 35);
		txtNumeroReserva.setEditable(false);
		txtNumeroReserva.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtNumeroReserva.setText(numeroReserva);
		panelRegistro.add(txtNumeroReserva);
		
		final JButton btnContinuar = new JButton();
		btnContinuar.setBounds(310, 520, 40, 40);
		btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnContinuar.setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/disquete.png")));
		panelRegistro.add(btnContinuar);
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de cerrar sesion y lleva a un cuadro de confirmacion
		btnContinuar.addMouseListener(new MouseAdapter() {
									
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtFechaNacimiento.getDate() == null ||
								txtTelefono.getText().equals("") || txtNumeroReserva.getText().equals("") ) {
							
							JOptionPane.showConfirmDialog(null, "todos los campos deben ser diligenciados",
					                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
					                JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							
							Date DateFechaNacimiento = txtFechaNacimiento.getDate();
							
							convertirFecha conversorFecha = new convertirFecha();
							
							String FechaCheckInConvertidad = conversorFecha.convertiFecha(DateFechaNacimiento);
													
							String Name = txtNombre.getText();
							String Apellido = txtApellido.getText();
							String Nacionalidad = String.valueOf(txtNacionalidad.getSelectedItem());
							String Telefono = txtTelefono.getText();
							
							Reserva r = new Reserva(fechaCheckIn, fechaCkeckOut, valorReserva, formaPago, Name, Apellido,
									FechaCheckInConvertidad, Nacionalidad, Telefono, numeroReserva);
							
							
					
							Catalogo catalogo = new Catalogo();
							if(catalogo.guardarProductos(r)) {
								
								//System.out.println("exito");
								Icon icon = new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/lOGO-50PX.png"));
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
						btnContinuar.setBackground(Color.lightGray);
						//labelExit.setForeground(Color.white);
					}			
					@Override
					public void mouseExited(MouseEvent e) {
						btnContinuar.setBackground(Color.white);
					     //labelExit.setForeground(Color.black);
					}
									
					});
		
		final JButton btnCancelar = new JButton();
		btnCancelar.setBounds(355, 520, 40, 40);
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(FormularioRegistroHuesped.class.getResource("/IMG/cancelar.png")));
		panelRegistro.add(btnCancelar);
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de cerrar sesion y lleva a un cuadro de confirmacion
		btnCancelar.addMouseListener(new MouseAdapter() {
											
							@Override
							public void mouseClicked(MouseEvent e) {
								
								FormularioAdmin formularioAdmin = new FormularioAdmin();
								formularioAdmin.setVisible(true);
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
		
		final JButton botonCerrarSesion = new JButton("");
		botonCerrarSesion.setBounds(400, 520, 40, 40);
		botonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonCerrarSesion.setIcon(new ImageIcon(Formulario.class.getResource("/IMG/cerrar-sesion.png")));
		panelRegistro.add(botonCerrarSesion);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de cerrar sesion y lleva a un cuadro de confirmacion
		botonCerrarSesion.addMouseListener(new MouseAdapter() {
							
			@Override
			public void mouseClicked(MouseEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea salir de la aplicacion",
						"Mensaje de confirmacion", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
					if(respuesta == 0) {
					        System.exit(0);
						        }
					}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				botonCerrarSesion.setBackground(Color.lightGray);
				//labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonCerrarSesion.setBackground(Color.white);
			     //labelExit.setForeground(Color.black);
			}
							
			});
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
