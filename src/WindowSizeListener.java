import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WindowSizeListener extends ComponentAdapter {
    private final ViewMenu viewMenu;

    public WindowSizeListener(ViewMenu viewMenu) {
        this.viewMenu = viewMenu;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        super.componentResized(e);
        viewMenu.resizeBackgroundPanel();
    }
}
