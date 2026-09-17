package sistema;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceCalculadora calculadora = new InterfaceCalculadora();
            calculadora.setVisible(true);
        });
    }
}