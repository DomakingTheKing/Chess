import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

public class ViewMenu extends JFrame implements ViewConstants {

    private BackgroundPanel jpMain;
    private JPanel jpGameModes, jpOptions;
    private JButton jbLocal, jbOnline, jbExit;
    private JLabel jlTitleLogo;

    public ViewMenu() {
        initializeComponents();
        createLayout();
        miscellaneous();
        addComponents();
        finishings();
        addBackgrounds();

        this.addComponentListener(new WindowSizeListener(this));
    }

    private void initializeComponents() {
        jpMain = new BackgroundPanel("jpMenuBG.png");
        jpGameModes = new JPanel();
        jpOptions = new JPanel();

        jbLocal = new JButton();
        jbOnline = new JButton();
        jbExit = new JButton();

        jlTitleLogo = new JLabel("SCACCHI");
    }

    private void createLayout() {
        this.setMinimumSize(new Dimension(ViewConstants.WIDTH, ViewConstants.HEIGHT));

        // Layouts
        this.setLayout(null);
        jpMain.setLayout(new GridLayout(3, 1));
        jpGameModes.setLayout(new FlowLayout());
        jpOptions.setLayout(new FlowLayout());

        jpGameModes.setOpaque(false);
        jpOptions.setOpaque(false);

        // Main buttons
        jbLocal.setFont((STANDARD_GAME_FONT).deriveFont(Font.PLAIN, 70));
        jbOnline.setFont((STANDARD_GAME_FONT).deriveFont(Font.PLAIN, 70));
        jbExit.setFont((STANDARD_GAME_FONT).deriveFont(Font.PLAIN, 70));

        jbLocal.setPreferredSize(new Dimension(500, 175));
        jbOnline.setPreferredSize(new Dimension(500, 175));
        jbExit.setPreferredSize(new Dimension(700, 200));

        // Title logo
        jlTitleLogo.setFont((ViewConstants.TITLE_GAME_FONT).deriveFont(Font.PLAIN, 120));
        jlTitleLogo.setForeground(Color.WHITE);
        jlTitleLogo.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void miscellaneous(){
        jbLocal.setName("jbLocal");
        jbOnline.setName("jbOnline");
        jbExit.setName("jbExit");
    }

    private void addComponents() {
        jpGameModes.add(jbLocal);
        jpGameModes.add(jbOnline);
        jpOptions.add(jbExit);

        jpMain.add(jlTitleLogo);
        jpMain.add(jpGameModes);
        jpMain.add(jpOptions);

        this.add(jpMain);
    }

    public void addButtonListeners(CursorJButtonListener Listener){
        jbLocal.addMouseListener(Listener);
        jbOnline.addMouseListener(Listener);
        jbExit.addMouseListener(Listener);
    }

    private void finishings() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);
    }

    private void addBackgrounds(){
        // Buttons backgrounds
        setScaledBackground(jbLocal, "jbLocalBG.png");
        setScaledBackground(jbOnline, "jbOnlineBG.png");
        setScaledBackground(jbExit, "jbExitBG.png");
    }







    private void setScaledBackground(JButton button, String bgIMG) {
        try {
            File imageFile = new File(IMAGE_PATH + bgIMG);
            Image image = ImageIO.read(imageFile);

            Image scaledImage = image.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            button.setIcon(scaledIcon);
            button.setBorderPainted(false);
        } catch (Exception e) {
            System.out.println("[!] Errore con il caricamento dell'immagine nel metodo setScaledBackground: " + e.getMessage());
        }
    }



    public void resizeBackgroundPanel() {
        jpMain.setSize(this.getContentPane().getSize());
    }
}
