package modelo.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.coche.Coche;

// Clase para generar la lista de coches:
public class ListCoches implements Serializable{
	
	private static final long serialVersionUID = 1043268923792056849L;
	
	private List<Coche> listaCoches;

	// Constructor vac�o:
	public ListCoches() {
		super();
		this.listaCoches = new ArrayList<Coche>();
	}

	// Constructor con par�metro:
	public ListCoches(List<Coche> listaCoches) {
		super();
		this.listaCoches = listaCoches;
	}
	
	// Getters and Setters:
	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	
	// M�todo para a�adir coche con argumento de tipo coche:
	public void a�adir(Coche coche){
		listaCoches.add(coche);
	}

	// M�todo borrar coches pas�ndole el ID:
	public void borrarById (String id) {
		int posicionEncontrada = 0;
		try {
			// Recorremos la lista para encontrar la posici�n correspondiente al ID:
			for(Coche c: listaCoches) {
				if(c.getId().equalsIgnoreCase(id)) {
					posicionEncontrada = listaCoches.indexOf(c);
				}
			}
			// Borramos el coche encontrado:
			listaCoches.remove(posicionEncontrada);
			System.out.println("Coche con el id: " + id + " borrado");
		}catch (IndexOutOfBoundsException e) {
				System.out.println("Delete -> Id del coche no encontrado");
		}
			
	}
	
	// M�todo de consulta por ID pas�ndole el ID:
	public void consultaById (String id) {
		int posicionEncontrada = 0;
		try {
			// Recorremos la lista para encontrar la posici�n correspondiente al ID:
			for(Coche c: listaCoches) {
				if(c.getId().equalsIgnoreCase(id)) {
					posicionEncontrada = listaCoches.indexOf(c);
				}
			}
			// Imprimimos el coche encontrado:
			System.out.println(listaCoches.get(posicionEncontrada));
		}catch (IndexOutOfBoundsException e) {
				System.out.println("Consulta -> Id del coche no encontrado");
		}
	}
	
	// M�todo para crear una ArrayList<String> con los atributos de los coches en String
	public ArrayList<String> desgloseCoches() {
		String atributos = null;
		ArrayList<String> arrayAtributos = new ArrayList<String>();
		try {
			// Recorremos la lista para extraer los atributos y se los a�adimos al ArrayList<String>:
			for(Coche c: listaCoches) {
				atributos = (c.getId() + "-" + c.getMatricula() + "-" + c.getMarca() + "-" + c.getModelo() + "-" + c.getColor());
				arrayAtributos.add(atributos);
			}
		}catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
		}
		// Devuelvo el ArrayList<String> creado con los atributos de los coches en String:
		return arrayAtributos;
	}
	
	// M�todo para comparar ID:
	public boolean compararID(String id) {
		boolean respuesta = false;
	
			// Recorremos la lista para comparar el ID:
			for(Coche c: listaCoches) {
				if(c.getId().equalsIgnoreCase(id)) {
					respuesta = true;
				}else {
					respuesta = false;
				}
			}
			return respuesta;
	}

	// M�todo para comparar matr�cula:
	public boolean compararMatricula(String matricula) {
		boolean respuesta = false;
	
			// Recorremos la lista para comparar la matr�cula:
			for(Coche c: listaCoches) {
				if(c.getMatricula().equalsIgnoreCase(matricula)) {
					respuesta = true;
				}else {
					respuesta = false;
				}
			}
			return respuesta;
	}
	
	// M�todo toString():
	@Override
	public String toString() {
		return "Lista de Coches:\n" + listaCoches;
	}
}
