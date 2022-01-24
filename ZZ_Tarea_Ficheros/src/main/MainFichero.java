package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.coche.Coche;
import modelo.lista.ListCoches;

// Clase Main para ejecutar el programa:
public class MainFichero {
	
	// Constante con el nombre del fichero:
	public static final String NOMBRE_FICHERO = "coches.dat";

	public static void main(String[] args){
		
		// Apuntamos al fichero definido de manera relativa
		File fc = new File(NOMBRE_FICHERO);
		
		// Estructura de control "if-else" para comprobar la existencia del archivo:
		if (fc.exists()) {
			
			ListCoches lc01 = null;
			
			// Leemos el objeto guardado en el archivo "coches.dat":
			try (FileInputStream fis = new FileInputStream(fc);
					 ObjectInputStream ois = new ObjectInputStream(fis)) {
				
				// Creamos la variable "lc01" para guardar la lista de coches:
				lc01 = (ListCoches) ois.readObject();
				
				System.out.println(lc01);
				System.out.println("");
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
				
			// Ejecutamos el método "gestionLista(lc01)" con nuestra lista de coches:
			gestionLista(lc01);
			
		}else {
			// Creamos una lista de coches vacía:
			ListCoches lc02 = new ListCoches();
			// Ejecutamos el método "gestionLista(lc02)" con nuestra lista de coches:
			gestionLista(lc02);
		}
	}

// Método con las opciones para la gestión de la lista de coches:
public static void gestionLista(ListCoches listaCoches) {
	Scanner leer = new Scanner(System.in);
	boolean condicion = true;
	
	do {
		System.out.println("----- MENÚ -----");
		System.out.println("1. Añadir nuevo coche");
		System.out.println("2. Borrar coche por id");
		System.out.println("3. Consulta coche por id");
		System.out.println("4. Listado de coches");
		System.out.println("5. Exportar coches a archivo de texto");
		System.out.println("6. Terminar el programa");
		
		int opcion = leer.nextInt();
		
		switch (opcion){
			// Opción añadir coches a la lista:
			case 1:
				System.out.println("\n*********** ALTA COCHE ***********");
				leer.nextLine();
				
				System.out.println("Introduzca el ID:");
				String id01 = leer.nextLine();
				
				// Establecemos estructura de control "if-else" para comprobar
				// que ni el ID ni la matrícula se repite, con la ayuda de los
				// métodos "compararID(id01)" y "compararMatrícula(matrícula)":
				if (listaCoches.compararID(id01) == true) {
					System.out.println("ID duplicado\n");
				}else {
					System.out.println("Introduzca la matrícula");
					String matricula = leer.nextLine();
					
					if (listaCoches.compararMatricula(matricula) == true) {
						System.out.println("Matrícula duplicada\n");
					}else {
						System.out.println("Introduzca la marca");
						String marca = leer.nextLine();
					
						System.out.println("Introduzca el modelo");
						String modelo = leer.nextLine();
					
						System.out.println("Introduzca el color");
						String color = leer.nextLine();
					
						// Generamos un coche:
						Coche coche = new Coche(id01, matricula, marca, modelo, color);
					
						//Ejecutamos el método "añadir" implementado en ListCoches
						// para añadir el coche a la lista:
							listaCoches.añadir(coche);
							System.out.println("\nCoche Añadido\n");	
					}
				}			
				break;

			// Opción borrar coches por ID:
			case 2:
				System.out.println("\n*********** BORRAR COCHE POR ID ***********");
				leer.nextLine();
				
				System.out.println("Introduzca el ID:");
				String id02 = leer.nextLine();
				
				// Ejecutamos el método de "borrarById" implementado en ListCoches:
				listaCoches.borrarById(id02);
				System.out.println("");
				break;
				
			// Opción consulta de coche por ID:
			case 3:
				System.out.println("\n*********** CONSULTA COCHE POR ID ***********");
				leer.nextLine();
				
				System.out.println("Introduzca el ID:");
				String id03 = leer.nextLine();
				
				// Ejecutamos el método de "consultaById" implementado en ListCoches:
				listaCoches.consultaById(id03);
				System.out.println("");
				break;
				
			// Opción listado de coches:	
			case 4:
				System.out.println("\n*********** LISTADO DE COCHES ***********");
				
				// Imprimimos la lista de los coches:
				System.out.println(listaCoches.getListaCoches());
				System.out.println("");
				break;
				
			// Opción de escritura de atributos a fichero de texto:	
			case 5:
				// Creamos una ArrayList para obtener los atributos de los coches
				// en forma de String:
				ArrayList<String> listaAtributos = listaCoches.desgloseCoches();
				
				// Abrimos el fichero para escritura:
				FileWriter file;
				try {
					file = new FileWriter("coches.txt");
				} catch (IOException e) {
					System.out.println("No se puede abrir o crear el fichero");
					System.out.println(e.getMessage());
					return;
				}
				
				// Abrimos buffer:
				BufferedWriter buffer = new BufferedWriter(file);
				
				// Recorremos el ArrayList de atributos para escribir en el fichero
				// los diferentes String (id-matricula-marca-modelo-color):
				for (String s: listaAtributos) {
					try {
						buffer.write(s);
						buffer.newLine();
						buffer.flush();
					} catch (IOException e) {
						System.out.println("Error al escribir en el fichero");
						System.out.println(e.getMessage());
					}
				}
				
				// Cerramos el buffer y el fichero:
				try {
					buffer.close();
					file.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					System.out.println(e.getMessage());
				}
				
				System.out.println("\nArchivo de texto creado\n");
				break;
				
			// Opción de escritura del fichero y finalización del programa:	
			case 6:
				// Abrimos el fichero para escritura para escribir objetos a fichero:
				try (FileOutputStream fos = new FileOutputStream(NOMBRE_FICHERO);
						 ObjectOutputStream ois = new ObjectOutputStream(fos)) {
						
						ois.writeObject(listaCoches);
						System.out.println("\nObjeto introducido");
						System.out.println("Los coches se han guardado con éxito");	
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
				condicion = false;
				
				System.out.println("\n----- FIN DEL PROGRAMA -----");
				break;
			
			default:
				System.out.println("Opción elegida no válida");	
		}
		
	}while(condicion);
	
	leer.close();
	}
}
	

