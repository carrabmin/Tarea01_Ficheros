package modelo.lista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.coche.Coche;

// Clase para generar la lista de coches:
public class ListCoches implements Serializable{
	
	private static final long serialVersionUID = 1043268923792056849L;
	
	private List<Coche> listaCoches;

	// Constructor vacío:
	public ListCoches() {
		super();
		this.listaCoches = new ArrayList<Coche>();
	}

	// Constructor con parámetro:
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
	
	// Método para añadir coche con argumento de tipo coche:
	public void añadir(Coche coche){
		listaCoches.add(coche);
	}

	// Método borrar coches pasándole el ID:
	public void borrarById (String id) {
		int posicionEncontrada = 0;
		try {
			// Recorremos la lista para encontrar la posición correspondiente al ID:
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
	
	// Método de consulta por ID pasándole el ID:
	public void consultaById (String id) {
		int posicionEncontrada = 0;
		try {
			// Recorremos la lista para encontrar la posición correspondiente al ID:
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
	
	// Método para crear una ArrayList<String> con los atributos de los coches en String
	public ArrayList<String> desgloseCoches() {
		String atributos = null;
		ArrayList<String> arrayAtributos = new ArrayList<String>();
		try {
			// Recorremos la lista para extraer los atributos y se los añadimos al ArrayList<String>:
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
	
	// Método para comparar ID:
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

	// Método para comparar matrícula:
	public boolean compararMatricula(String matricula) {
		boolean respuesta = false;
	
			// Recorremos la lista para comparar la matrícula:
			for(Coche c: listaCoches) {
				if(c.getMatricula().equalsIgnoreCase(matricula)) {
					respuesta = true;
				}else {
					respuesta = false;
				}
			}
			return respuesta;
	}
	
	// Método toString():
	@Override
	public String toString() {
		return "Lista de Coches:\n" + listaCoches;
	}
}
