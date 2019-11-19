package puntos;

public class Cliente extends Usuario implements Comparable <Cliente>{

	private Integer puntos;

	public Cliente(String nombre, String apellido, String email, String password) {
		super(nombre, apellido, email, password);

		this.puntos = 0;

	}
	
	public Cliente () {
		
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		return true;
	}


	@Override
	public int compareTo(Cliente c1) {
		
		return this.getNombre().compareTo(c1.getNombre());
	}

}
