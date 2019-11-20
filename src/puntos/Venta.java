package puntos;

public class Venta {

	private Usuario cliente;
	private Producto producto;
	private int idVenta;
	

	public Venta(Usuario cliente , Producto producto) {
		this.cliente=cliente;
		this.producto=producto;
		this.idVenta=(int)(Math.random()*200)+1;
		
	}
	
	public Venta(String e , Integer idP) {
		this.cliente.getEmail().equals(e);
		this.producto.getId().equals(idP);
		this.idVenta=(int)(Math.random()*200)+1;
		
	}
	
	public Venta () {
		
	}

	public Venta(String nombre, String apellido, String email, String password,  Double precio,
			Integer punto, String descripcion) {
		this.cliente = new Cliente(nombre, apellido, email, password);
		this.producto = new Producto(precio, punto, descripcion);
		this.idVenta =(int)(Math.random()*200)+1;

	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

}

