import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CipherGUI extends JFrame implements ActionListener {

    private JComboBox<String> cipherList;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton encodeButton, decodeButton;

    public CipherGUI() {
        super("Cipher GUI");

        // Initialize components
        cipherList = new JComboBox<String>(new String[] {"Caesar", "Affine", "Vigenere", "Atbash", "Matrix", "RailFence"});
        inputField = new JTextField(20);
        outputArea = new JTextArea(10, 20);
        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");

        // Add action listeners
        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);

        // Add components to content pane
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Cipher method:"));
        topPanel.add(cipherList);
        topPanel.add(new JLabel("Input text:"));
        topPanel.add(inputField);
        topPanel.add(encodeButton);
        topPanel.add(decodeButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String inputText = inputField.getText();
        String cipherMethod = (String)cipherList.getSelectedItem();
        String outputText = "";

        // Perform the selected cipher method
        
        // Update the output area
        if (e.getSource() == encodeButton) {
            if (cipherMethod.equals("Caesar")) {
                outputText = CaesarCipher.encrypt(inputText, 3);
            } else if (cipherMethod.equals("Affine")) {
                outputText = AffineCipher.encrypt(inputText, 3, 2);
            } else if (cipherMethod.equals("Vigenere")) {
                outputText = VigenereCipher.encrypt(inputText, "key");
            } else if (cipherMethod.equals("Atbash")) {
                outputText = AtbashCipher.encrypt(inputText);
            } else if (cipherMethod.equals("Matrix")) {
                outputText = MatrixCipher.encrypt(inputText, "abcdef");
            } else if (cipherMethod.equals("RailFence")) {
                outputText = RailFenceCipher.encrypt(inputText, 4);
            } 
            outputArea.setText(outputText);
        } else if (e.getSource() == decodeButton) {
            if (cipherMethod.equals("Caesar")) {
                outputText = CaesarCipher.decrypt(inputText, 3);
            } else if (cipherMethod.equals("Affine")) {
                outputText = AffineCipher.decrypt(inputText, 3, 2);
            } else if (cipherMethod.equals("Vigenere")) {
                outputText = VigenereCipher.decrypt(inputText, "key");
            } else if (cipherMethod.equals("Atbash")) {
                outputText = AtbashCipher.decrypt(inputText);
            } else if (cipherMethod.equals("Matrix")) {
                outputText = MatrixCipher.decrypt(inputText, "abcdef");
            } else if (cipherMethod.equals("RailFence")) {
                outputText = RailFenceCipher.decrypt(inputText, 4);
            } 
            outputArea.setText(outputText);
        }
    }

    public static void main(String[] args) {
        new CipherGUI();
    }
}