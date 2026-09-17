package sistema;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class InterfaceCalculadora extends JFrame {

    private JTextField txtBinario;
    private JTextField txtOctal;
    private JTextField txtDecimal;
    private JTextField txtHexadecimal;
    private JLabel lblStatus;

    // FLAG CRÍTICA: Impede o Event Loop (feedback em cascata)
    private boolean isUpdating = false;

    public InterfaceCalculadora() {
        super("Calculadora de Bases Numéricas");
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        // Painel Principal
        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 10, 15));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Rótulos e Campos
        JLabel lblBinario = new JLabel("Binário (Base 2):");
        txtBinario = new JTextField();

        JLabel lblOctal = new JLabel("Octal (Base 8):");
        txtOctal = new JTextField();

        JLabel lblDecimal = new JLabel("Decimal (Base 10):");
        txtDecimal = new JTextField();

        JLabel lblHexadecimal = new JLabel("Hexadecimal (Base 16):");
        txtHexadecimal = new JTextField();

        // Estilização Básica
        Font fonteCampo = new Font("Monospaced", Font.BOLD, 14);
        txtBinario.setFont(fonteCampo);
        txtOctal.setFont(fonteCampo);
        txtDecimal.setFont(fonteCampo);
        txtHexadecimal.setFont(fonteCampo);

        painelCampos.add(lblBinario);
        painelCampos.add(txtBinario);
        painelCampos.add(lblOctal);
        painelCampos.add(txtOctal);
        painelCampos.add(lblDecimal);
        painelCampos.add(txtDecimal);
        painelCampos.add(lblHexadecimal);
        painelCampos.add(txtHexadecimal);

        // Painel do Botão Limpar e Status
        JPanel painelInferior = new JPanel(new BorderLayout(5, 5));
        painelInferior.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));

        lblStatus = new JLabel("Digite um número em qualquer base.", SwingConstants.CENTER);
        lblStatus.setForeground(Color.GRAY);

        JButton btnLimpar = new JButton("Limpar Campos");
        btnLimpar.addActionListener(e -> limparCampos());

        painelInferior.add(lblStatus, BorderLayout.NORTH);
        painelInferior.add(btnLimpar, BorderLayout.SOUTH);

        add(painelCampos, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        // Registrar Listeners para Reatividade Instantânea
        adicionarOuvinte(txtBinario, 2);
        adicionarOuvinte(txtOctal, 8);
        adicionarOuvinte(txtDecimal, 10);
        adicionarOuvinte(txtHexadecimal, 16);
    }

    private void adicionarOuvinte(JTextField campoOrigem, int baseOrigem) {
        campoOrigem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                processarMudanca();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processarMudanca();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                processarMudanca();
            }

            private void processarMudanca() {
                if (isUpdating) return; // Evita loop infinito de eventos

                SwingUtilities.invokeLater(() -> processarConversao(campoOrigem, baseOrigem));
            }
        });
    }

    private void processarConversao(JTextField campoOrigem, int baseOrigem) {
        String texto = campoOrigem.getText().trim();

        if (texto.isEmpty()) {
            limparCamposSemOrigem(campoOrigem);
             resetarCores();
            lblStatus.setText("Aguardando entrada...");
            lblStatus.setForeground(Color.GRAY);
            return;
        }

        // Validação
        if (!Validador.validarEntrada(texto, baseOrigem)) {
            campoOrigem.setBackground(new Color(255, 220, 220)); // Destaque em Vermelho
            lblStatus.setText("Entrada inválida para a Base " + baseOrigem + "!");
            lblStatus.setForeground(Color.RED);
            return;
        }

        // Caso Válido
        campoOrigem.setBackground(Color.WHITE);
        lblStatus.setText("Entrada válida.");
        lblStatus.setForeground(new Color(0, 128, 0));

        try {
            isUpdating = true; // Trava os eventos durante a atualização dos outros campos

            int valorDecimal = Conversor.converterParaDecimal(texto, baseOrigem);

            if (campoOrigem != txtBinario) {
                txtBinario.setText(Conversor.converterDeDecimal(valorDecimal, 2));
                txtBinario.setBackground(Color.WHITE);
            }
            if (campoOrigem != txtOctal) {
                txtOctal.setText(Conversor.converterDeDecimal(valorDecimal, 8));
                txtOctal.setBackground(Color.WHITE);
            }
            if (campoOrigem != txtDecimal) {
                txtDecimal.setText(String.valueOf(valorDecimal));
                txtDecimal.setBackground(Color.WHITE);
            }
            if (campoOrigem != txtHexadecimal) {
                txtHexadecimal.setText(Conversor.converterDeDecimal(valorDecimal, 16));
                txtHexadecimal.setBackground(Color.WHITE);
            }

        } catch (Exception ex) {
            lblStatus.setText("Erro ao converter valor.");
            lblStatus.setForeground(Color.RED);
        } finally {
            isUpdating = false; // Destrava os eventos
        }
    }

    private void limparCamposSemOrigem(JTextField campoOrigem) {
        isUpdating = true;
        if (campoOrigem != txtBinario) txtBinario.setText("");
        if (campoOrigem != txtOctal) txtOctal.setText("");
        if (campoOrigem != txtDecimal) txtDecimal.setText("");
        if (campoOrigem != txtHexadecimal) txtHexadecimal.setText("");
        isUpdating = false;
    }

    private void limparCampos() {
        isUpdating = true;
        txtBinario.setText("");
        txtOctal.setText("");
        txtDecimal.setText("");
        txtHexadecimal.setText("");
        resetarCores();
        lblStatus.setText("Campos limpos.");
        lblStatus.setForeground(Color.GRAY);
        isUpdating = false;
    }

    private void resetarCores() {
        txtBinario.setBackground(Color.WHITE);
        txtOctal.setBackground(Color.WHITE);
        txtDecimal.setBackground(Color.WHITE);
        txtHexadecimal.setBackground(Color.WHITE);
    }
}