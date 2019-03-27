package Personajes;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 */
public class Jefe extends Personaje {

	private final static char starCodigo = '1';
	private static int finalCodigo = 0;

	private String nombre;
	private int vidaExtra;

	public Jefe(String nombre) {
		super(generarCodigo(), 20);
		this.nombre = nombre;
		generarVidaExtra();
		finalCodigo++;
	}

	public Jefe() {
		this("");
	}

	@Override
	public String toString() {
		return super.toString() + " y vida extra: " + vidaExtra;
	}

	public int getVidaExtra() {
		return vidaExtra;
	}

	public void setDamageExtra(int damage) {
		this.vidaExtra -= damage;
	}

	public String getNombre() {
		return nombre;
	}

	// Metodos Privados

	/**
	 * Metodo que genera un codigo para el jefe
	 * 
	 * @return codigo
	 */
	private static String generarCodigo() {
		return starCodigo + Integer.toString(finalCodigo);
	}

	/**
	 * Metodo que genera la vida extras
	 */
	private void generarVidaExtra() {
		int cont = 0;

		if (nombre.length() != 0) {
			for (int i = 0; i < nombre.length(); i++) {
				switch (nombre.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					cont++;
					break;
				}
			}
		}

		// Hago esto, porque no se le mete ningun nombre al jefe
		// y asi no tiene la vida extra a 0
		if (cont == 0) {
			cont = 5;
		}

		vidaExtra = cont * 3;
	}
}
