import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JButton buttonDecipher;
    private JButton buttonCipher;
    private JTextPane textBefore;
    private JTextPane textAfter;
    public JPanel mainPanel;
    private JLabel cipherKey;
    private JButton buttonFileOpen;

    public MainWindow() {
        buttonFileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gui.setPanel(new fileOpenWindow().openFilePanel);
            }
        });
    }


}
