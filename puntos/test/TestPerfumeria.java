package test;

import static org.junit.Assert.*;

import org.junit.Test;

import puntos.Cliente;
import puntos.CompraNoEncontradaException;
import puntos.Perfumeria;
import puntos.Producto;
import puntos.ProductoNoEncontradoException;
import puntos.Usuario;
import puntos.UsuarioIncorrectoException;
import puntos.Venta;

public class TestPerfumeria {

	@Test
	public void testQueAgregueAlSistemaUsuarios() {

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

		assertEquals(5, unlam.getListaUsuarios().size());

	}

	@Test(expected = UsuarioIncorrectoException.class)
	public void testQueAlIngresarEmailOPasswordIncorrectoNoPuedaIngresar() throws UsuarioIncorrectoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Usuario clientee = new Cliente("Luz", "Rodriguez", "luzrz@gmail.com", "ghjf");

		unlam.agregarUsuario((Cliente) clientee);

		unlam.loguearUsuario("luzrz@gmail.com", "fdg");

	}

	@Test
	public void testQueElimineUnUsuario() throws UsuarioIncorrectoException {

		Perfumeria unlam = Perfumeria.getInstancia();
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

		
		assertTrue(unlam.eliminarUsuario(((Cliente) cliente3).getId()));
		
		

	}

	@Test
	public void testQueClienteRealizeCompra() throws UsuarioIncorrectoException, ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Cliente cliente = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		Producto p1 = new Producto(500.0, 15, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		unlam.agregarUsuario(cliente);
		p1.productoDisponible();
		unlam.agregarProducto(p1);
		unlam.loguearUsuario("margz@gmail.com", "abc10");
		Venta v1 = new Venta(cliente, p1);
		unlam.agregarVenta(v1);

		assertTrue(unlam.venderConEfectivo(cliente, p1.getId()));

	}

	@Test
	public void testQueBusqueProductoPorId() throws ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Producto p1 = new Producto(500.0, 15, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		p1.productoDisponible();
		unlam.agregarProducto(p1);

		assertEquals(p1, unlam.buscarProductoPorId(p1.getId()));

	}

	@Test
	public void testQueElClienteCierreSesion() {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Usuario cl1 = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		unlam.agregarUsuario((Cliente) cl1);

		unlam.cerrarSesion();
		assertTrue(unlam.getSesionAbierta());

	}

	@Test(expected = UsuarioIncorrectoException.class)
	public void testQueNoSePuedaEliminarUsuario() throws UsuarioIncorrectoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Usuario cl1 = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		unlam.agregarUsuario((Cliente) cl1);
		unlam.eliminarUsuario(123);

	}

	@Test(expected = ProductoNoEncontradoException.class)
	public void testQueNoPuedaEncontrarProducto() throws ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Producto p1 = new Producto(48.0, 9, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		p1.productoDisponible();
		unlam.agregarProducto(p1);
		unlam.buscarProductoPorId(6487);

	}

	@Test(expected = CompraNoEncontradaException.class)
	public void testQueNoSePuedaAnularCompra()
			throws CompraNoEncontradaException, UsuarioIncorrectoException, ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Cliente cliente = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		Producto p1 = new Producto(500.0, 15, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		unlam.agregarUsuario(cliente);
		p1.productoDisponible();
		unlam.agregarProducto(p1);
		unlam.loguearUsuario("margz@gmail.com", "abc10");
		Venta v1 = new Venta(cliente, p1);
		unlam.agregarVenta(v1);

		unlam.venderConEfectivo(cliente, p1.getId());

		unlam.anularCompra(456);

	}

	@Test
	public void testQueSePuedaAnularCompra()
			throws CompraNoEncontradaException, UsuarioIncorrectoException, ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Cliente cliente = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		Producto p1 = new Producto(500.0, 15, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		unlam.agregarUsuario(cliente);
		p1.productoDisponible();
		unlam.agregarProducto(p1);
		unlam.loguearUsuario("margz@gmail.com", "abc10");
		Venta v1 = new Venta(cliente, p1);
		unlam.agregarVenta(v1);

		unlam.venderConEfectivo(cliente, p1.getId());

		assertTrue(unlam.anularCompra(v1.getIdVenta()));

	}

	@Test(expected = UsuarioIncorrectoException.class)
	public void testQueNoSePuedaCompra() throws UsuarioIncorrectoException, ProductoNoEncontradoException {

		Perfumeria unlam = new Perfumeria("UNLAM");
		Cliente cliente = new Cliente("Marta", "Guzman", "margz@gmail.com", "abc10");
		Producto p1 = new Producto(500.0, 15, "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES");
		unlam.agregarUsuario(cliente);
		unlam.agregarProducto(p1);
		unlam.loguearUsuario("m@gmail.com", "abc10");
		Venta v1 = new Venta(cliente, p1);
		unlam.agregarVenta(v1);

	}

	@Test
	public void testQueObtengaPuntosDeUnUsuario() {
		Perfumeria unlam = new Perfumeria("UNLAM");
		Cliente cliente = new Cliente("Maria", "Gutierrez", "mariaguti@hotmail.com", "opqr789");
		unlam.agregarUsuario(cliente);
		Integer puntos = 0;
		puntos = unlam.obtenerPuntosDeUnCliente(cliente);
		assertTrue(puntos != -1);
	}

}
