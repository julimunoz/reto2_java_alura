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
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Logica.Catalogo;
import Logica.Reserva;
import Logica.convertirFecha;



public class FormularioBusquedad extends JFrame implements ActionListener {
	
	
	JPanel contentPane;	
	JTextField txtTextoABuscar;
	JTable tbReservas, tbClientes;
	JTabbedPane panel;
	JComboBox txtCriterioBusquedadCliente, txtCriterioBusquedadReserva;
	int itemSeleccionadoReserva = 0; // se ponen en cero ya que el listener del JCombobox en para cuando cambia de valor y como cambio el valor al cambiar de este modo garantizo que tenga un valor
	int itemSeleccionadoCliente = 0;
	int pestanaSeleccionada = 0;
	int filaseleccionada = -1; // se inicializa en -1, porque la primera fila es la 0, para que no de error y deba ser cambiada cuando se seleccione una fila
	Catalogo c = new Catalogo();// creo un objwto de la clase catalogo para poder usar sus metodos
	Reserva reservaEditar = new Reserva();
	
	public FormularioBusquedad()
    {
        // se establecen los parametros del formulario
        
        setTitle("HOTEL ALURA");       // establecemos el titulo dela ventana
        
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // establecemos que hace cuando se presiona la x delaventana, en este caso no hace nada
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioBusquedad.class.getResource("/IMG/aH-40px.png"))); // aqui se coloca una imagen en el titulo
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
		
		
		
		//panel para ubicar los criterios de busquedad
		
		JPanel panelbusquedad = new JPanel();
		panelbusquedad.setBackground(SystemColor.lightGray);
		panelbusquedad.setBounds(0, 0, 910, 150);
		contentPane.add(panelbusquedad);
		//panelbusquedad.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		panelbusquedad.setLayout(null);
		
		JLabel imagenLogo = new JLabel("");
		imagenLogo.setBounds(20, 20, 102, 102);
		imagenLogo.setIcon(new ImageIcon(FormularioBusquedad.class.getResource("/IMG/Ha-100px.png")));
		panelbusquedad.add(imagenLogo);
		
		JLabel labelTitulo = new JLabel("Pagina de Busquedas");
		labelTitulo.setBounds(352, 20, 250, 30);
		labelTitulo.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelTitulo.setFont(new Font("Serif", Font.PLAIN, 24)); // asi se configura tipo de letra tamaño
		panelbusquedad.add(labelTitulo);
		
		JLabel labelDescripcion = new JLabel("seleccione el criterio de busquedad, ingrese el valor y presiones buscar");
		labelDescripcion.setBounds(250, 50, 450, 30);
		labelDescripcion.setForeground(Color.BLUE); // aqui coloco el color de la letra
		labelDescripcion.setFont(new Font("Serif", Font.PLAIN, 14)); // asi se configura tipo de letra tamaño
		panelbusquedad.add(labelDescripcion);
		
		txtTextoABuscar = new JTextField();
		txtTextoABuscar.setBounds(200, 100, 200, 35);
		txtTextoABuscar.setFont(new Font("Roboto Black", Font.BOLD, 17));
		panelbusquedad.add(txtTextoABuscar);
		
		txtCriterioBusquedadReserva = new JComboBox();
		txtCriterioBusquedadReserva.setBounds(450, 100, 200, 35);
		txtCriterioBusquedadReserva.setBackground(SystemColor.text);
		txtCriterioBusquedadReserva.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtCriterioBusquedadReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtCriterioBusquedadReserva.setModel(new DefaultComboBoxModel(new String[] {"Fecha de Check In", "Fecha de Check Out", "Valor de Reserva", "Forma de Pago", "Numero de Reserva"}));
		txtCriterioBusquedadReserva.setVisible(false);
		panelbusquedad.add(txtCriterioBusquedadReserva);
		txtCriterioBusquedadReserva.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				itemSeleccionadoReserva = txtCriterioBusquedadReserva.getSelectedIndex();
				System.out.println(itemSeleccionadoReserva);
				
			}
		});
		
		txtCriterioBusquedadCliente = new JComboBox();
		txtCriterioBusquedadCliente.setBounds(450, 100, 200, 35);
		txtCriterioBusquedadCliente.setBackground(SystemColor.text);
		txtCriterioBusquedadCliente.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtCriterioBusquedadCliente.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtCriterioBusquedadCliente.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellido", "fecha Nacimiento", "Nacionalidad", "Telefono"}));
		txtCriterioBusquedadCliente.setVisible(false);
		panelbusquedad.add(txtCriterioBusquedadCliente);
		txtCriterioBusquedadCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				itemSeleccionadoCliente = txtCriterioBusquedadCliente.getSelectedIndex();
				System.out.println(itemSeleccionadoCliente);
				
			}
		});
		
		final JButton botonbusquedas = new JButton();
		botonbusquedas.setBounds(680, 100, 35, 35);
		botonbusquedas.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/lupa-1.png")));
		panelbusquedad.add(botonbusquedas);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonbusquedas.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtTextoABuscar.getText().equals("")) {
					
					JOptionPane.showConfirmDialog(null, "el campo de busquedad no puede estar vacio",
			                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
			                JOptionPane.INFORMATION_MESSAGE);
				} else {
					
					if(pestanaSeleccionada == 0) {
					ActualizarTablaReservasFiltrada();
				}else {
					ActualizarTablaClientesFiltrada();
				}
			}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonbusquedas.setBackground(Color.lightGray);
				
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonbusquedas.setBackground(Color.white);
				
			}

		});
		
		//panel para ubicar el JTabpanel
		
		JPanel panelRegistros = new JPanel();
		panelRegistros.setBackground(SystemColor.lightGray);
		panelRegistros.setBounds(0, 150, 910, 287);
		contentPane.add(panelRegistros);
		//panelRegistros.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
		panelRegistros.setLayout(null);
		
		
		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(10, 10, 875, 267);
		panelRegistros.add(panel);
		
		
		// aqui adiciono un listener para saber que pestaña esta activa
		panel.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				pestanaSeleccionada = panel.getSelectedIndex();
				//System.out.println("pestaña: " + pestanaSeleccionada);
				if(pestanaSeleccionada == 0) {
					
					txtCriterioBusquedadCliente.setVisible(false);
					txtCriterioBusquedadReserva.setVisible(true);
					
				} else {
					txtCriterioBusquedadCliente.setVisible(true);
					txtCriterioBusquedadReserva.setVisible(false);
				}
				
			}
		});
		
		//aqui creo la tabla para traer los datos de las reservas
		
		cargarDatosTabla();	
		
		//panel para colocar los botones de la parte inferior del formulario para realizar el CRUD
		
		JPanel panelIconos = new JPanel();
		panelIconos.setBackground(SystemColor.lightGray);
		panelIconos.setBounds(0, 400, 910, 100);
		contentPane.add(panelIconos);
		//panelIconos.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
		panelIconos.setLayout(null);
		
		final JButton botonEditar = new JButton();
		botonEditar.setBounds(680, 50, 35, 35);
		botonEditar.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/editar-texto.png")));
		panelIconos.add(botonEditar);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonEditar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				filaseleccionada = tbReservas.getSelectedRow(); // se guarda la posicion de la fila seleccionada, inicia en 0
	              System.out.println(filaseleccionada);
	              int valorCasilla = (Integer)(tbReservas.getValueAt(filaseleccionada, 0)); //con este comando traigo el valor de la fila seleccionada y la columna 0, para este caso ese valor corresponde al Id.
	            
				System.out.println(valorCasilla);
				reservaEditar = c.leerReserva(valorCasilla);
				FormularioModificarReserva f = new FormularioModificarReserva(reservaEditar);
				f.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonEditar.setBackground(Color.lightGray);
				
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonEditar.setBackground(Color.white);
				
			}

		});
		
		final JButton botonEliminar = new JButton();
		botonEliminar.setBounds(725, 50, 35, 35);
		botonEliminar.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/deletar.png")));
		panelIconos.add(botonEliminar);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(filaseleccionada == -1) {
					
					JOptionPane.showConfirmDialog(null, "por favor seleccione una fila",
			                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
			                JOptionPane.INFORMATION_MESSAGE);
				}else {
					
					filaseleccionada = tbReservas.getSelectedRow();
					int valorCasilla = (Integer)(tbReservas.getValueAt(filaseleccionada, 0));
					int respuesta = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea borrar el registro con Id: " + (valorCasilla),
							"Mensaje de confirmacion", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
						if(respuesta == 0) {
							boolean Borrado = c.borrarRegistro(valorCasilla);
							
							System.out.println(Borrado);
							if(Borrado == true) {
								
								JOptionPane.showConfirmDialog(null, "se ha eliminado correctamente el registro seleccionado",
						                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
						                JOptionPane.INFORMATION_MESSAGE);
							}else {
								
								JOptionPane.showConfirmDialog(null, "ha ocurrido un error y el registro no pudo ser borrado",
						                "CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
						                JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					
			
			}


			@Override
			public void mouseEntered(MouseEvent e) {
				botonEliminar.setBackground(Color.lightGray);
				
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				botonEliminar.setBackground(Color.white);
				
			}

		});
		
		final JButton botonCancelar = new JButton();
		botonCancelar.setBounds(770, 50, 35, 35);
		botonCancelar.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/cancelar.png")));
		panelIconos.add(botonCancelar);
		
		// aqui se crea un listener del mouse para que detecte cuando se da clik en la imagen de login
		botonCancelar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel.remove(tbReservas);
				panel.remove(tbClientes);
				cargarDatosTabla();
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
		
		final JButton botonCerrarSesion = new JButton();
		botonCerrarSesion.setBounds(845, 50, 35, 35);
		botonCerrarSesion.setIcon(new ImageIcon(FormularioAdmin.class.getResource("/IMG/cerrar-sesion.png")));
		botonCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelIconos.add(botonCerrarSesion);
		
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
			     
			}
							
			});
		
	}
		  
		
	private void cargarDatosTabla() {
		
		Object[][] dataReservas = listarDatosReservas();
        String [] columnNames = {"id","Fecha CheckIn","Fecha CheckOut","Valor de Reserva","Forma de Pago","Numero de Reserva"};
		        DefaultTableModel dtm = new DefaultTableModel(dataReservas,columnNames);
		tbReservas = new JTable(dtm);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/IMG/reservado.png")), tbReservas, null);
		tbReservas.getSelectionModel().addListSelectionListener(new ListSelectionListener() // se agrega escuchador para que detecte la seleccion de una fila
		          {
		             public void valueChanged(ListSelectionEvent e) 
		              {
		              filaseleccionada = tbReservas.getSelectedRow(); // se guarda la posicion de la fila seleccionada, inicia en 0
		              //System.out.println(filaseleccionada);
		              int valorCasilla = (Integer)(tbReservas.getValueAt(filaseleccionada, 0)); //con este comando traigo el valor de la fila seleccionada y la columna 0, para este caso ese valor corresponde al Id.
		              System.out.println(valorCasilla);
		              //puedo variar la columna, en este caso como se que es un entero lo covirtio a entero ya que devuelve un objeto, si
		             //fuera String habria que hacer un cast (Sring)
		             //pasardatoaconsultar(sel);
		            
		              }
		          });
		
		//aqui creo la tabla para traer los datos de los clientes
		
		Object[][] dataClientes = listarDatosClientes();
		String [] columnNamesClientes = {"Nombre"," Apellido","Fecha Ncimiento","Nacionalidad","Telefono"};
		DefaultTableModel dtm2 = new DefaultTableModel(dataClientes,columnNamesClientes);
		tbClientes = new JTable(dtm2);
		tbClientes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Clientes", new ImageIcon(Busqueda.class.getResource("/IMG/pessoas.png")), tbClientes, null);
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//metodo que trae los datos de las reservas para cargarla a la pestaña Reserva
	
	public Object[][] listarDatosReservas()
    {
        //Catalogo c = new Catalogo(); 
        ArrayList<Reserva> Reservas = new ArrayList<Reserva>();
        Reservas = c.listarReservas();
        
        Object[][] data  = new Object[Reservas.size()][6];
        
         for (int i = 0; i < Reservas.size() ; i++)
         {
           data[i][0] =  Reservas.get(i).getIdtreservas();
           data[i][1] =  Reservas.get(i).getFechaCheckIn();
           data[i][2] =  Reservas.get(i).getFechaCheckOut();
           data[i][3] =  Reservas.get(i).getValorReserva();
           data[i][4] =  Reservas.get(i).getFormaPago();
           data[i][5] =  Reservas.get(i).getNumeroReserva();
        }
                 
        return data;
        
    }
	
	//metodo que trae los datos de los clientes para cargarl0s a la pestaña Clientes
	
	public Object[][] listarDatosClientes()
    {
        //Catalogo c = new Catalogo(); 
        ArrayList<Reserva> Reservas = new ArrayList<Reserva>();
        Reservas = c.listarReservas();
        
        Object[][] data  = new Object[Reservas.size()][5];
        
         for (int i = 0; i < Reservas.size() ; i++)
         {
           data[i][0] =  Reservas.get(i).getNombre();
           data[i][1] =  Reservas.get(i).getApellido();
           data[i][2] =  Reservas.get(i).getFechaNacimiento();
           data[i][3] =  Reservas.get(i).getNacionalidad();
           data[i][4] =  Reservas.get(i).getTelefono();
 
        }
                 
        return data;
        
    }
	
	public Object[][] filtrarReservas()
    {
        ArrayList<Reserva> Reservafiltrados = new ArrayList<Reserva>();
        
        
        String busquedad = txtTextoABuscar.getText();
        //itemSeleccionadoReserva = txtCriterioBusquedadCliente.getSelectedIndex();
        
        
        Object[][] data=null;
        //Catalogo c = new Catalogo();
        
        Reservafiltrados = c.filtrarReservas(busquedad, itemSeleccionadoReserva);
        
               
            data  = new Object[Reservafiltrados.size()][6];
            
            for (int i = 0; i < Reservafiltrados.size() ; i++)
             {
               data[i][0] =  Reservafiltrados.get(i).getIdtreservas();
               data[i][1] =  Reservafiltrados.get(i).getFechaCheckIn();
               data[i][2] =  Reservafiltrados.get(i).getFechaCheckOut();
               data[i][3] =  Reservafiltrados.get(i).getValorReserva();
               data[i][4] =  Reservafiltrados.get(i).getFormaPago();
               data[i][5] =  Reservafiltrados.get(i).getNumeroReserva();
               
             }
             
             
        return data;
        
    }
	
	
	
	
	public Object[][] filtrarClientes()
    {
        ArrayList<Reserva> clientesFiltrados = new ArrayList<Reserva>();
        
        
        String busquedad = txtTextoABuscar.getText();
        //itemSeleccionadoCliente = txtCriterioBusquedadCliente.getSelectedIndex();
        
        
        Object[][] data=null;
        //Catalogo c = new Catalogo();
        
        clientesFiltrados = c.filtrarClientes(busquedad, itemSeleccionadoCliente);
        
               
            data  = new Object[clientesFiltrados.size()][6];
            
            for (int i = 0; i < clientesFiltrados.size() ; i++)
             {
               data[i][0] =  clientesFiltrados.get(i).getIdtreservas();
               data[i][1] =  clientesFiltrados.get(i).getNombre();
               data[i][2] =  clientesFiltrados.get(i).getApellido();
               data[i][3] =  clientesFiltrados.get(i).getFechaNacimiento();
               data[i][4] =  clientesFiltrados.get(i).getNacionalidad();
               data[i][5] =  clientesFiltrados.get(i).getTelefono();
               
             }
             
             
        return data;
        
    }
	
	public void ActualizarTablaReservasFiltrada()
    
    {
        Object[][] data = filtrarReservas();
        
        //se usa para si no se ingresan datos a consultar o se ingresa un valor que no se encuentre en la base de datos nos genere 
        //un mensaje y no ejecute el dtm
        
        
        
        if(data.length==0)
        {
            JOptionPane.showMessageDialog(this, "No hay Reservas que cumplan con el filtro registrado");
        }else
        {
        //System.out.println(data.length);
        String [] columnNames = {"id","Fecha CheckIn","Fecha CheckOut","Valor de Reserva","Forma de Pago","Numero de Reserva"};
        DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
        tbReservas.setModel(dtm);
        
        
        }
	
    }

	public void ActualizarTablaClientesFiltrada()
	
	{
	    Object[][] data = filtrarClientes();
	    
	    //se usa para si no se ingresan datos a consultar o se ingresa un valor que no se encuentre en la base de datos nos genere 
	    //un mensaje y no ejecute el dtm
	    
	    
	    
	    if(data.length==0)
	    {
	        JOptionPane.showMessageDialog(this, "No hay Reservas que cumplan con el filtro registrado");
	    }else
	    {
	    //System.out.println(data.length);
	    String [] columnNames = {"id","Nombre","Apellido","Fecha Nacimiento","Nacionalidad","Telefono"};
	    DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
	    tbClientes.setModel(dtm);
	    
	    
	    }
	
	}

}
