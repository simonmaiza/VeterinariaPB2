package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Dueño {
	private String nombre;
	private Integer dni;
	private Map<Integer, Mascota> mapaMascotas;
	
	public Dueño(String nombre, Integer dni) {
		this.mapaMascotas = new TreeMap<Integer, Mascota>();
		this.nombre = nombre;
		this.dni = dni;
	}

	public void agregarMascota(Mascota mascota1)throws mascotaDuplicadaException{
		for (Mascota mascotas: mapaMascotas.values()){
			if(mascotas.getId().equals(mascota1.getId()))
			throw new mascotaDuplicadaException("no se pueden agregar mascotas duplicadas");
		}mapaMascotas.put(mascota1.getId(), mascota1);
	}
	public Integer getCantidadDeMascotas(){
		return mapaMascotas.size();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public ArrayList<Mascota> getListaDeMascotas(){
		ArrayList<Mascota> mascotasLista = new ArrayList<Mascota>();
		for (Mascota mascotas: mapaMascotas.values()){
			if(mascotas.getTipo().equals("domestica"))
					mascotasLista.add(mascotas);
		}
		return mascotasLista;
	}
}
