package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logica.Login;

public class FormularioLogin extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	
	
	public FormularioLogin () {
		
// se establecen los parametros del formulario
        
        setTitle("LOGIN HOTEL ALURA");       // establecemos el titulo dela ventana
        
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso no hace nada
		setIconImage(Toolkit.getDefaultToolkit().getImage(Formulario.class.getResource("/IMG/aH-40px.png"))); // aqui se coloca una imagen en el titulo
		setBounds(100, 100, 788, 527);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso salir(null);             // con este comando se coloca en el centro la ventana
		setResizable(false);
		setLayout(null);                         // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
        
        
       iniciarComponentes();
	}
	
	
	public void iniciarComponentes( ) {
		
		contentPane = new JPanel(); // se crea un panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // se le añaden bordes en las 4 esquinas
		setContentPane(contentPane); //se coloca el panel sobre el elemento ppal que es el frame
		contentPane.setLayout(null); // se deja nulo el layout  para colocar las cosas en la posicion que deseamos
		setLocationRelativeTo(null); // establece la posicion relativa a un componente, si se pasa null se ubica en el centro
		
		JPanel panelImg = new JPanel();  // creo un panel
		panelImg.setBounds(0, 0, 394, 527); // establesco la posicion de inicio asi como las coordenadas finales
		panelImg.setBackground(Color.WHITE);  // establesco el color del panel
		contentPane.add(panelImg); //adiciono este nuevo panel al panel anterior
		panelImg.setLayout(null); // se deja nulo el layout  para colocar las cosas en la posicion que deseamos
		
		JLabel imgHotel = new JLabel("");
		imgHotel.setBounds(50, -90, 394, 527);
		panelImg.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(FormularioLogin.class.getResource("/IMG/img-hotel-login-.png")));
		
		
		
		JPanel panelDatos = new JPanel();
		//panelDatos.setBackground(Color.ORANGE);
		panelDatos.setBounds(394, 0, 394, 527);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FormularioLogin.class.getResource("/IMG/Ha-100px.png")));
		lblNewLabel_1.setBounds(135, 45, 102, 102);
		panelDatos.add(lblNewLabel_1);
		
		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(65, 169, 107, 26); panelDatos.add(LabelUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setForeground(Color.black);
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 206, 254, 42); panelDatos.add(txtUsuario);
		txtUsuario.setColumns(10);
		
				
		txtUsuario.addMouseListener(new MouseAdapter() {

			@Override public void mousePressed(MouseEvent e) {
				if(txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
					}
				if(String.valueOf(txtContrasena.getPassword()).isEmpty()) {
					txtContrasena.setText("********");
					txtContrasena.setForeground(Color.gray);
					}
				}
			});
		 
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(SystemColor.textInactiveText);
		lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasea.setBounds(65, 278, 157, 26); panelDatos.add(lblContrasea);
		
		
		txtContrasena = new JPasswordField();
		txtContrasena.setText("********");
		txtContrasena.setForeground(Color.black);
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setBounds(65, 318, 254, 42);
		panelDatos.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) {
				if(String.valueOf(txtContrasena.getPassword()).equals("********")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
					}
				if(txtUsuario.getText().isEmpty()) {
						txtUsuario.setText("Ingrese su nombre de usuario");
						txtUsuario.setForeground(Color.gray);
						}
					}
			});
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(65, 388, 107, 42);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelDatos.add(btnLogin);
		
		btnLogin.addMouseListener(new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent e) {
				
				String valorPass = new String(txtContrasena.getPassword());
				String usuario = txtUsuario.getText();
								
				if(usuario.length() == 0 || valorPass.length() == 0 ||
						usuario.equals("Ingrese su nombre de usuario") || valorPass.equals("********")) {
					
					JOptionPane.showConfirmDialog(null, "El usuario y/o contraseña no pueden estar vacios",
			                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
			                JOptionPane.INFORMATION_MESSAGE);
					
					}else {
						
						Login login = new Login();
						if(login.comprobar(usuario, usuario)) {
							
							FormularioAdmin formularioAdmin = new FormularioAdmin();
							formularioAdmin.setVisible(true);
							dispose();
						}
					}
			}

			@Override public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(Color.LIGHT_GRAY);

			}

			@Override public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(12, 138, 199));

			}
		});
		
		
		final JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(214, 388, 107, 42);
		btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelDatos.add(btnCancel);
		
		btnCancel.addMouseListener(new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent e) {
				
				Formulario formulario = new Formulario();
				formulario.setVisible(true);
				dispose();
				
			}

			@Override public void mouseEntered(MouseEvent e) {
				btnCancel.setBackground(Color.LIGHT_GRAY);

			}

			@Override public void mouseExited(MouseEvent e) {
				btnCancel.setBackground(new Color(12, 138, 199));

			}
		});
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
