package clases;

public enum Sexo {
	MASCULINO, FEMENINO, OTROS;

	public static void mostrar(String textRadio) {

		for (Sexo tipo : Sexo.values()) {// mostrara la lista de generos que tenemos
			System.out.printf("%s \t", tipo.toString(), "\n");

		}

	}
}