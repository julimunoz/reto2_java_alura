package Test;

import Logica.Reserva;
import Logica.generarNumeroReserva;
import Persistencia.DAOReserva;
import vista.Formulario;
import vista.FormularioBusquedad;
import vista.FormularioModificarReserva;
import vista.FormularioReserva;

public class prueba_form {
	
	public static void main(String[] args) {
		
		//Reserva r = new Reserva("2022-01-03", "2022-01-05", 780000.00, "Tarjeta Debito", "yo","yo", "2010-05-01", "colombiano-colombiana", "123", "ha1");
		FormularioBusquedad f = new FormularioBusquedad();
		f.setVisible(true);
	}

}
