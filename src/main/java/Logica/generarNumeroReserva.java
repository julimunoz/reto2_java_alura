package Logica;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class generarNumeroReserva {
	
	public static int numero;
	
	public generarNumeroReserva() {
		
	}
	
	public String generarNumeroReserva2() {
		
		numero++;
				
		SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
		String prueba = dtf.format(dateObj);
		String NumeroReserva = "HA" + prueba + String.valueOf(numero);
		
		System.out.println(NumeroReserva);
		
		return NumeroReserva;
		}

}
