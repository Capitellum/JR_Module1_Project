import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainWindow {
    private JButton buttonDecipher;
    private JButton buttonCipher;
    private JScrollPane textBeforeScroll;
    public JPanel mainPanel;
    private JLabel cipherKey;
    private JButton buttonFileOpen;
    private JScrollPane textAfterScroll;
    private JTextPane textBefore;
    private JTextPane textAfter;
    private JFileChooser fileChooser;

    public MainWindow() {

        buttonFileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
    }


}
