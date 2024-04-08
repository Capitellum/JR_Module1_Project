import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MainView {
    public JPanel mainPanel;
    public JButton buttonDecipher, buttonCipher, buttonFileOpen;
    public JScrollPane textBeforeScroll, textAfterScroll;
    public JLabel cipherKey;
    public JTextPane textBefore, textAfter;
    public JFileChooser fileChooser = new JFileChooser();

    public MainView() {
        buttonFileOpen.addActionListener(e -> {
            int fileChooserVal = fileChooser.showOpenDialog(mainPanel);
            switch (fileChooserVal) {
                case JFileChooser.APPROVE_OPTION -> {

                    String filePath = fileChooser.getSelectedFile().getPath();
                    Path path = Path.of(filePath);

                    try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        while (bufferedReader.ready()) {
                            StringBuilder line = new StringBuilder(bufferedReader.readLine());
                            arrayList.add(line.toString());
                        }
                        textBefore.setText(arrayList.toString());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case JFileChooser.CANCEL_OPTION -> {textBefore.setText("File wasn't chosen");}
                case JFileChooser.ERROR_OPTION -> {textBefore.setText("Error occurred during file opening");}

            }
        });
        buttonCipher.addActionListener(e -> {
            if (!textBefore.getText().isEmpty()) {

                    char[] charArray = textBefore.getText().toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char tempChar = charArray[i];
                        tempChar = (char)(tempChar+1);
                        charArray[i] = tempChar;

                    }
                    textAfter.setText(String.valueOf(charArray));
                }
        });
        buttonDecipher.addActionListener(e -> {
            if (!textAfter.getText().isEmpty()) {

                char[] charArray = textAfter.getText().toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char tempChar = charArray[i];
                    tempChar = (char)(tempChar-1);
                    charArray[i] = tempChar;

                }
                textAfter.setText(String.valueOf(charArray));
            }
        });
    }


}
