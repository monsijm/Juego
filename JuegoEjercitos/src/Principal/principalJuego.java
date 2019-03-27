package Principal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import Ejercito.Ejercito;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 */
public class principalJuego {

	private static Ejercito ejercito1;
	private static Ejercito ejercito2;

	public static void main(String[] args) throws IOException {

		// Java Import

		Scanner sc = new Scanner(System.in);
		ejercito1 = cargarEjercito("Ejer1");
		ejercito2 = cargarEjercito("Ejer2");

		// Variables

		int opc = -1;

		do {
			System.out.println(opcMenu());
			opc = sc.nextInt();
			realizarOpciones(opc);
			if (ejercito1.ejercitoDerrotado()) {
				System.err.println("El ejercito 1 ha sido derrotado"); // Esta puesto el err, para que el mensaje salg
																		// en rojo en la consola
			} else if (ejercito2.ejercitoDerrotado()) {
				System.err.println("El ejercito 2 ha sido derrotado"); // Esta puesto el err, para que el mensaje salg
																		// en rojo en la consola
			}
		} while (opc != 0);

		sc.close();
	}

	/**
	 * Funcion para las opciones del menu
	 * 
	 * @return String con todas las opciones
	 */
	private static String opcMenu() {
		StringBuffer menu = new StringBuffer("Las Opciones son:\n");

		menu.append("1 - Mostrar informacion de ambos Ejercitos\n");
		menu.append("2 - Atacar al Ejercito 1\n");
		menu.append("3 - Atacar al Ejercito 2\n");
		menu.append("4 - Guardar partida\n");
		menu.append("0 - Salir del programa\n");

		return menu.toString();
	}

	/**
	 * Funcion que realiza las opciones del menu
	 * 
	 * @param num
	 * @throws IOException
	 */
	private static void realizarOpciones(int num) throws IOException {
		switch (num) {
		case 1:
			System.out.println(ejercito1.toString());
			System.out.println();
			System.out.println(ejercito2.toString());
			break;
		case 2:
			ejercito1.recibirAtaque();
			break;
		case 3:
			ejercito2.recibirAtaque();
			break;
		case 4:
			guardar(ejercito1);
			guardar(ejercito2);
			break;
		default:
			System.err.println("\n\n¡La opcion introducida es erronea!\n\n"); // Esta puesto el err, para que el mensaje
																				// salg en rojo en la consola
			break;
		}
	}

	/**
	 * Funcion que carga el ejercito si existiera el fichero
	 * 
	 * @param nombre
	 * @return
	 * @throws IOException
	 */
	private static Ejercito cargarEjercito(String nombre) throws IOException {
		Ejercito temp = null;
		Path p1 = Paths.get(nombre, ".txt");

		if (Files.exists(p1)) {
			try {
				InputStream flujoEntrada = new FileInputStream(p1.toFile());
				InputStream flujoDatos = new ObjectInputStream(flujoEntrada);

				temp = (Ejercito) ((ObjectInputStream) flujoDatos).readObject();

				flujoEntrada.close();
				flujoDatos.close();

			} catch (EOFException | ClassNotFoundException | StreamCorruptedException e) {
				destruyeEjercito(nombre);
				temp = new Ejercito(nombre);
			}
		} else {
			temp = new Ejercito(nombre);
		}

		return temp;
	}

	/**
	 * Funcion para guardar los Ejercitos
	 * 
	 * @param e
	 * @throws IOException
	 */
	private static void guardar(Ejercito e) throws IOException {
		Path ejer = Paths.get(e.getNombre(), ".txt");
		OutputStream flujoSalida = new FileOutputStream(ejer.toFile()); // TODO: Aqui da fallo, y no entiendo el porque
		OutputStream flujoSalDatos = new ObjectOutputStream(flujoSalida);

		((ObjectOutputStream) flujoSalDatos).writeObject(e);

		flujoSalida.close();
		flujoSalDatos.close();
	}

	/**
	 * Funcion que destruye el ejercito
	 * 
	 * @param nombre
	 * @throws IOException
	 */
	private static void destruyeEjercito(String nombre) throws IOException {
		Path p1 = Paths.get(nombre + ".txt");
		Files.deleteIfExists(p1);
	}

}
