import javax.swing.*;

public class Model {

    private ViewMenu JF_ViewMenu;
    private ViewGame JF_ViewGame;
    private final CursorJButtonListener CursorJButtonListener = new CursorJButtonListener();

    public Model(){
        SwingUtilities.invokeLater(() -> {
            JF_ViewMenu = new ViewMenu();
            CursorJButtonListener.setModel(this);
            JF_ViewMenu.addButtonListeners(CursorJButtonListener);
        });
    }

    public void startLocalGame(){
        JF_ViewMenu.dispose();
        JF_ViewGame = new ViewGame();
    }
}
