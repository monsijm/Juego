package Interfaces;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 * @param <T>
 */
public interface IVector<T> {

	/**
	 * Dice el numero de elementos que hay
	 * 
	 * @return numElements
	 */
	public int numElementos();

	/**
	 * Devuelve el elemento que esta en la posicion dada, sino devuelve null
	 * 
	 * @param posicion
	 * @return t elemento
	 */
	public T devolverElemento(int posicion);

	/**
	 * Inserta en la primera posicion
	 * 
	 * @param t
	 * @return true or false
	 */
	public boolean insertar(T t);

	/**
	 * Inserta en la posicion indicada, sino se insertara el primero
	 * 
	 * @param posicion
	 * @param t
	 * @return true or false
	 */
	public boolean insertar(int posicion, T t);

	/**
	 * Elimina el elemento que esta en una posicion determinada, compactando la
	 * estructura si es necesario
	 * 
	 * @param posicion
	 * @return true or false
	 */
	public boolean eliminar(int posicion);

}
