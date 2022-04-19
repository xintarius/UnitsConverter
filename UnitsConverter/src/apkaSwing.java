import javax.swing.*;

public class apkaSwing {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new mainFrame();
        });
    }
}
