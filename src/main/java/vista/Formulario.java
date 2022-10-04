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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Formulario extends JFrame implements ActionListener {
	
	
	JPanel contentPane;
	
	public Formulario()
    {
        // se establecen los parametros del formulario
        
        setTitle("HOTEL ALURA");       // establecemos el titulo dela ventana
        
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso no hace nada
		setIconImage(Toolkit.getDefaultToolkit().getImage(Formulario.class.getResource("/IMG/aH-40px.png"))); // aqui se coloca una imagen en el titulo
		setBounds(100, 100, 910, 537);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso salir(null);             // con este comando se coloca en el centro la ventana
        setLayout(null);                         // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
        
        
       iniciarComponentes();
        
        
    }
	
	public void iniciarComponentes( ) {
		
		contentPane = new JPanel(); // crea un nuevo panel
		contentPane.setLayout(null); // con este comando deshabilitamos el layout del form, es decir que podemos colocar los elementos donde queramos
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // genera bordes en el panel
		setContentPane(contentPane);
		contentPane.setBounds(0, 0, 910, 537);
		contentPane.setBackground(SystemColor.control);
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setUndecorated(true); esto quita la barra de titulo
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(SystemColor.control);
		panelImagen.setBounds(0, 0, 712, 537);
		//panelImagen.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3)); // para colocarle un borde al panel y ver donde termina
		contentPane.add(panelImagen);
		panelImagen.setLayout(null);
		  
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBackground(SystemColor.control);
		imagenFondo.setBounds(0, 0, 712, 537);
		imagenFondo.setIcon(new ImageIcon(Formulario.class.getResource("/IMG/menu-img.png")));
		panelImagen.add(imagenFondo);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(SystemColor.control);
		panelLogin.setBounds(712, 0, 910, 537);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(45, 60, 102, 102);
		//logo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		logo.setIcon(new ImageIcon(Formulario.class.getResource("/IMG/Ha-100px.png")));
		panelLogin.add(logo);
		
		final JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(70, 205, 100, 35);
		labelLogin.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelLogin.setFont(new Font("Serif", Font.PLAIN, 24)); // asi se configura tipo de letra tamaño
		panelLogin.add(labelLogin);
		
		
		final JButton botonLogin = new JButton();
		botonLogin.setBounds(55, 280, 68, 68);
		botonLogin.setIcon(new ImageIcon(Formulario.class.getResource("/IMG/login.png")));
		botonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelLogin.add(botonLogin);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonLogin.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FormularioLogin formularioLogin = new FormularioLogin();
				formularioLogin.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				botonLogin.setBackground(Color.lightGray);
				labelLogin.setForeground(Color.blue);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonLogin.setBackground(Color.white);
				//labelLogin.setForeground(Color.white);
			}
			
		});
		
		final JButton botonCerrarSesion = new JButton();
		botonCerrarSesion.setBounds(120, 420, 50, 50);
		botonCerrarSesion.setIcon(new ImageIcon(Formulario.class.getResource("/IMG/cerrar-sesion.png")));
		botonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelLogin.add(botonCerrarSesion);
		
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
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						botonCerrarSesion.setBackground(Color.white);
						//labelLogin.setForeground(Color.white);
					}
					
				});
		
		//add(contentPane);
		
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
