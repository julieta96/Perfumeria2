package menu;

import java.util.Scanner;

import puntos.Cliente;
import puntos.CompraNoEncontradaException;
import puntos.Perfumeria;
import puntos.Producto;
import puntos.UsuarioIncorrectoException;
import puntos.Venta;

public class Menu {
	public static void main(String[] args) throws UsuarioIncorrectoException, CompraNoEncontradaException {

		Scanner teclado = new Scanner(System.in);

		Integer opciones = 3;
		Integer i = 0;
		Integer menu = 0;
		Integer cantidadUsuarios = 0;
		Integer contador = 0;
		String nombrePerfumeria = "UNLAM";
		char categorias = ' ';
		String categoriaElegida = " ";
		Integer opcionesCategorias = 3;
		Integer c = 0;
		Integer pCod = 0;
		String emailC = " ";

		Perfumeria miPerfumeria = new Perfumeria(nombrePerfumeria);

		System.out.println("Ingrese cantidad de usuario:");
		cantidadUsuarios = teclado.nextInt();

		do {
			i++;
			System.out.println("\t MENU \t");
			System.out.println("1.Agregarse en el sistema");
			System.out.println("2.Loguearse");
			System.out.println("3.SALIR");
			menu = teclado.nextInt();

			switch (menu) {

			case 1:
				System.out.println("\t*******************\t");
				for (contador = 0; contador < cantidadUsuarios; contador++) {
					System.out.println((contador + 1) + ".Ingrese nombre:");
					String nombre = teclado.next();
					System.out.println((contador + 1) + ".Ingrese apellido:");
					String apellido = teclado.next();
					System.out.println((contador + 1) + ".Ingrese email:");
					String email = teclado.next();
					System.out.println((contador + 1) + ".Ingrese password:");
					String password = teclado.next();
					System.out.println("\t*******************\t");
					miPerfumeria.agregarUsuario(new Cliente(nombre, apellido, email, password));
				}
				break;

			case 2:

				System.out.println("\t*******************\t");
				for (contador = 0; contador < cantidadUsuarios; contador++) {

					System.out.println((contador + 1) + ".Email:");
					String email = teclado.next();
					System.out.println((contador + 1) + ".Password:");
					String password = teclado.next();
					System.out.println("estado de ingreso: " + miPerfumeria.loguearUsuario(email, password));
					System.out.println("\t*******************\t");
					if (miPerfumeria.loguearUsuario(email, password) == true) {

						do {
							c++;
							System.out.println("\t Bienvenido a Perfumeria " + nombrePerfumeria + "\t");
							System.out.println("Elija categoria del producto que desea buscar:");
							System.out.println("a.fragancia");
							System.out.println("b.cosmetico");
							System.out.println("c.limpieza");
							categorias = teclado.next().charAt(0);
							switch (categorias) {

							case 'a':
								System.out.println("Tenemos fragancias para:");
								System.out.println("Mujer/Hombre/Niños");
								System.out.println("Ingrese la categoria deseada... ");
								categoriaElegida = teclado.next();

								if (categoriaElegida.equalsIgnoreCase("mujer")) {
									System.out.println("\t*******************\t");
									Double precio1 = 3200.0;
									String descripcion1 = "FRAGANCIA WORLD EDT KENZO";
									Producto fragancia1 = new Producto(precio1, 15, descripcion1);
									System.out.println("(" + fragancia1.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 3500.0;
									String descripcion2 = "LADY MILLION LUCKY EDP PACO RABANNE";
									Producto fragancia2 = new Producto(precio2, 20, descripcion2);
									System.out.println("(" + fragancia2.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 3800.0;
									String descripcion3 = "XS BLACK HER EDP PACO RABANNE";
									Producto fragancia3 = new Producto(precio3, 35, descripcion3);
									System.out.println("(" + fragancia3.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									Venta v1 = new Venta (emailC ,pCod );

									if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

										System.out.println("Compra exitosa");
										System.out.println("Cod.De Venta"+"("+v1.getIdVenta()+")");
										System.out.println("¿Desea cancelar compra?");
										System.out.println("Ingrese : 'si' o 'no'");
										String respuesta = teclado.next();
										if (respuesta.equalsIgnoreCase("si")) {
                                             System.out.println("Ingrese codigo de Venta:");
                                             Integer cVenta =teclado.nextInt();
					                        
										if(miPerfumeria.anularCompra(cVenta)==true) {
													System.out.println("compra anulada");
											} else {
												
												throw new CompraNoEncontradaException();
												
											}

										}

										if (respuesta.equalsIgnoreCase("no")) {
											System.out.println("¡GRACIAS POR SU COMPRA!");
										}
									} else {

										System.err.println("No se pudo realizar la compra");
										System.err.println("Razones:");
										System.err.println(
												"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
										System.err.println("Intente mas tarde");

									}

									

								}
								if (categoriaElegida.equalsIgnoreCase("hombre")) {

									System.out.println("\t*******************\t");
									Double precio1 = 4200.0;
									String descripcion1 = "POLO BLUE ULTRABLUE ";
									Producto fragancia4 = new Producto(precio1, 15, descripcion1);
									System.out.println("(" + fragancia4.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 6500.0;
									String descripcion2 = "KENZO HOMME EDP";
									Producto fragancia5 = new Producto(precio2, 40, descripcion2);
									System.out.println("(" + fragancia5.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 700.0;
									String descripcion3 = "MEN OCEAN EDT ALTAI";
									Producto fragancia6 = new Producto(precio3, 5, descripcion3);
									System.out.println("(" + fragancia6.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								if (categoriaElegida.equalsIgnoreCase("niños")) {

									System.out.println("\t*******************\t");
									Double precio1 = 500.0;
									String descripcion1 = "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES";
									Producto fragancia7 = new Producto(precio1, 15, descripcion1);
									System.out.println("(" + fragancia7.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 300.0;
									String descripcion2 = "PACO FUTBOL EDT 60ML";
									Producto fragancia8 = new Producto(precio2, 10, descripcion2);
									System.out.println("(" + fragancia8.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 280.0;
									String descripcion3 = "DANIELLE MY LITTLE LATA";
									Producto fragancia9 = new Producto(precio3, 15, descripcion3);
									System.out.println("(" + fragancia9.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								break;

							case 'b':
								System.out.println("Comestico para:");
								System.out.println("rostro/ojos/labios");
								System.out.println("Ingrese la categoria deseada... ");
								categoriaElegida = teclado.next();
								if (categoriaElegida.equalsIgnoreCase("rostro")) {

									System.out.println("\t*******************\t");
									Double precio1 = 450.0;
									String descripcion1 = "BASE MULTIUSO MAYBELLINE SUPER STAY 24HS TOOL STICK 312 GOLDEN X 7G";
									Producto cosmetico1 = new Producto(precio1, 20, descripcion1);
									System.out.println("(" + cosmetico1.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 320.0;
									String descripcion2 = "BASE EN POLVO MAYBELLINE BETTER SKIN X 9G";
									Producto cosmetico2 = new Producto(precio2, 10, descripcion2);
									System.out.println("(" + cosmetico2.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 550.0;
									String descripcion3 = "INFALLIBLE PRO-MATTE 24HS NATURAL BUFF 103 ";
									Producto cosmetico3 = new Producto(precio3, 30, descripcion3);
									System.out.println("(" + cosmetico3.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								if (categoriaElegida.equalsIgnoreCase("ojos")) {

									System.out.println("\t*******************\t");
									Double precio1 = 400.0;
									String descripcion1 = "VOLUME MILLION LASHES WTP BLACK";
									Producto cosmetico4 = new Producto(precio1, 90, descripcion1);
									System.out.println("(" + cosmetico4.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 360.0;
									String descripcion2 = "Scandal'Eyes Reloaded Volume Extreme Black ";
									Producto cosmetico5 = new Producto(precio2, 80, descripcion2);
									System.out.println("(" + cosmetico5.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 380.0;
									String descripcion3 = "SOMBRA DE OJOS THE CITY MINI PALETTE GRAFFITI POPS";
									Producto cosmetico6 = new Producto(precio3, 85, descripcion3);
									System.out.println("(" + cosmetico6.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								if (categoriaElegida.equalsIgnoreCase("labios")) {

									System.out.println("\t*******************\t");
									Double precio1 = 335.0;
									String descripcion1 = "ULTRA HD LABIAL LIQUIDO MATTE 620 REVLON";
									Producto cosmetico7 = new Producto(precio1, 70, descripcion1);
									System.out.println("(" + cosmetico7.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Producto codProducto2 = null;
									Double precio2 = 325.0;
									String descripcion2 = "LABIAL ONLY MATE 810-BORDX";
									Producto cosmetico8 = new Producto(precio2, 65, descripcion2);
									System.out.println("(" + cosmetico8.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 200.0;
									String descripcion3 = "LASTING FINISH LIPSTICK Airy Fairy";
									Producto cosmetico9 = new Producto(precio3, 35, descripcion3);
									System.out.println("(" + cosmetico9.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								break;

							case 'c':

								System.out.println("Limpieza para:");
								System.out.println("ropa/cocina/muebles");
								System.out.println("Ingrese la categoria deseada... ");
								categoriaElegida = teclado.next();
								if (categoriaElegida.equalsIgnoreCase("ropa")) {

									System.out.println("\t*******************\t");
									Double precio1 = 425.0;
									String descripcion1 = "SKIP JABON PARA ROPA LIQUIDO BAJA ESPUMA LAVARROPAS 3 LT";
									Producto limpieza1 = new Producto(precio1, 25, descripcion1);
									System.out.println("(" + limpieza1.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 80.0;
									String descripcion2 = "PRE-LAVADO VANISH PODER O2 REPUESTO 400 ML";
									Producto limpieza2 = new Producto(precio2, 15, descripcion2);
									System.out.println("(" + limpieza2.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 260.0;
									String descripcion3 = "JABÓN LÍQUIDO PARA ROPA ARIEL CONCENTRADO 1,2 L RECARGA";
									Producto limpieza3 = new Producto(precio3, 20, descripcion3);
									System.out.println("(" + limpieza3.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								if (categoriaElegida.equalsIgnoreCase("cocina")) {

									System.out.println("\t*******************\t");
									Double precio1 = 80.0;
									String descripcion1 = "DETERGENTE ESPUMA ACTIVA MAGISTRAL LIMON X 500ML";
									Producto limpieza4 = new Producto(precio1, 15, descripcion1);
									System.out.println("(" + limpieza4.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 100.0;
									String descripcion2 = "AYUDIN COCINA GATILLO ";
									Producto limpieza5 = new Producto(precio2, 50, descripcion2);
									System.out.println("(" + limpieza5.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 70.0;
									String descripcion3 = "LIMPIADOR ANTIGRASA LYSOFORM ";
									Producto limpieza6 = new Producto(precio3, 20, descripcion3);
									System.out.println("(" + limpieza6.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}

									}

									if (opcionDeCompra == 'p') {

										miPerfumeria.venderConPuntos(emailC, pCod);
										if (miPerfumeria.getListaUsuarios().contains(emailC)) {

										}
									}

								}

								if (categoriaElegida.equalsIgnoreCase("muebles")) {

									System.out.println("\t*******************\t");
									Double precio1 = 125.0;
									String descripcion1 = "LUSTRAMUEBLES AEROSOL NARANJA BLEM ";
									Producto limpieza7 = new Producto(precio1, 80, descripcion1);
									System.out.println("(" + limpieza7.getId() + ")" + descripcion1);
									System.out.println("precio = " + precio1);
									System.out.println("\t*******************\t");
									Double precio2 = 100.0;
									String descripcion2 = "LUESTRAMUEBLES AEROSOL CERAMICOL";
									Producto limpieza8 = new Producto(precio2, 30, descripcion2);
									System.out.println("(" + limpieza8.getId() + ")" + descripcion2);
									System.out.println("precio = " + precio2);
									System.out.println("\t*******************\t");
									Double precio3 = 125.0;
									String descripcion3 = "LUSTRAMUEBLES AEROSOL LAVANDA BLEM ";
									Producto limpieza9 = new Producto(precio3, 80, descripcion3);
									System.out.println("(" + limpieza9.getId() + ")" + descripcion3);
									System.out.println("precio = " + precio3);
									System.out.println("\t*******************\t");
									System.out.println("Si desea comprar ingrese el codigo del producto:");
									pCod = teclado.nextInt();
									System.out.println("Y a continuacion su e-mail:");
									emailC = teclado.next();
									System.out.println("Si realiza una compra en efectivo ingrese: f ");
									System.out.println("Si realiza una compra con puntos ingrese: p ");
									char opcionDeCompra = teclado.next().charAt(0);
									if (opcionDeCompra == 'f') {
										if (miPerfumeria.venderConEfectivo(emailC, pCod) == true) {

											System.out.println("Compra exitosa");
											System.out.println("¿Desea cancelar compra?");
											System.out.println("Ingrese : 'si' o 'no'");
											String respuesta = teclado.next();
											if (respuesta.equalsIgnoreCase("si")) {

												try {
													miPerfumeria.anularCompra(pCod);
												} catch (CompraNoEncontradaException ce) {
													System.out.println(ce.getMessage());
													System.err.println("No se pudo realizar la compra");
													System.err.println("Razones:");
													System.err.println(
															"Puede que haya ingresaso el email o el codigo del producto de forma incorrecta");
													System.err.println("Intente mas tarde");

												}

											}

											if (respuesta.equalsIgnoreCase("no")) {
												System.out.println("¡GRACIAS POR SU COMPRA!");
											}
										}
									}

								}

								break;
							default:
								System.err.println("error , categoria inexistente");

							}

						} while (c < opcionesCategorias);

					}

				}

				break;

			case 3:

				System.out.println("SESION CERRADA");
				break;

			default:
				System.err.println("ERROR 404 NOT FOUND");

			}
		} while (i < opciones);
	}

}
