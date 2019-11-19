package puntos;

public interface Vende {
	
	public Boolean venderConPuntos(Cliente c, Integer idP , Integer puntos) throws ProductoNoEncontradoException;
	public Boolean venderConEfectivo(Cliente c, Integer idP) throws  ProductoNoEncontradoException;

}