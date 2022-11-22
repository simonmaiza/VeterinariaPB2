package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaInstanciarUnaVeterinariaConNombre() {
		String nombreVeterinaria = "Veterinaria1";
		
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		assertEquals(nombreVeterinaria, veterinaria1.getNombre());
	}

	@Test
	public void queSePuedaCrearUnDuenioConDniYConNombre() {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		Due�o due�o1 = new Due�o(nombreDue�o, dniDue�o);
		assertEquals(nombreDue�o, due�o1.getNombre());
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		assertEquals(nombreMascota, mascota1.getNombreMascota());
				
		// El tipo de mascota puede ser solamente doméstica y exótica (enum)
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		Due�o due�o1 = new Due�o(nombreDue�o, dniDue�o);
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		
		String nombreMascota1 = "Gato";
		String apodo1 = "Apodo2";
		Integer id1 = 2;
		String tipo1 =  "domestica";
		
		Mascota mascota1 = new Mascota(nombreMascota1, apodo1, id1, tipo1);
		Mascota mascota= new Mascota(nombreMascota, apodo, id, tipo);
		
		due�o1.agregarMascota(mascota);
		due�o1.agregarMascota(mascota1);
		
		Integer valoresperado = 2;
		
		assertEquals(valoresperado, due�o1.getCantidadDeMascotas());
	}
	
	@Test(expected=mascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException()throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		Due�o due�o1 = new Due�o(nombreDue�o, dniDue�o);
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		
		String nombreMascota1 = "Gato";
		String apodo1 = "Apodo2";
		Integer id1 = 1;
		String tipo1 =  "domestica";
		
		Mascota mascota1 = new Mascota(nombreMascota1, apodo1, id1, tipo1);
		Mascota mascota= new Mascota(nombreMascota, apodo, id, tipo);
		
		due�o1.agregarMascota(mascota);
		due�o1.agregarMascota(mascota1);
	}
	
	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {
		String descripcion = "descripcion";
		double precio = 10.0;
		Integer id = 1;
		
		Medicamento medicamento1 = new Medicamento(descripcion, precio, id);
		
		assertNotNull(medicamento1);
	}
	
	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreVeterinaria = "Veterinaria1";
		
		Due�o due�o = new Due�o(nombreDue�o, dniDue�o);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		
		veterinaria1.agregarDue�o(due�o);
		
		Integer valoresperado = 1;
		assertEquals(valoresperado, veterinaria1.getCantidadDeDue�os());
	}
	
	@Test
	public void queSePuedaCrearUnaAtencionConDuenioMascotaYPrecio() throws DuenioInexistenteException, MascotaNoEncontradaException, mascotaDuplicadaException{
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		double precio = 1000.0;
		Integer idAtencion = 1;
		String nombreVeterinaria = "Veterinaria1";
		
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Due�o due�o = new Due�o(nombreDue�o, dniDue�o);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		due�o.agregarMascota(mascota1);
		veterinaria1.agregarDue�o(due�o);
		
		Atencion atencion1 = new Atencion(due�o,mascota1,precio,idAtencion);
		
		assertNotNull(atencion1);
	
	}
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		Integer id2 = 2;
		String tipo =  "domestica";
		double precio = 1000.0;
		
		String nombreVeterinaria = "Veterinaria1";
		
		String descripcion = "descripcion";
		double precioMedicamento = 10.0;
		Integer idAtencion = 1;
		
		Medicamento medicamento1 = new Medicamento(descripcion, precioMedicamento, id);
		Medicamento medicamento2 = new Medicamento(descripcion, precioMedicamento, id2);
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Due�o due�o = new Due�o(nombreDue�o, dniDue�o);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		due�o.agregarMascota(mascota1);
		veterinaria1.agregarDue�o(due�o);
		
		Atencion atencion1 = new Atencion(due�o,mascota1,precio,idAtencion);
		atencion1.agregarMedicamento(medicamento1);
		atencion1.agregarMedicamento(medicamento2);
		Integer valoresperado = 2;
		assertEquals(valoresperado, atencion1.getCantidadDeMedicamentos());
		// Para asignar un medicamento necesita el id de la atencion y el id del medicamento
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		double precio = 1000.0;
		
		String nombreVeterinaria = "Veterinaria1";
		
		String descripcion = "descripcion";
		double precioMedicamento = 10.0;
		Integer idAtencion = 1;
		
		Medicamento medicamento1 = new Medicamento(descripcion, precioMedicamento, id);
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Due�o due�o = new Due�o(nombreDue�o, dniDue�o);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		due�o.agregarMascota(mascota1);
		veterinaria1.agregarDue�o(due�o);
		
		Atencion atencion1 = new Atencion(due�o,mascota1,precio,idAtencion);
		atencion1.agregarMedicamento(medicamento1);
		double valoresperado = 1010.0;
		
		assertEquals(valoresperado, atencion1.getPrecioTotal(),0);
		// El precio total de la atencion será la suma del precio de la atencion mas la suma del precio de todos los medicamentos
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		
		String nombreMascota2 = "Perro";
		String apodo2 = "Apodo2";
		Integer id2 = 2;
		String tipo2 =  "exotica";
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Mascota mascota2 = new Mascota(nombreMascota2, apodo2, id2, tipo2);
		Due�o due�o1 = new Due�o(nombreDue�o, dniDue�o);
		
		due�o1.agregarMascota(mascota1);
		due�o1.agregarMascota(mascota2);
		
		Integer valoresperado = 1;
		
		assertEquals(valoresperado.intValue(), due�o1.getListaDeMascotas().size());
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() throws mascotaDuplicadaException {
		String nombreDue�o = "Carlos";
		Integer dniDue�o = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		double precio = 1000.0;
		
		String nombreVeterinaria = "Veterinaria1";
		
		String descripcion = "descripcion";
		double precioMedicamento = 10.0;
		Integer idAtencion = 1;
		
		Medicamento medicamento1 = new Medicamento(descripcion, precioMedicamento, id);
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Due�o due�o = new Due�o(nombreDue�o, dniDue�o);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		due�o.agregarMascota(mascota1);
		veterinaria1.agregarDue�o(due�o);
		Atencion atencion1 = new Atencion(due�o,mascota1,precio,idAtencion);
		veterinaria1.agregarAtencion(atencion1, mascota1);
		Integer valoresperado = 1;
		
		assertEquals(valoresperado.intValue(), veterinaria1.getMapaDeAtencion().size());
	}
	
}
