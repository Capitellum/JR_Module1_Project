import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainWindow {
    public JPanel mainPanel;
    public JButton buttonDecipher, buttonCipher, buttonFileOpen;
    public JScrollPane textBeforeScroll, textAfterScroll;
    public JLabel cipherKey;
    public JTextPane textBefore, textAfter;
    public JFileChooser fileChooser;

    public MainWindow() {
        buttonFileOpen.addActionListener(e -> {
            fileChooser = new JFileChooser();
            int fileChooserVal = fileChooser.showOpenDialog(mainPanel);
            if (fileChooserVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    ArrayList<String> arrayList = new ArrayList<>();
                    while (bufferedReader.ready()) {
                        arrayList.add(bufferedReader.readLine());
                    }
                    textBefore.setText(arrayList.toString());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


}
