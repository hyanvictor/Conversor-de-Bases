package sistema;

import java.util.ArrayList;
import java.util.List;

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
	
	public static StringBuilder converterDeDecimal(int numeroDecimal, int baseDestino) {
		List<Integer> listaRestos = new ArrayList<>();
		StringBuilder resultadoDestino = new StringBuilder();
		
		while(numeroDecimal > 0) {
			int resultadoD = numeroDecimal % baseDestino;
			listaRestos.add(resultadoD);
			
			numeroDecimal = numeroDecimal / baseDestino;
		}
				
		int tamanhoListaR = listaRestos.size();
		
		for (int i = tamanhoListaR - 1; i >= 0; i--) {
			int restoAtual = listaRestos.get(i);
			char letra = (char) restoAtual;
		
			letra = (char) (restoAtual + 55);
			
			if (restoAtual <= 9) {
				resultadoDestino.append(restoAtual);
			} else {
				resultadoDestino.append(letra);
			}
		}
		return resultadoDestino;
	}

	public static void main(String[] args) {
		System.out.println(converterDeDecimal(128, 16));
	}
}
