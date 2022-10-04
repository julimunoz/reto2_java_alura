package Logica;

import java.util.Date;

public class Reserva {
	
	private String FechaCheckIn;
	private int idtreservas;
	private String FechaCheckOut;
	private double ValorReserva;
	private String FormaPago;
	private String Nombre;
	private String Apellido;
	private String FechaNacimiento;
	private String Nacionalidad;
	private String Telefono;
	private String NumeroReserva;

	public Reserva() {
		
		
		
	}
	
	// constructor para recibir los datos de la primera pantalla.
	
	
	// constructo para leer datos de la base de datos
	
	public Reserva(int idtreservas, String FechaCheckIn, String FechaCheckOut, double ValorReserva, String FormaPago, String Nombre, String Apellido,
			String FechaNacimiento, String Nacionalidad, String Telefono, String NumeroReserva) {
		
		
		this.idtreservas = idtreservas;
		this.FechaCheckIn = FechaCheckIn;
		this.FechaCheckOut = FechaCheckOut;
		this.ValorReserva = ValorReserva;
		this.FormaPago = FormaPago;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.FechaNacimiento = FechaNacimiento;
		this.Nacionalidad = Nacionalidad;
		this.Telefono = Telefono;
		this.NumeroReserva = NumeroReserva;
		
		
	}
	
	
	// constructor para ingresar datos a la base de datos, no tiene el idtreservas porque mysql lo genera automaticamente
	
	public Reserva(String FechaCheckIn, String FechaCheckOut, double ValorReserva, String FormaPago, String Nombre, String Apellido,
			String FechaNacimiento, String Nacionalidad, String Telefono, String NumeroReserva) {
		
		
		
		this.FechaCheckIn = FechaCheckIn;
		this.FechaCheckOut = FechaCheckOut;
		this.ValorReserva = ValorReserva;
		this.FormaPago = FormaPago;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.FechaNacimiento = FechaNacimiento;
		this.Nacionalidad = Nacionalidad;
		this.Telefono = Telefono;
		this.NumeroReserva = NumeroReserva;
		
	}


	public String getFechaCheckIn() {
		return FechaCheckIn;
	}


	public int getIdtreservas() {
		return idtreservas;
	}


	public String getFechaCheckOut() {
		return FechaCheckOut;
	}


	public double getValorReserva() {
		return ValorReserva;
	}


	public String getFormaPago() {
		return FormaPago;
	}


	public String getNombre() {
		return Nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public String getFechaNacimiento() {
		return FechaNacimiento;
	}


	public String getNacionalidad() {
		return Nacionalidad;
	}


	public String getTelefono() {
		return Telefono;
	}


	public String getNumeroReserva() {
		return NumeroReserva;
	}


	public void setFechaCheckIn(String fechaCheckIn) {
		FechaCheckIn = fechaCheckIn;
	}


	public void setIdtreservas(int idtreservas) {
		this.idtreservas = idtreservas;
	}


	public void setFechaCheckOut(String fechaCheckOut) {
		FechaCheckOut = fechaCheckOut;
	}


	public void setValorReserva(double valorReserva) {
		ValorReserva = valorReserva;
	}


	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}


	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public void setNumeroReserva(String numeroReserva) {
		NumeroReserva = numeroReserva;
	}
	
	

}
