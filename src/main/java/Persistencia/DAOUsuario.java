package Persistencia;

import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Logica.Usuario;

public class DAOUsuario {
	
	
	
	 public Usuario consultarUsuario(String nombre)  // PARA buscar el usuario en la base de datos
	 
	 
	    {
		 
		 	int Id = 0;
			String Nombre = "";
			String Password = "";
			
	        String sql = "SELECT idusuarios, usuario, password FROM  tusuarios";
	        String sqlQuery = "";   // WHERE .........
	        Usuario u1   = new Usuario();
	        if (nombre != "")
	        {
	            sqlQuery = " WHERE usuario ="   +"'" + nombre + "'";
	        }
	        
	        sql += sqlQuery;
	        // System.out.println(sql);
	        Conexion con = new Conexion();
	        con.crearConexion();
	        
			
	        try {
	        	

	        	ResultSet rs = con.ejecutarQuery(sql);
	        		        	
	        	if (rs.next()) {
	        	
	        		Id = rs.getInt("idusuarios");
	        		Nombre = rs.getString("usuario");
	        		Password = rs.getString("password");      		
	        		//System.out.println(Id);
	        		//System.out.println(Nombre);
	        		//System.out.println(Nombre);
	        	
	        	
	        	}else {
	        		
	        		System.out.println("usuario no encontrado");
	        		
	        	}
				
	        	}catch(Exception e) {
	        		e.printStackTrace();
	        		}

	        con.cerrarConexion();
	        
	        Usuario u = new Usuario(Id, Nombre, Password);
	        
			/*
			 * System.out.println(Id); System.out.println(Nombre);
			 * System.out.println(Password); System.out.println(u.toString());
			 */
	        
	        return u;
	        
	    }

}
