package ar.edu.unlam.pb2;

import java.util.Map;
import java.util.TreeMap;

public class Atencion {
	private Due�o due�o;
	private Mascota mascota;
	private double precio;
	private Integer id;
	private Map<Integer, Medicamento> mapaMedicamentos;
	
	public Atencion(Due�o due�o, Mascota mascota, double precio, Integer id) {
		super();
		this.due�o = due�o;
		this.mascota = mascota;
		this.precio = precio;
		this.id = id;
		this.mapaMedicamentos = new TreeMap<Integer, Medicamento>();
	}

	public Due�o getDue�o() {
		return due�o;
	}

	public void setDue�o(Due�o due�o) {
		this.due�o = due�o;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
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
	public void agregarMedicamento(Medicamento medicamento){
		mapaMedicamentos.put(medicamento.getId(), medicamento);
	}
	public Integer getCantidadDeMedicamentos(){
		return mapaMedicamentos.size();
	}

	public double getPrecioTotal() {
		double preciototal = 0;
		for(Medicamento medicamentos: mapaMedicamentos.values()){
			preciototal += medicamentos.getPrecio();
		}
		return preciototal + this.getPrecio();
	}
}
