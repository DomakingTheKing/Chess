import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CursorJButtonListener implements MouseListener {

    private Model model;


    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getComponent();

        if (button.getName().equalsIgnoreCase("jbLocal")) {
            model.startLocalGame();
        } else if (button.getName().equalsIgnoreCase("jbOnline")) {
            System.out.println("OnlineGame");
        } else if (button.getName().equalsIgnoreCase("jbExit")) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getComponent();

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getComponent();

        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }






    public void setModel(Model model){
        this.model = model;
    }
}
