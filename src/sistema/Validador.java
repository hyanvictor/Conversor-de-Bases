package sistema;

public class Validador {

    /**
     * Verifica se uma String de entrada é válida para determinada base numérica.
     */
    public static boolean validarEntrada(String entrada, int base) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return false;
        }

        String texto = entrada.trim().toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            int valor = Character.digit(c, base);

            // Character.digit retorna -1 se o caractere não for um dígito válido na base
            if (valor == -1 || valor >= base) {
                return false;
            }
        }
        return true;
    }
}