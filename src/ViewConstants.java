import java.awt.*;
import java.io.File;
import java.io.IOException;

public interface ViewConstants {

    int WIDTH = 1280;
    int HEIGHT = 960;

    String IMAGE_PATH = "Assets/Images/";
    String MUSIC_PATH = "Assets/Audio/Music/";
    String SOUND_PATH = "Assets/Audio/Sounds/";
    String FONT_PATH = "Assets/Font/";

    Font STANDARD_GAME_FONT = createGameFont("PixelNormal.TTF");
    Font TITLE_GAME_FONT = createGameFont("PixelTitle.ttf");



    private static Font createGameFont(String fontName) {
        try {
            File fontFile = new File(FONT_PATH + fontName);
            return Font.createFont(Font.TRUETYPE_FONT, fontFile);

        } catch (IOException | FontFormatException e) {
            System.err.println("[!] Failed to load the game font: " + e.getMessage());
            return new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        }
    }
}
