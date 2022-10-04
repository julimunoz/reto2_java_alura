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
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormularioAdmin extends JFrame implements ActionListener {
	
	
	JPanel contentPane;
	
	public FormularioAdmin()
    {
        // se establecen los parametros del formulario
        
        setTitle("HOTEL ALURA");       // establecemos el titulo dela ventana
        
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso no hace nada
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioAdmin.class.getResource("/IMG/aH-40px.png"))); // aqui se coloca una imagen en el titulo
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
		panelImg.setBounds(0, 0, 685, 537);
		contentPane.add(panelImg);
		//panelImg.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		panelImg.setLayout(null);
		  
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(-30, 0, 712, 537);
		imagenFondo.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/menu-img.png")));
		panelImg.add(imagenFondo);
		
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(SystemColor.lightGray);
		panelbotones.setBounds(683, 0, 910, 537);
		contentPane.add(panelbotones);
		panelbotones.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(30, 20, 150, 156);
		logo.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/Imagen_hotel.png")));
		panelbotones.add(logo);
		
		final JLabel labelReservas = new JLabel("Reservas");
		labelReservas.setBounds(60, 180, 100, 30);
		labelReservas.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelReservas.setFont(new Font("Serif", Font.PLAIN, 24)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelReservas);
		
		final JButton botonReservas = new JButton();
		botonReservas.setBounds(72, 220, 65, 65);
		botonReservas.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/reservas.png")));
		panelbotones.add(botonReservas);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonReservas.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						    FormularioReserva formularioReserva = new FormularioReserva();
						    formularioReserva.setVisible(true);
						    dispose();
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						botonReservas.setBackground(Color.lightGray);
						labelReservas.setForeground(Color.blue);
					}			
					@Override
					public void mouseExited(MouseEvent e) {
						botonReservas.setBackground(Color.white);
						labelReservas.setForeground(Color.black);
					}
					
				});
		
		final JLabel labelBusquedad = new JLabel("Busquedad");
		labelBusquedad.setBounds(55, 300, 130, 30);
		labelBusquedad.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelBusquedad.setFont(new Font("Serif", Font.PLAIN, 24)); // asi se configura tipo de letra tamaño
		panelbotones.add(labelBusquedad);
		
		
		final JButton botonbusquedas = new JButton();
		botonbusquedas.setBounds(72, 340, 65, 65);
		botonbusquedas.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/lupa-1.png")));
		panelbotones.add(botonbusquedas);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonbusquedas.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				FormularioBusquedad formularioBusquedad = new FormularioBusquedad();
				formularioBusquedad.setVisible(true);
			    dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonbusquedas.setBackground(Color.lightGray);
				labelBusquedad.setForeground(Color.blue);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonbusquedas.setBackground(Color.white);
				labelBusquedad.setForeground(Color.black);
			}

		});
		
	
		
		final JButton botonCerrarSesion = new JButton();
		botonCerrarSesion.setBounds(160, 450, 35, 35);
		botonCerrarSesion.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/cerrar-sesion.png")));
		botonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelbotones.add(botonCerrarSesion);
		
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
