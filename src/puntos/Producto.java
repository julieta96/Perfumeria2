package puntos;

public class Producto {
	
	private Double precio;
	private Integer punto;
	private Integer id;
	private String descripcion;
	private Boolean estado;

	public Producto(Double precio , Integer punto , String descripcion) {
		
		this.precio=precio;
		this.punto=punto;
		this.id=(int)(Math.random()*200)+1;
		this.descripcion=descripcion;
		this.estado=false;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getPunto() {
		return punto;
	}

	public void setPunto(Integer punto) {
		this.punto = punto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Boolean productoDisponible() {
		if(this.estado==false) {
			this.estado=true;
		}
		
		return this.estado;
	}
	
	public Boolean productoNoDisponible() {
		
		return this.estado=false;
	}

}
