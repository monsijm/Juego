package Personajes;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 */
public class Guerrero extends Personaje {

	private final static char starCodigo = '2'; // Todos los guerreros comienzan en 2
	private static int finalCodigo = 0;

	public Guerrero() {
		super(generarCodigo(), 15);
		finalCodigo++;
	}

	/**
	 * Metodo que genera el codigo para el guerrero, codigo que nunca se repite
	 * 
	 * @return codigo
	 */
	private static String generarCodigo() {
		return starCodigo + Integer.toString(finalCodigo);
	}

}
