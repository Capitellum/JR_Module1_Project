import javax.swing.*;

public class MainWindow {
    JFrame mainFrame = new JFrame();
    private JButton buttonOpenFile;
    private JButton buttonDecipher;
    private JButton buttonCipher;
    private JTextPane textBefore;
    private JTextPane textAfter;
    private JPanel mainPanel;

    MainWindow(){
        textAfter.setEditable(false);
        textBefore.setEditable(false);
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(800,600);
        mainFrame.setVisible(true);
    }
}
