package sistema;

import java.util.ArrayList;
import java.util.List;

public class Conversor {

    /**
     * Converte uma String representando um número em qualquer base (2 a 16) para Decimal.
     */
    public static int converterParaDecimal(String numero, int base) {
        if (numero == null || numero.trim().isEmpty()) {
            return 0;
        }

        numero = numero.trim().toUpperCase();
        int potencia = 0;
        int resultado = 0;
        int tamanhoDaString = numero.length();

        for (int i = tamanhoDaString - 1; i >= 0; i--) {
            char caracter = numero.charAt(i);
            int valorDecimalDoCaracter = Character.digit(caracter, base);
            resultado += (int) (valorDecimalDoCaracter * Math.pow(base, potencia));
            potencia++;
        }
        return resultado;
    }

    /**
     * Converte um valor inteiro Decimal para uma String representada na base de destino (2 a 16).
     */
    public static String converterDeDecimal(int numeroDecimal, int baseDestino) {
        if (numeroDecimal == 0) {
            return "0";
        }

        List<Integer> listaRestos = new ArrayList<>();
        StringBuilder resultadoDestino = new StringBuilder();

        int temp = Math.abs(numeroDecimal);

        while (temp > 0) {
            int resto = temp % baseDestino;
            listaRestos.add(resto);
            temp = temp / baseDestino;
        }

        for (int i = listaRestos.size() - 1; i >= 0; i--) {
            int restoAtual = listaRestos.get(i);
            if (restoAtual <= 9) {
                resultadoDestino.append(restoAtual);
            } else {
                char letra = (char) (restoAtual + 55); // 10 -> 'A', 11 -> 'B', etc.
                resultadoDestino.append(letra);
            }
        }

        return resultadoDestino.toString();
    }
}