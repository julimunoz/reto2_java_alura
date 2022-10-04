package Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.util.StringUtils;

import Logica.Reserva;

public class DAOReserva {
	
	
	
	 public int NuevaReserva(Reserva reserva)  // recibe un objeto del tipo reserva
	 
	 
	    {
		 
		 int Id = 0;
	        String sql = "INSERT INTO treservas (FechaCheckIn, FechaCheckOut, ValorReserva, FormaPago, Nombre, Apellido, FechaNacimiento,"
	                + " Nacionalidad, Telefono, NumeroReserva) " + 
	                     "VALUES ('"+ reserva.getFechaCheckIn() +"','"+ reserva.getFechaCheckOut() +"', "+ reserva.getValorReserva() +
	                ", '"+ reserva.getFormaPago() + "', '"+ reserva.getNombre() + "', '"+ reserva.getApellido() +"', '"
	                + reserva.getFechaNacimiento() + "', '"+ reserva.getNacionalidad() +"','" + reserva.getTelefono() + "', '" + reserva.getNumeroReserva() + "')";
	        
	        System.out.println(sql);
	        
	        Conexion con = new Conexion();
	        con.crearConexion();
	        try
	        {
	            ResultSet rs = con.ejecutarUpdate(sql);
	            
	            if(rs != null) {
	            	Id = rs.getInt(1);
	            }
				/*
				 * if(rs.next()) { Id = rs.getInt(1); // trae el valor entero de la columna 1
				 * System.out.println(Id); }
				 */
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        con.cerrarConexion();
	        
	        return Id;
	        
	    }
	 
	 // funcion para traer todas las reservas
	 
	 public ArrayList<Reserva> consultarReserva()
	    {
	        ArrayList<Reserva> lista = new ArrayList<Reserva>();
	        String sql = "SELECT * FROM treservas";
	        //System.out.println(sql);
	        Conexion con = new Conexion();
	        con.crearConexion();
	        try
	        {
	            ResultSet rs = con.ejecutarQuery(sql);
	            while(rs.next())
	            {
	                int idtreservas = rs.getInt("idtreservas");
	                String FechaCheckIn = rs.getString("FechaCheckIn");
	                String FechaCheckOut = rs.getString("FechaCheckOut");
	                double ValorReserva = rs.getInt("ValorReserva");
	                String FormaPago = rs.getString("FormaPago");
	                String Nombre = rs.getString("Nombre");
	                String Apellido = rs.getString("Apellido");
	                String FechaNacimiento = rs.getString("FechaNacimiento");
	                String Nacionalidad = rs.getString("Nacionalidad");
	                String Telefono = rs.getString("Telefono");
	                String NumeroReserva = rs.getString("NumeroReserva");
	                
	                Reserva r = new Reserva(idtreservas, FechaCheckIn, FechaCheckOut, ValorReserva, FormaPago, Nombre, Apellido,
	            			FechaNacimiento, Nacionalidad, Telefono, NumeroReserva);
	                lista.add(r);
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        con.cerrarConexion();
	        return lista;
	    }
	 
	 
	 public ArrayList<Reserva> listaFiltradaReservas (String textoABuscar, int itemBusquedad) {

		 
		 ArrayList<Reserva> lista = new ArrayList<Reserva>();
         
         String Sql = "SELECT * FROM treservas WHERE ";

         String SqlString ="";
         
         System.out.println(itemBusquedad);
         
         System.out.println();

         switch (itemBusquedad) {

         case 0:

         SqlString = "FechaCheckIn = '" + textoABuscar + "'";

         break;

         case 1:

         SqlString = "FechaCheckOut = '" + textoABuscar + "'";

         break;

         case 2:

         SqlString = "ValorReserva LIKE '%" + textoABuscar+ "%'";

         break;

         case 3:

         SqlString = "LOWER (FormaPago) LIKE '%" + textoABuscar.toLowerCase() + "%'";

         break;

         case 4:
        	 
         SqlString = "NumeroReserva = '" + textoABuscar.toUpperCase() + "'";

         break;

         }

         Sql = Sql + SqlString;
         System.out.println(Sql);



         Conexion con = new Conexion();
	        con.crearConexion();
	        try
	        {
	            ResultSet rs = con.ejecutarQuery(Sql);
	            while(rs.next())
	            {
	                int idtreservas = rs.getInt("idtreservas");
	                String FechaCheckIn = rs.getString("FechaCheckIn");
	                String FechaCheckOut = rs.getString("FechaCheckOut");
	                double ValorReserva = rs.getDouble("ValorReserva");
	                String FormaPago = rs.getString("FormaPago");
	                String Nombre = rs.getString("Nombre");
	                String Apellido = rs.getString("Apellido");
	                String FechaNacimiento = rs.getString("FechaNacimiento");
	                String Nacionalidad = rs.getString("Nacionalidad");
	                String Telefono = rs.getString("Telefono");
	                String NumeroReserva = rs.getString("NumeroReserva");
	                
	                Reserva r = new Reserva(idtreservas, FechaCheckIn, FechaCheckOut, ValorReserva, FormaPago, Nombre, Apellido,
	            			FechaNacimiento, Nacionalidad, Telefono, NumeroReserva);
	                lista.add(r);
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        con.cerrarConexion();
         
		return lista;

         }
	 
 public ArrayList<Reserva> listaFiltradaClientes (String textoABuscar, int itemBusquedad) {

		 
		 ArrayList<Reserva> lista = new ArrayList<Reserva>();
         
         String Sql = "SELECT * FROM treservas WHERE ";

         String SqlString ="";
         
         System.out.println(itemBusquedad);
         
         System.out.println();

         switch (itemBusquedad) {

         case 0:

         SqlString = "LOWER (Nombre) LIKE '%" + textoABuscar.toLowerCase() + "%'";

         break;

         case 1:

         SqlString = "LOWER (Apellido) LIKE '%" + textoABuscar.toLowerCase() + "%'";

         break;

         case 2:

         SqlString = "FechaNacimiento = '" + textoABuscar+ "'";

         break;

         case 3:

         SqlString = "LOWER (Nacionalidad) LIKE '%" + textoABuscar.toLowerCase() + "%'";

         break;

         case 4:
        	 
         SqlString = "Telefono = '%" + textoABuscar + "%'";

         break;

         }

         Sql = Sql + SqlString;
         System.out.println(Sql);



			
			  Conexion con = new Conexion();
			  con.crearConexion();
			  try {
				  ResultSet rs = con.ejecutarQuery(Sql);
				  while(rs.next()) {
					  int idtreservas = rs.getInt("idtreservas");
					  String FechaCheckIn = rs.getString("FechaCheckIn");
					  String FechaCheckOut = rs.getString("FechaCheckOut");
					  double ValorReserva = rs.getDouble("ValorReserva");
					  String FormaPago = rs.getString("FormaPago");
					  String Nombre = rs.getString("Nombre");
					  String Apellido = rs.getString("Apellido");
					  String FechaNacimiento = rs.getString("FechaNacimiento");
					  String Nacionalidad = rs.getString("Nacionalidad");
					  String Telefono = rs.getString("Telefono");
					  String NumeroReserva = rs.getString("NumeroReserva");
			  
					  Reserva r = new Reserva(idtreservas, FechaCheckIn, FechaCheckOut,
			  ValorReserva, FormaPago, Nombre, Apellido, FechaNacimiento, Nacionalidad,
			  Telefono, NumeroReserva);
					  lista.add(r);
					  }
				  } catch(Exception e) {
					  e.printStackTrace();
					  }
			  con.cerrarConexion();
			 
         
		return lista;

         }
	 
	 public boolean borrarRegistro(int id)
	 {
	     boolean borrado=false; // se inicializa en false para evitar que se borre algun registro por mala manipulacion
	     String sql = "DELETE FROM treservas " +
	                  "WHERE idtreservas = "+ id +"";
	     
	     System.out.println(sql);
			
			  Conexion con = new Conexion();
			   con.crearConexion();
			  try {
				  
				  ResultSet rs = con.ejecutarUpdate(sql);
				  borrado = true;

			  } catch(Exception e) {
				  e.printStackTrace();
				  borrado = false;
			  }
			  
			  con.cerrarConexion();
			  
			  System.out.println(borrado);
			 
	     return borrado;
	 }
	 
	 public boolean modificarReserva(int Id,Reserva r)
	    {
	        boolean modificado = false;
	        String sql = "UPDATE treservas " +
	                     "SET FechaCheckIn = '" + r.getFechaCheckIn() + "', FechaCheckOut = '" + r.getFechaCheckOut() +
	                     "', ValorReserva = " + r.getValorReserva() + ", FormaPago = '" + r.getFormaPago() + "', Nombre = '" + r.getNombre() +
	                     "', Apellido = '" + r.getApellido() + "', FechaNacimiento =  '"
	                     + r.getFechaNacimiento() + "', Nacionalidad = '" + r.getNacionalidad() + "', Telefono = '" + r.getTelefono() + "' WHERE idtreservas = "+ Id +"";
	        System.out.println(sql);
	        
			
			  Conexion con = new Conexion();
			  con.crearConexion();
			  
			  try {
				  
			  con.ejecutarUpdate(sql);
			  modificado = true;
			  } catch(Exception e) {
			  e.printStackTrace();
			  modificado = false;
			  }
			  
			  con.cerrarConexion();
			 
	        return modificado;
	    }
	 
	 public Reserva consultarPorId(int IdBuscar) {
		 
		 //Reserva reservaAModificar = new Reserva("2022-01-03", "2022-01-05", 780000.00, "Tarjeta Debito", "yo","yo", "2010-05-01", "colombiano-colombiana", "123", "ha1");
		 System.out.println(IdBuscar);
		 Reserva r = null;
		 String sql = "SELECT * FROM treservas ";
	        String sqlQuery = "";   // WHERE .........
	        
	        //if (IdBuscar>0)
	        //{
	            sqlQuery = "WHERE idtreservas = " + IdBuscar+" ";
	        //}
	        
	        sql += sqlQuery;
	        System.out.println(sql);
	        
			
			  Conexion con = new Conexion();
			  con.crearConexion();
			  
			  
			  
			  try {
				  ResultSet rs = con.ejecutarQuery(sql);
				  
				  if(rs.next()) { // tengo que poner next(), para que el se mueva al registro que trae, sino no funciona
					
					  int idtreservas = rs.getInt(1);
					  String FechaCheckIn = rs.getString("FechaCheckIn");
					  String FechaCheckOut = rs.getString("FechaCheckOut");
					  double ValorReserva = rs.getDouble("ValorReserva");
					  String FormaPago = rs.getString("FormaPago");
					  String Nombre = rs.getString("Nombre");
					  String Apellido = rs.getString("Apellido");
					  String FechaNacimiento = rs.getString("FechaNacimiento");
					  String Nacionalidad = rs.getString("Nacionalidad");
					  String Telefono = rs.getString("Telefono");
					  String NumeroReserva = rs.getString("NumeroReserva");

					  r = new Reserva(idtreservas, FechaCheckIn, FechaCheckOut,
							  ValorReserva, FormaPago, Nombre, Apellido, FechaNacimiento, Nacionalidad,
							  Telefono, NumeroReserva);
				  }
			  
			  }catch(Exception e) {

				  e.printStackTrace();

			  }

			  con.cerrarConexion();
			 
		 
		 return r;
	 }
		
}
