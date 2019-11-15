package test;

import static org.junit.Assert.*;

import org.junit.Test;

import puntos.Cliente;
import puntos.Perfumeria;
import puntos.Usuario;
import puntos.UsuarioIncorrectoException;

public class TestPerfumeria {

	@Test
	 public void testQueAgregueAlSistemaUsuarios() {
	
	 Perfumeria unlam = new Perfumeria("UNLAM");
	 Usuario cliente1 = new Cliente("Jose", "Diaz", "josedz@gmail.com", "789p");
	 Usuario cliente2 = new Cliente("Marta", "Guzman", "margz@gmail.com",
	 "abc10");
	 Usuario cliente3 = new Cliente("Lorenzo", "Rodriguez", "lorenzorz@gmail.com",
	 "9014p");
	 Usuario cliente4 = new Cliente("Sofia", "Aguirre", "sofiag@gmail.com",
	 "4520");
	 Usuario cliente5 = new Cliente("Fernando", "Lopez", "fer_lopez@gmail.com",
	 "57io");
	 unlam.agregarUsuario((Cliente) cliente1);
	 unlam.agregarUsuario((Cliente) cliente2);
	 unlam.agregarUsuario((Cliente) cliente3);
	 unlam.agregarUsuario((Cliente) cliente4);
	 unlam.agregarUsuario((Cliente) cliente5);
	
	 assertEquals(5, unlam.getListaUsuarios().size());
	
	 }

	@Test
	public void testQueLogueeUsuarios() {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Usuario cliente1 = new Cliente("Jose", "Diaz", "josedz@gmail.com", "789p");
		Usuario cliente2 = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		Usuario cliente3 = new Cliente("Lorenzo", "Rodriguez", "lorenzorz@gmail.com", "9014p");
		Usuario cliente4 = new Cliente("Sofia", "Aguirre", "sofiag@gmail.com", "4520");
		Usuario cliente5 = new Cliente("Fernando", "Lopez", "fer_lopez@gmail.com", "57io");

		unlam.agregarUsuario((Cliente) cliente1);
		unlam.agregarUsuario((Cliente) cliente2);
		unlam.agregarUsuario((Cliente) cliente3);
		unlam.agregarUsuario((Cliente) cliente4);
		unlam.agregarUsuario((Cliente) cliente5);

		
		try {
			unlam.loguearUsuario("josedz@gmail.com", "789p");
			unlam.loguearUsuario("margz@gmail.com", "abc10");
			unlam.loguearUsuario("lorenzorz@gmail.com", "9014p");
			unlam.loguearUsuario("sofiag@gmail.com", "4520");
			unlam.loguearUsuario("fer_lopez@gmail.com", "57io");
		} catch (UsuarioIncorrectoException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(5 , unlam.getListaUsuarios().size());

	}
	
	 @Test(expected = UsuarioIncorrectoException .class)
	 public void testQueAlIngresarEmailOPasswordIncorrectoNoPuedaIngresar() throws UsuarioIncorrectoException {
	
	 Perfumeria unlam = new Perfumeria("UNLAM");
	 Usuario clientee = new Cliente("Luz", "Rodriguez", "luzrz@gmail.com",
	 "ghjf");
	
	 unlam.agregarUsuario((Cliente) clientee);
	
	 unlam.loguearUsuario("luzrz@gmail.com", "fdg");
	
	 }
	
	 @Test
	 public void testQueElimineUnUsuario() {
	
	 Perfumeria unlam = new Perfumeria("UNLAM");
	 Usuario cliente1 = new Cliente("Jose", "Diaz", "josedz@gmail.com", "789p");
	 Usuario cliente2 = new Cliente("Marta", "Guzman", "margz@gmail.com",
	 "abc10");
	 Usuario cliente3 = new Cliente("Lorenzo", "Rodriguez", "lorenzorz@gmail.com",
	 "9014p");
	 Usuario cliente4 = new Cliente("Sofia", "Aguirre", "sofiag@gmail.com",
	 "4520");
	 Usuario cliente5 = new Cliente("Fernando", "Lopez", "fer_lopez@gmail.com",
	 "57io");
	
	 unlam.agregarUsuario((Cliente) cliente1);
	 unlam.agregarUsuario((Cliente) cliente2);
	 unlam.agregarUsuario((Cliente) cliente3);
	 unlam.agregarUsuario((Cliente) cliente4);
	 unlam.agregarUsuario((Cliente) cliente5);
	 
	
	 
	 try {
		 unlam.loguearUsuario("josedz@gmail.com", "789p");
		 unlam.loguearUsuario("margz@gmail.com", "abc10");
		 unlam.loguearUsuario("lorenzorz@gmail.com", "9014p");
		 unlam.loguearUsuario("sofiag@gmail.com", "4520");
		 unlam.loguearUsuario("fer_lopez@gmail.com", "57io");
		 unlam.eliminarUsuario(cliente1.getId());
		 
	} catch (UsuarioIncorrectoException  e) {

		e.printStackTrace();
	}
	 
	assertTrue(unlam.getListaUsuarios().contains(cliente1));
	 
	
	 }
	
	
//	 @Test
//	 public void testQueClienteRealizeCompra() {
//	
//	 Perfumeria unlam = new Perfumeria("UNLAM");
//	 Cliente cliente = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
//	 Producto p1 = new Producto(500.0 , 15 , "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
//	 unlam.agregarUsuario(cliente);
//	 p1.productoDisponible();
//	 unlam.agregarProducto(p1);
//	 unlam.loguearUsuario("margz@gmail.com", "abc10");
//	 Venta v1 = new Venta (cliente , p1);
//	
//	 assertFalse(cliente.comprar(cliente, p1));
//	
//	 }

}
