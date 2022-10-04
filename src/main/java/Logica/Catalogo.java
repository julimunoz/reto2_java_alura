package Logica;

import java.util.ArrayList;

import Persistencia.DAOReserva;

public class Catalogo {
	
	private ArrayList<Reserva> Reservas = new ArrayList<Reserva>();
    private ArrayList<Reserva> ReservasFiltrados = new ArrayList<Reserva>();
	
	public boolean guardarProductos(Reserva r)
    {
        DAOReserva dao = new DAOReserva();
        int id = dao.NuevaReserva(r);
        if (id > 0 )
        {
            return true;
        }
        else {
            return false;
        }
    }
	
	// metodo para traer los datos de la base de datos
	
	public ArrayList<Reserva> listarReservas()
    {
		DAOReserva dao = new DAOReserva();
        Reservas = dao.consultarReserva();
        return Reservas;
    }
	
	public ArrayList<Reserva> filtrarReservas(String valorTextoAbuscar, int itemSeleccionado)  // metodo creado para filtrar Reservas
    {
        DAOReserva dao = new DAOReserva();
        ArrayList<Reserva> Reservasfiltrados = dao.listaFiltradaReservas(valorTextoAbuscar, itemSeleccionado);
        return Reservasfiltrados;
    }
	
	public ArrayList<Reserva> filtrarClientes(String valorTextoAbuscar, int itemSeleccionado)  // metodo creado para filtrar clientes
    {
        DAOReserva dao = new DAOReserva();
        ArrayList<Reserva> Clientesfiltrados = dao.listaFiltradaClientes(valorTextoAbuscar, itemSeleccionado);
        return Clientesfiltrados;
    }
	
	public boolean borrarRegistro(int id)     // le paso el id que quiero borrar
    {
		DAOReserva dao = new DAOReserva();
        boolean borrado = dao.borrarRegistro(id);
        
        if (borrado == true)
        { 
            return true;
        }else
        {
         return false;
        }   
    }
	
	
	public boolean actualizarReserva(int id, Reserva r)
    {
        DAOReserva dao = new DAOReserva();
        boolean modificado = dao.modificarReserva(id,r);
        if (modificado == true)
        {
            return true;
        }else
        {
         return false;
        }
    }
	
	public Reserva leerReserva(int id) //creado por mi para obtener el producto por el Id y no por el index del arreglo
    {
        DAOReserva dao = new DAOReserva();
        Reserva r = dao.consultarPorId(id);
        return r;
    }

}
