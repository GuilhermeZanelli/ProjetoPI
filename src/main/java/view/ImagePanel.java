package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class ImagePanel extends JPanel {
//armazenará uma referência à imagem
private Image backgroundImage;
public ImagePanel(URL url) {
//leitura da imagem a partir de um objeto URL
//URL é o tipo de retorno de getResource
//deve ser utilizado em projetos Maven
try {
backgroundImage = ImageIO.read(url);
} catch (IOException e) {
e.printStackTrace();
}
}
//aqui dizemos que, depois de o componente ser desenhado, desenhamos também a imagem sobre ele

//a partir das coordenadas x = 0 e y = 0
@Override
public void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawImage(backgroundImage, 0, 0, this);
}
}

