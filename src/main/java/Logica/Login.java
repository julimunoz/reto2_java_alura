package Logica;

import javax.swing.JOptionPane;

import Persistencia.DAOUsuario;
import vista.FormularioAdmin;
import vista.FormularioLogin;

public class Login {
	
	String usuario;
	String password;
	boolean estado = false;
	
	public Login() {
		
		
		
		}
	
	public boolean comprobar (String usuario, String password) {

		this.usuario = usuario;
		this.password = password;
		
		//System.out.println(usuario);
		//System.out.println(password);

		DAOUsuario daousuario = new DAOUsuario();
		Usuario u = new Usuario();
		u = daousuario.consultarUsuario(usuario);
		if(u.getId() == 0) {

			JOptionPane.showConfirmDialog(null, "El usuario " + usuario + " no existe",
					"CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
		}else {

			if(!(u.getPassword().equals(password))) {

				JOptionPane.showConfirmDialog(null, "la contraseña ingresada no es correcta",
						"CLOSED_OPTION", JOptionPane.CLOSED_OPTION,
						JOptionPane.INFORMATION_MESSAGE);	
			}else {
				estado = true;
			}
		}
		//System.out.println(estado);
		return estado;
		}
	}
	
		
		
	

