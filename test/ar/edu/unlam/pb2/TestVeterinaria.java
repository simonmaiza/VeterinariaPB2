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
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
		Dueño dueño1 = new Dueño(nombreDueño, dniDueño);
		assertEquals(nombreDueño, dueño1.getNombre());
	}
	
	@Test
	public void queSePuedaCrearUnaMascotaConNombreIdApodoYTipoDeMascota() {
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		assertEquals(nombreMascota, mascota1.getNombreMascota());
				
		// El tipo de mascota puede ser solamente domÃ©stica y exÃ³tica (enum)
	}
	
	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
		Dueño dueño1 = new Dueño(nombreDueño, dniDueño);
		
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
		
		dueño1.agregarMascota(mascota);
		dueño1.agregarMascota(mascota1);
		
		Integer valoresperado = 2;
		
		assertEquals(valoresperado, dueño1.getCantidadDeMascotas());
	}
	
	@Test(expected=mascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException()throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
		Dueño dueño1 = new Dueño(nombreDueño, dniDueño);
		
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
		
		dueño1.agregarMascota(mascota);
		dueño1.agregarMascota(mascota1);
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
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
		String nombreVeterinaria = "Veterinaria1";
		
		Dueño dueño = new Dueño(nombreDueño, dniDueño);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		
		veterinaria1.agregarDueño(dueño);
		
		Integer valoresperado = 1;
		assertEquals(valoresperado, veterinaria1.getCantidadDeDueños());
	}
	
	@Test
	public void queSePuedaCrearUnaAtencionConDuenioMascotaYPrecio() throws DuenioInexistenteException, MascotaNoEncontradaException, mascotaDuplicadaException{
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
		String nombreMascota = "Perro";
		String apodo = "Apodo1";
		Integer id = 1;
		String tipo =  "domestica";
		double precio = 1000.0;
		Integer idAtencion = 1;
		String nombreVeterinaria = "Veterinaria1";
		
		
		Mascota mascota1 = new Mascota(nombreMascota, apodo, id, tipo);
		Dueño dueño = new Dueño(nombreDueño, dniDueño);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		dueño.agregarMascota(mascota1);
		veterinaria1.agregarDueño(dueño);
		
		Atencion atencion1 = new Atencion(dueño,mascota1,precio,idAtencion);
		
		assertNotNull(atencion1);
	
	}
	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
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
		Dueño dueño = new Dueño(nombreDueño, dniDueño);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		dueño.agregarMascota(mascota1);
		veterinaria1.agregarDueño(dueño);
		
		Atencion atencion1 = new Atencion(dueño,mascota1,precio,idAtencion);
		atencion1.agregarMedicamento(medicamento1);
		atencion1.agregarMedicamento(medicamento2);
		Integer valoresperado = 2;
		assertEquals(valoresperado, atencion1.getCantidadDeMedicamentos());
		// Para asignar un medicamento necesita el id de la atencion y el id del medicamento
	}
	
	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
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
		Dueño dueño = new Dueño(nombreDueño, dniDueño);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		dueño.agregarMascota(mascota1);
		veterinaria1.agregarDueño(dueño);
		
		Atencion atencion1 = new Atencion(dueño,mascota1,precio,idAtencion);
		atencion1.agregarMedicamento(medicamento1);
		double valoresperado = 1010.0;
		
		assertEquals(valoresperado, atencion1.getPrecioTotal(),0);
		// El precio total de la atencion serÃ¡ la suma del precio de la atencion mas la suma del precio de todos los medicamentos
	}
	
	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
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
		Dueño dueño1 = new Dueño(nombreDueño, dniDueño);
		
		dueño1.agregarMascota(mascota1);
		dueño1.agregarMascota(mascota2);
		
		Integer valoresperado = 1;
		
		assertEquals(valoresperado.intValue(), dueño1.getListaDeMascotas().size());
	}
	
	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() throws mascotaDuplicadaException {
		String nombreDueño = "Carlos";
		Integer dniDueño = 42280686;
		
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
		Dueño dueño = new Dueño(nombreDueño, dniDueño);	
		Veterinaria veterinaria1 = new Veterinaria(nombreVeterinaria);
		dueño.agregarMascota(mascota1);
		veterinaria1.agregarDueño(dueño);
		Atencion atencion1 = new Atencion(dueño,mascota1,precio,idAtencion);
		veterinaria1.agregarAtencion(atencion1, mascota1);
		Integer valoresperado = 1;
		
		assertEquals(valoresperado.intValue(), veterinaria1.getMapaDeAtencion().size());
	}
	
}
