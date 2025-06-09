package main;
import javax.swing.SwingUtilities;
import view.TelaLogin;

public class Main {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {    //isso garante que a interface gráfica seja criada na thread de eventos do Swing
            TelaLogin telaLogin = new TelaLogin();                     //(bom funcionamento do Swing)
            telaLogin.setVisible(true);
        });
    }
}