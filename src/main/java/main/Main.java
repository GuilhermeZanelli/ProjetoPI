package main;
import javax.swing.SwingUtilities;
import view.TelaLogin;

public class Main {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}