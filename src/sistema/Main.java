package sistema;

public class Main {
	public static int converterParaDecimal(String numero, int base) {
		int potencia = 0;
		int resultado = 0;
		int tamanhoDaString = numero.length();

		for (int i = tamanhoDaString - 1; i >= 0; i--) {
				char numeroP = numero.charAt(i);
				int numeroP2 = Character.getNumericValue(numeroP);
				resultado += (int) (numeroP2 * Math.pow(base, potencia));
				potencia += 1;
		}
		return resultado;
	}

	public static void main(String[] args) {
		System.out.println(converterParaDecimal("55", 8));
	}
}
