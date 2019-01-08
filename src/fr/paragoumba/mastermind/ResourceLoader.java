package fr.paragoumba.mastermind;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class ResourceLoader {

    private static boolean initialized = false;
    private static HashMap<String, HashMap<String, Object>> resources = new HashMap<>();

    public static Color bgColor = new Color(29, 35, 140);
    public static Color bgDisabledColor = Color.GRAY;
    public static final Color textColor = new Color(51, 51, 51);
    public static final Color brightShadow = new Color(255, 255, 255, 20);
    public static final Color darkShadow = new Color(0, 0, 0, 50);

    private static void loadResources(){

        try {

            HashMap<String, Object> images = new HashMap<>();

            images.put("e-penser-icon", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/e-penser64.png")));
            images.put("e-penser", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/e-penser1000.png")));

            images.put("type0", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/0.png")));
            images.put("type1", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/1.png")));
            images.put("type2", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/2.png")));
            images.put("type3", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/3.png")));
            images.put("type4", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/4.png")));
            images.put("type5", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/types/5.png")));

            images.put("badp", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/placements/bad.png")));
            images.put("goodp", ImageIO.read(ResourceLoader.class.getResourceAsStream("res/placements/good.png")));

            resources.put("images", images);

            Font pressStartFont = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.class.getResourceAsStream("res/fonts/PressStart2P.ttf"));
            Font eightBitWonderFont = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.class.getResourceAsStream("res/fonts/8bit_wonder.ttf"));

            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pressStartFont);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(eightBitWonderFont);

            initialized = true;

        } catch (IOException | FontFormatException e) {

            e.printStackTrace();

        }
    }

    public static BufferedImage getImage(String imageName){

        if (!initialized) loadResources();

        return (BufferedImage) resources.get("images").get(imageName);

    }
}
