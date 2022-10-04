package Logica;

import java.util.Date;

public class convertirFecha {
	
	//metodo paa convertir las fechas que veienen del JChoose, que vienen en formato Jcalendar a un String y asi poder enviarlo a la tabla de MySql
	
	public String convertiFecha (Date fecha) {

		String fechaConvertidad = "";

		int anoFecha = fecha.getYear() + 1900; // esto porque la funcion devuelve la cantidad de años desde 1900 a hoy
		int mesFecha = fecha.getMonth() + 1; // porque devuelve un valor entrwe 0 y 11, donde 0 es enero
		int diaFecha = fecha.getDate(); //ojo es getDate para obtener el dia del mes, si se usa getDay devuelve el dia de la semana, es decir entre 1 y 7

		fechaConvertidad = String.valueOf(anoFecha) + "-" + String.valueOf(mesFecha) + "-" + String.valueOf(diaFecha);

		return  fechaConvertidad;
	}
	
	public Date convertirStringAfecha(String Fecha) {
		
		Date fechaConvertidad = new Date();
		
		String string = Fecha;
		String[] parts = string.split("-", 3);
		String part1 = parts[0];
		String part2 = parts[1];
		String part3 = parts[2];
		
		//System.out.println(part1.toString());
		
		fechaConvertidad.setYear(Integer.parseInt(part1)-1900);
		fechaConvertidad.setMonth(Integer.parseInt(part2)-1);
		fechaConvertidad.setDate(Integer.parseInt(part3));
		
		System.out.println(fechaConvertidad);
		
		return fechaConvertidad;
	}

}
