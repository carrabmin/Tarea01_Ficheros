package modelo.coche;
import java.io.Serializable;

public class Coche implements Serializable {
	
	private static final long serialVersionUID = 6222440984606410778L;
	
	private String id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	
	public Coche() {
		super();
	}

	public Coche(String id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Coche [Id: " + id + " / Matricula: " + matricula + " / Marca: " + marca + " / Modelo: " + modelo + " / Color: "
				+ color + "]\n";
	}

}
