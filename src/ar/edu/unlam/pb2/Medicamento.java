package ar.edu.unlam.pb2;

public class Medicamento {
	private String descripcion;
	private double precio;
	private Integer id;
	
	public Medicamento(String descripcion, double precio, Integer id) {

		this.descripcion = descripcion;
		this.precio = precio;
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
