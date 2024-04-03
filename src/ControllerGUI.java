import javax.swing.*;

public class ControllerGUI extends JFrame {

    MainWindow mainWindow = new MainWindow();
    ControllerGUI(){
        initialisation();
    }

    private void initialisation() {
        setPanel(mainWindow.mainPanel);
        this.setTitle("JavaRush. Module One");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setVisible(true);
    }

    public void setPanel(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
    }
}
