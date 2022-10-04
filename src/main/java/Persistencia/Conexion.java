package Persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion{
    
    private String conectorInstalado = "jdbc:mysql:";
    private String host = "localhost:3306";
    private String baseDatos = "reservas_hotel";
    private String username = "root"; // se ingresa clave y password para acceder al servidor de MySql
    private String password = "root"; 
    private Connection conexion;
    private Statement ejecutor;
    
    
    public Conexion(){
    	
        crearConexion();
    }
    
    public Connection getConexion(){
        return this.conexion;
    }
            
    public void crearConexion()
    {
        try
        {
            String cadenaConexion =  conectorInstalado + "//" + host + "/" + baseDatos;
            //Class.forName("com.mysql.cj.jdbc,Driver"); // por alguna razon esta instruccion me genera error, se deja comentada
            conexion = DriverManager.getConnection(cadenaConexion, username, password);
            ejecutor = conexion.createStatement();
            ejecutor.setQueryTimeout(30);  // set timeout to 30 sec.
            //System.out.println("conexión creada: "+conexion);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public ResultSet ejecutarQuery(String sql)
    {
        ResultSet rs = null;
        try
        {
            rs = ejecutor.executeQuery(sql);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public ResultSet ejecutarUpdate(String sql)
    {
        ResultSet rs = null;
        try
        {
        	long key = -1L;
        	Statement statement = conexion.createStatement();
        	statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        	rs = statement.getGeneratedKeys();
        	//System.out.println(rs.getMetaData());
        	if (rs != null && rs.next()) {
        		
        		
        	    key = rs.getLong(1);
        	    System.out.println(key);
        	    
        	}
			/*
			 * int cant = ejecutor.executeUpdate(sql);
			 *  System.out.println(cant); if (cant > 0) {
			 *   rs = ejecutor.getGeneratedKeys();
			 *    System.out.println(rs);
			 *   }
			 */
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public void cerrarConexion()
    {
        try {
            conexion.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
}


