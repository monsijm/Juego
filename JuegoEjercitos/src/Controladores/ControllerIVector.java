package Controladores;

import Interfaces.IVector;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 * @param <T>
 */
public class ControllerIVector<T> implements IVector<T> {

	private T[] vector;
	private int numElemts;

	@SuppressWarnings("unchecked")
	public ControllerIVector(int tamMaximo) {
		if (tamMaximo > 0) {
			vector = (T[]) new Object[tamMaximo];
		} else {
			vector = (T[]) new Object[5];
		}
		numElemts = 0;
	}

	@Override
	public int numElementos() {
		return numElemts;
	}

	@Override
	public T devolverElemento(int posicion) {
		T temp = null;

		if (posicion >= 0 && posicion < numElemts) {
			temp = vector[posicion];
		}

		return temp;
	}

	@Override
	public boolean insertar(T t) {
		boolean insertado = false;

		if (numElemts >= 0 && numElemts < vector.length) {
			if (numElemts != 0) {
				crearEspacio(0);
			}
			vector[0] = t;
			insertado = true;
			numElemts++;
		}

		return insertado;
	}

	@Override
	public boolean insertar(int posicion, T t) {
		boolean insertado = false;
		
		if (posicion >= 0 && posicion < numElemts) {
			if (posicion == 0) {
				insertar(t);
			}else {
				crearEspacio(posicion);
				vector[posicion] = t;
				numElemts++;
				insertado = true;
			}
		}
		
		return insertado;
	}

	@Override
	public boolean eliminar(int posicion) {
		boolean eliminado = false;
		
		if (posicion >= 0 && posicion < numElemts) {
			vector[posicion] = null;
			agrupar(posicion);
			eliminado = true;
			numElemts--;
		}
		
		return eliminado;
	}
	
	public int length() {
		return vector.length;
	}

	// Metodos privados, que facilitan los otros metodos

	private void crearEspacio(int fin) {
		for (int i = numElemts; i > fin; i--) {
			vector[i] = vector[i - 1];
		}
	}
	
	private void agrupar(int comienzo) {
		for (int i = comienzo + 1; i < numElemts; i++) {
			if (vector[i] != null) {
				vector[i - 1] = vector[i];
			}
		}
	}

}
