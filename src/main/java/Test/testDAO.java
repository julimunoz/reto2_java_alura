package Test;

import Logica.Reserva;
import Persistencia.DAOReserva;

public class testDAO {
	
	public static void main(String[] args) {
		
		
		DAOReserva d = new DAOReserva();
		Reserva r = new Reserva();
		d.consultarPorId(1);
	}

}
