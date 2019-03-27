package Personajes;

/**
 * 
 * @author Simon Jarillo
 * @since 27/03/2019
 */
public abstract class Personaje {

	private String codigo;
	private int vida;

	protected Personaje(String codigo, int vida) {
		this.codigo = codigo;
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Codigo de personaje: " + codigo + " vida: " + vida;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getVida() {
		return vida;
	}

	public void setDamage(int damage) {
		vida -= damage;
	}

}
