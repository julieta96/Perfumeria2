package menu;

import java.util.Scanner;
import puntos.Cliente;
import puntos.CompraNoEncontradaException;
import puntos.Perfumeria;
import puntos.Producto;
import puntos.ProductoNoEncontradoException;
import puntos.UsuarioIncorrectoException;
import puntos.Venta;

public class Menu {

	public static void main(String[] args)
			throws UsuarioIncorrectoException, CompraNoEncontradaException, ProductoNoEncontradoException {

		Scanner teclado = new Scanner(System.in);

	
		Integer i = 0;
		String nombrePerfumeria = "UNLAM";
		char categorias = ' ';
		String categoriaElegida = " ";
		Integer opcionesCategorias = 14;
		Integer pCod = 0;
		String nombre = " ";
		String apellido = " ";
		String email = " ";
		String password = " ";
		Integer id = 1545;
		Perfumeria miPerfumeria = new Perfumeria(nombrePerfumeria);
		
		System.out.println("\t********MENU********\t"+"\n");
		System.out.println("Siga los siguientes pasos :\n");
		System.out.println("1.Registrese\n");
		
		System.out.println("Ingrese nombre:");
		nombre = teclado.next();
		System.out.println("Ingrese apellido:");
		apellido = teclado.next();
		System.out.println("Ingrese email:");
		email = teclado.next();
		System.out.println("Ingrese password:");
		password = teclado.next();
		System.out.println("\t*******************\t");
		Cliente cliente = new Cliente(nombre, apellido, email, password , id);
		miPerfumeria.agregarUsuario(cliente);
		System.out.println("2.Inicie Sesion\n");
		
		System.out.println("Email:");
		email = teclado.next();
		System.out.println("Password:");
		password = teclado.next();
		System.out.println("estado de ingreso: " + miPerfumeria.loguearUsuario(email, password));
		if (miPerfumeria.loguearUsuario(email, password) == true) {

			do {
				i++;
				System.out.println("\t Bienvenido a Perfumeria " + nombrePerfumeria + "\t");
				System.out.println("------------");
				System.out.println("Elija categoria del producto que desea buscar:");
				System.out.println("a.fragancia");
				System.out.println("b.cosmetico");
				System.out.println("c.limpieza");
				System.out.println("------------");
				System.out.println("3.VER TOTAL DE PUNTOS");
				System.out.println("4.CERRAR SESION");
				System.out.println("5.ELIMINAR CUENTA");
				categorias = teclado.next().charAt(0);
				switch (categorias) {

				case 'a':
					System.out.println("Tenemos fragancias para:");
					System.out.println("Mujer/Hombre/Niños");
					System.out.println("Ingrese la categoria deseada... ");
					categoriaElegida = teclado.next();
                     /**********MUJER*****/
					if (categoriaElegida.equalsIgnoreCase("mujer")) {
						System.out.println("\t*******************\t");
						Double precio1 = 3200.0;
						String descripcion1 = "FRAGANCIA WORLD EDT KENZO";
						Integer puntos1=10455;
						Producto fragancia1 = new Producto(precio1, puntos1, descripcion1);
						fragancia1.productoDisponible();
						System.out.println("(" + fragancia1.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos1);
						System.out.println("\t*******************\t");
						Double precio2 = 3500.0;
						String descripcion2 = "LADY MILLION LUCKY EDP PACO RABANNE";
						Integer puntos2=20420;
						Producto fragancia2 = new Producto(precio2, puntos2, descripcion2);
						fragancia2.productoDisponible();
						System.out.println("(" + fragancia2.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos2);
						System.out.println("\t*******************\t");
						Double precio3 = 3800.0;
						String descripcion3 = "XS BLACK HER EDP PACO RABANNE";
						Integer puntos3 = 30245;
						Producto fragancia3 = new Producto(precio3, puntos3, descripcion3);
						fragancia3.productoDisponible();
						System.out.println("(" + fragancia3.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos3);
						miPerfumeria.agregarProducto(fragancia1);
						miPerfumeria.agregarProducto(fragancia2);
						miPerfumeria.agregarProducto(fragancia3);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						

					}
					
					                             /*****HOMBRE***/
					if (categoriaElegida.equalsIgnoreCase("hombre")) {

						System.out.println("\t*******************\t");
						Double precio1 = 4200.0;
						String descripcion1 = "POLO BLUE ULTRABLUE ";
						Integer puntos4= 15123;
						Producto fragancia4 = new Producto(precio1, puntos4, descripcion1);
						System.out.println("(" + fragancia4.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos4);
						System.out.println("\t*******************\t");
						Double precio2 = 6500.0;
						String descripcion2 = "KENZO HOMME EDP";
						Integer puntos5=4450;
						Producto fragancia5 = new Producto(precio2, puntos5, descripcion2);
						System.out.println("(" + fragancia5.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos5);
						System.out.println("\t*******************\t");
						Double precio3 = 700.0;
						String descripcion3 = "MEN OCEAN EDT ALTAI";
						Integer puntos6=5455;
						Producto fragancia6 = new Producto(precio3, puntos6, descripcion3);
						System.out.println("(" + fragancia6.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos6);
						miPerfumeria.agregarProducto(fragancia4);
						miPerfumeria.agregarProducto(fragancia5);
						miPerfumeria.agregarProducto(fragancia6);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}
              
					              /******NIÑOS********/
					if (categoriaElegida.equalsIgnoreCase("niños")) {

						System.out.println("\t*******************\t");
						Double precio1 = 500.0;
						String descripcion1 = "DISNEY PRINCESA PERFUME MANZANA BLANCANIEVES";
						Integer puntos7 = 156;
						Producto fragancia7 = new Producto(precio1, puntos7, descripcion1);
						System.out.println("(" + fragancia7.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos7);
						System.out.println("\t*******************\t");
						Double precio2 = 300.0;
						String descripcion2 = "PACO FUTBOL EDT 60ML";
						Integer puntos8=1042;
						Producto fragancia8 = new Producto(precio2, puntos8, descripcion2);
						System.out.println("(" + fragancia8.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos8);
						System.out.println("\t*******************\t");
						Double precio3 = 280.0;
						String descripcion3 = "DANIELLE MY LITTLE LATA";
						Integer puntos9=1548;
						Producto fragancia9 = new Producto(precio3, puntos9, descripcion3);
						System.out.println("(" + fragancia9.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos9);
						miPerfumeria.agregarProducto(fragancia7);
						miPerfumeria.agregarProducto(fragancia8);
						miPerfumeria.agregarProducto(fragancia9);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}

					break;

				case 'b':
					System.out.println("Comestico para:");
					System.out.println("rostro/ojos/labios");
					System.out.println("Ingrese la categoria deseada... ");
					categoriaElegida = teclado.next();
					
					                 /***********ROSTRO***********/
					if (categoriaElegida.equalsIgnoreCase("rostro")) {

						System.out.println("\t*******************\t");
						Double precio1 = 450.0;
						String descripcion1 = "BASE MULTIUSO MAYBELLINE SUPER STAY 24HS TOOL STICK 312 GOLDEN X 7G";
						Integer puntos10 = 2156;
						Producto cosmetico1 = new Producto(precio1, puntos10, descripcion1);
						System.out.println("(" + cosmetico1.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos10);
						System.out.println("\t*******************\t");
						Double precio2 = 320.0;
						String descripcion2 = "BASE EN POLVO MAYBELLINE BETTER SKIN X 9G";
						Integer puntos11 = 1565;
						Producto cosmetico2 = new Producto(precio2, puntos11, descripcion2);
						System.out.println("(" + cosmetico2.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos11);
						System.out.println("\t*******************\t");
						Double precio3 = 550.0;
						String descripcion3 = "INFALLIBLE PRO-MATTE 24HS NATURAL BUFF 103 ";
						Integer puntos12=4856;
						Producto cosmetico3 = new Producto(precio3, puntos12, descripcion3);
						System.out.println("(" + cosmetico3.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos12);
						miPerfumeria.agregarProducto(cosmetico1);
						miPerfumeria.agregarProducto(cosmetico2);
						miPerfumeria.agregarProducto(cosmetico3);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						

					}
					
					/***********OJOS*****/

					if (categoriaElegida.equalsIgnoreCase("ojos")) {

						System.out.println("\t*******************\t");
						Double precio1 = 400.0;
						String descripcion1 = "VOLUME MILLION LASHES WTP BLACK";
						Integer puntos13 = 475;
						Producto cosmetico4 = new Producto(precio1, puntos13, descripcion1);
						System.out.println("(" + cosmetico4.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos13);
						System.out.println("\t*******************\t");
						Double precio2 = 360.0;
						String descripcion2 = "Scandal'Eyes Reloaded Volume Extreme Black ";
						Integer puntos14 = 589;
						Producto cosmetico5 = new Producto(precio2, puntos14, descripcion2);
						System.out.println("(" + cosmetico5.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos14);
						System.out.println("\t*******************\t");
						Double precio3 = 380.0;
						String descripcion3 = "SOMBRA DE OJOS THE CITY MINI PALETTE GRAFFITI POPS";
						Integer puntos15=545;
						Producto cosmetico6 = new Producto(precio3, puntos15, descripcion3);
						System.out.println("(" + cosmetico6.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos15);
						miPerfumeria.agregarProducto(cosmetico4);
						miPerfumeria.agregarProducto(cosmetico5);
						miPerfumeria.agregarProducto(cosmetico6);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						

					}
                      
					            /******LABIOS****/
					if (categoriaElegida.equalsIgnoreCase("labios")) {

						System.out.println("\t*******************\t");
						Double precio1 = 335.0;
						String descripcion1 = "ULTRA HD LABIAL LIQUIDO MATTE 620 REVLON";
						Integer puntos16 = 456;
						Producto cosmetico7 = new Producto(precio1, puntos16, descripcion1);
						System.out.println("(" + cosmetico7.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos16);
						System.out.println("\t*******************\t");
						Producto codProducto2 = null;
						Double precio2 = 325.0;
						String descripcion2 = "LABIAL ONLY MATE 810-BORDX";
						Integer puntos17 = 489;
						Producto cosmetico8 = new Producto(precio2, puntos17, descripcion2);
						System.out.println("(" + cosmetico8.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos17);
						System.out.println("\t*******************\t");
						Double precio3 = 200.0;
						String descripcion3 = "LASTING FINISH LIPSTICK Airy Fairy";
						Integer puntos18 = 165;
						Producto cosmetico9 = new Producto(precio3, puntos18, descripcion3);
						System.out.println("(" + cosmetico9.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos18);
						miPerfumeria.agregarProducto(cosmetico7);
						miPerfumeria.agregarProducto(cosmetico8);
						miPerfumeria.agregarProducto(cosmetico9);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}

					break;

				case 'c':

					System.out.println("Limpieza para:");
					System.out.println("ropa/cocina/muebles");
					System.out.println("Ingrese la categoria deseada... ");
					categoriaElegida = teclado.next();
					
					/****************************ROPA**************************************/
					if (categoriaElegida.equalsIgnoreCase("ropa")) {

						System.out.println("\t*******************\t");
						Double precio1 = 425.0;
						String descripcion1 = "SKIP JABON PARA ROPA LIQUIDO BAJA ESPUMA LAVARROPAS 3 LT";
						Integer puntos19 = 956;
						Producto limpieza1 = new Producto(precio1, puntos19, descripcion1);
						System.out.println("(" + limpieza1.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos19);
						System.out.println("\t*******************\t");
						Double precio2 = 80.0;
						String descripcion2 = "PRE-LAVADO VANISH PODER O2 REPUESTO 400 ML";
						Integer puntos20 = 736;
						Producto limpieza2 = new Producto(precio2, puntos20, descripcion2);
						System.out.println("(" + limpieza2.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos20);
						System.out.println("\t*******************\t");
						Double precio3 = 260.0;
						String descripcion3 = "JABÓN LÍQUIDO PARA ROPA ARIEL CONCENTRADO 1,2 L RECARGA";
						Integer puntos21=756;
						Producto limpieza3 = new Producto(precio3, puntos21, descripcion3);
						System.out.println("(" + limpieza3.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos21);
						miPerfumeria.agregarProducto(limpieza1);
						miPerfumeria.agregarProducto(limpieza2);
						miPerfumeria.agregarProducto(limpieza3);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}
					
					/*************************COCINA**************************/

					if (categoriaElegida.equalsIgnoreCase("cocina")) {

						System.out.println("\t*******************\t");
						Double precio1 = 80.0;
						String descripcion1 = "DETERGENTE ESPUMA ACTIVA MAGISTRAL LIMON X 500ML";
						Integer puntos22 = 566;
						Producto limpieza4 = new Producto(precio1, puntos22, descripcion1);
						System.out.println("(" + limpieza4.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos22);
						System.out.println("\t*******************\t");
						Double precio2 = 100.0;
						String descripcion2 = "AYUDIN COCINA GATILLO ";
						Integer puntos23 = 453;
						Producto limpieza5 = new Producto(precio2, puntos23, descripcion2);
						System.out.println("(" + limpieza5.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos23);
						System.out.println("\t*******************\t");
						Double precio3 = 70.0;
						String descripcion3 = "LIMPIADOR ANTIGRASA LYSOFORM ";
						Integer puntos24 = 869;
						Producto limpieza6 = new Producto(precio3, puntos24, descripcion3);
						System.out.println("(" + limpieza6.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos24);
						miPerfumeria.agregarProducto(limpieza4);
						miPerfumeria.agregarProducto(limpieza5);
						miPerfumeria.agregarProducto(limpieza6);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}
					
					/***********************MUEBLES*********************/

					if (categoriaElegida.equalsIgnoreCase("muebles")) {

						System.out.println("\t*******************\t");
						Double precio1 = 125.0;
						String descripcion1 = "LUSTRAMUEBLES AEROSOL NARANJA BLEM ";
						Integer puntos25 = 678;
						Producto limpieza7 = new Producto(precio1, puntos25, descripcion1);
						System.out.println("(" + limpieza7.getId() + ")" + descripcion1);
						System.out.println("precio = " + precio1);
						System.out.println("puntos = " + puntos25);
						System.out.println("\t*******************\t");
						Double precio2 = 100.0;
						String descripcion2 = "LUESTRAMUEBLES AEROSOL CERAMICOL";
						Integer puntos26 = 859;
						Producto limpieza8 = new Producto(precio2, puntos26, descripcion2);
						System.out.println("(" + limpieza8.getId() + ")" + descripcion2);
						System.out.println("precio = " + precio2);
						System.out.println("puntos = " + puntos26);
						System.out.println("\t*******************\t");
						Double precio3 = 125.0;
						String descripcion3 = "LUSTRAMUEBLES AEROSOL LAVANDA BLEM ";
						Integer puntos27 = 875;
						Producto limpieza9 = new Producto(precio3, puntos27, descripcion3);
						System.out.println("(" + limpieza9.getId() + ")" + descripcion3);
						System.out.println("precio = " + precio3);
						System.out.println("puntos = " + puntos27);
						miPerfumeria.agregarProducto(limpieza7);
						miPerfumeria.agregarProducto(limpieza8);
						miPerfumeria.agregarProducto(limpieza9);
						System.out.println("\t*******************\t");
						System.out.println("Si desea comprar ingrese el codigo del producto:");
						pCod = teclado.nextInt();
						Venta v1 = new Venta(cliente, miPerfumeria.buscarProductoPorId(pCod));
						miPerfumeria.agregarVenta(v1);
						System.out.println("*Si realiza una compra en efectivo ingrese: f ");
						System.out.println("*Si realiza una compra con puntos ingrese: p "
								+ "(si desea comprar con puntos , 1ero debe realizar 1 compra , si aun no a comprado no podra realizar este tipo de pago.)");
						char opcionDeCompra = teclado.next().charAt(0);
						if (opcionDeCompra == 'f') {
						if (miPerfumeria.venderConEfectivo(cliente,
								pCod) == true) {

							System.out.println("Compra exitosa");
							System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
							System.out.println("¿Desea cancelar compra?");
							System.out.println("Ingrese : 'si' o 'no'");
							String respuesta = teclado.next();
							if (respuesta.equalsIgnoreCase("si")) {
								System.out.println("Ingrese codigo de Venta:");
								Integer cVenta = teclado.nextInt();

								if (miPerfumeria.anularCompra(cVenta) == true) {
									System.out.println("compra anulada");
								} else {

									throw new CompraNoEncontradaException();

								}

							}

							if (respuesta.equalsIgnoreCase("no")) {
								System.out.println("¡GRACIAS POR SU COMPRA!");
								cliente.setPuntos(cliente.getPuntos()+miPerfumeria.buscarProductoPorId(pCod).getPunto());
							}
						} else {

							System.err.println("No se pudo realizar la compra");
							System.err.println("Razones:");
							System.err.println(
									"Puede que haya ingresado el codigo del producto de forma incorrecta");
							System.err.println("Intente mas tarde");

						} }
						
						if (opcionDeCompra == 'p') {
							
							System.out.println("Ingrese los puntos del producto a cangear:");
							Integer puntosACangear = teclado.nextInt();
							
							if(cliente.getPuntos()!=0) {
								
							
;							
							if (miPerfumeria.venderConPuntos(cliente,
									pCod , puntosACangear) == true) {

								System.out.println("Compra exitosa");
								System.out.println("Cod.De Venta" + "(" + v1.getIdVenta() + ")");
								System.out.println("¿Desea cancelar compra?");
								System.out.println("Ingrese : 'si' o 'no'");
								String respuesta = teclado.next();
								if (respuesta.equalsIgnoreCase("si")) {
									System.out.println("Ingrese codigo de Venta:");
									Integer cVenta = teclado.nextInt();

									if (miPerfumeria.anularCompra(cVenta) == true) {
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
										"Puede que haya ingresado el codigo del producto de forma incorrecta");
								System.err.println("Intente mas tarde");

							} }else if (cliente.getPuntos()==0){
								System.err.println("Lo siento , aun no contiene puntos , 1ero debe realiza una compra en efectivo");
							}
						
						}
						
						
					}

					break;
				case '3' :
					System.out.println("Recuerde que para canjear productos con puntos de realizar al menos 1 compra");
					System.out.println("Total de puntos para canjear: "+cliente.getPuntos());
					break;
					
				case '4':
					miPerfumeria.cerrarSesion();
					if(miPerfumeria.getSesionAbierta() ==false) {
						System.out.println("SESION CERRADA");
					}
					break;
					
				case '5':
					if(miPerfumeria.eliminarUsuario(id)==true) {
						miPerfumeria.cerrarSesion();
						if(miPerfumeria.getSesionAbierta() ==false) {
							System.out.println("CUENTA ELIMINADA");
						}
						
					}
					break;
				default:
					System.err.println("error , categoria inexistente");

				}

			} while ((i< opcionesCategorias) && (miPerfumeria.getSesionAbierta()==true));
			
			

		}

		
		
		


	}

}
