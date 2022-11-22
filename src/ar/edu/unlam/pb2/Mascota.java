package ar.edu.unlam.pb2;

public class Mascota {
	private String nombreMascota;
	private String apodo;
	private Integer id;
	public String tipo;
	
	public Mascota(String nombreMascota, String apodo, Integer id, String tipo) {
		super();
		this.nombreMascota = nombreMascota;
		this.apodo = apodo;
		this.id = id;
		this.tipo = tipo;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
