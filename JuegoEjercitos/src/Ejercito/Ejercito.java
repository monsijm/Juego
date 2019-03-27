package Ejercito;

import java.util.Random;

import Controladores.ControllerIVector;
import Interfaces.IVector;
import Personajes.Guerrero;
import Personajes.Jefe;
import Personajes.Personaje;

/**
 * @author Simon Jarillo
 * 
 * @since 27/03/2019
 */
public class Ejercito {

	private IVector<Personaje> ejercito;
	private String nombre;

	public Ejercito(String nombre) {
		Random rnd = new Random();
		this.nombre = nombre;
		ejercito = new ControllerIVector<>(rnd.nextInt(4) + 3);
		insertarPersonajes();
	}

	/**
	 * Devuelve si queda algun guerrero vivo
	 * 
	 * @return true or false
	 */
	public boolean supervivientes() {
		boolean supervivientes = false;

		for (int i = 0; i < ejercito.numElementos() - 1; i++) { // numElementos - 1, porque el ultimo es el jefe
			if (ejercito.devolverElemento(i).getVida() > 0) {
				supervivientes = true;
			}
		}

		return supervivientes;
	}

	/**
	 * Devuelve si el ejercito es derrotado, esta condicion se da cuando el jefe es
	 * derrotado
	 * 
	 * @return true or false
	 */
	public boolean ejercitoDerrotado() {
		boolean derrotado = false;

		if (ejercito.devolverElemento(ejercito.numElementos() - 1).getVida() <= 0
				&& ((Jefe) ejercito.devolverElemento(ejercito.numElementos() - 1)).getVidaExtra() <= 0) {
			derrotado = true;
		}

		return derrotado;
	}

	/**
	 * Realiza un ataque de forma aleatoria. El daño del ataque es entre [0-10]
	 */
	public void recibirAtaque() {
		Random rnd = new Random();

		if (supervivientes()) {
			int temp = rnd.nextInt(ejercito.numElementos() - 1);
			if (ejercito.devolverElemento(temp).getVida() > 0) {
				ejercito.devolverElemento(temp).setDamage(rnd.nextInt(11));
			}
		} else {
			if (ejercito.devolverElemento(ejercito.numElementos() - 1).getVida() > 0) {
				ejercito.devolverElemento(ejercito.numElementos() - 1).setDamage(rnd.nextInt(11));
			} else {
				((Jefe) ejercito.devolverElemento(ejercito.numElementos() - 1)).setDamageExtra(rnd.nextInt(11));
			}
		}

	}

	/**
	 * Muestra toda la informacion del ejercito
	 * 
	 * @return info ejercito
	 */
	public String toString() {
		StringBuffer temp = new StringBuffer("Ejercito " + nombre + "\n");

		for (int i = 0; i < ejercito.numElementos(); i++) {
			temp.append(ejercito.devolverElemento(i).toString() + "\n");
		}

		return temp.toString();
	}

	// Metodos privados

	/**
	 * Inserta los personajes en el ejercito
	 */
	@SuppressWarnings("rawtypes")
	private void insertarPersonajes() {
		ejercito.insertar(new Jefe());
		for (int i = 1; i < ((ControllerIVector) ejercito).length(); i++) {
			ejercito.insertar(new Guerrero());
		}
	}

	public String getNombre() {
		return nombre;
	}

}
