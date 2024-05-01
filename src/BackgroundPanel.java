import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BackgroundPanel extends JPanel implements ViewConstants {
    private Image originalImage;

    public BackgroundPanel(String imageName) {
        this.setSize(ViewConstants.WIDTH, ViewConstants.HEIGHT);
        loadImage(imageName);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                repaint();
            }
        });
    }

    private void loadImage(String imageName) {
        try {
            File imageFile = new File(IMAGE_PATH + imageName);
            originalImage = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.out.println("[!] Errore con il caricamento dell'immagine nella classe BackgroundPanel: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (originalImage != null) {
            // Disegna l'immagine originale con le dimensioni attuali del pannello
            g.drawImage(originalImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


