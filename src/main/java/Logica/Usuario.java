package Logica;



public class Usuario {
	
	 private int id;
	 private String nombre;
	 private String password;
	
	public Usuario() {
		
		id = 0;
		nombre = "";
		password = "";
		
	}
	
	public Usuario(int id, String nombre, String password) {
		
		
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Usuario [id = " + this.id + ", nombre = " + this.nombre + ", password = " + this.password + "]";
	}
	
	

}
