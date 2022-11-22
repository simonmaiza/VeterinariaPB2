package ar.edu.unlam.pb2;

import java.util.Map;
import java.util.TreeMap;

public class Veterinaria {
	private String nombre;
	private Map<Integer, Due�o> mapaDue�os;
	private Map<Integer, Integer> mapaAtenciones;
	
	public Veterinaria(String nombre) {
		this.setNombre(nombre);
		this.mapaDue�os = new TreeMap<Integer, Due�o>();
		this.mapaAtenciones = new TreeMap<Integer, Integer>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarDue�o(Due�o due�o) {
		mapaDue�os.put(due�o.getDni(), due�o);	
	}
	
	public void agregarAtencion(Atencion atencion, Mascota mascota) {
		mapaAtenciones.put(atencion.getId(), mascota.getId());	
	}
	
	public Integer getCantidadDeDue�os() {
		return mapaDue�os.size();
	}
	
	public Map<Integer, Integer> getMapaDeAtencion(){
		return mapaAtenciones;
	}
}
