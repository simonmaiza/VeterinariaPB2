package ar.edu.unlam.pb2;

import java.util.Map;
import java.util.TreeMap;

public class Veterinaria {
	private String nombre;
	private Map<Integer, Dueño> mapaDueños;
	private Map<Integer, Integer> mapaAtenciones;
	
	public Veterinaria(String nombre) {
		this.setNombre(nombre);
		this.mapaDueños = new TreeMap<Integer, Dueño>();
		this.mapaAtenciones = new TreeMap<Integer, Integer>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarDueño(Dueño dueño) {
		mapaDueños.put(dueño.getDni(), dueño);	
	}
	
	public void agregarAtencion(Atencion atencion, Mascota mascota) {
		mapaAtenciones.put(atencion.getId(), mascota.getId());	
	}
	
	public Integer getCantidadDeDueños() {
		return mapaDueños.size();
	}
	
	public Map<Integer, Integer> getMapaDeAtencion(){
		return mapaAtenciones;
	}
}
