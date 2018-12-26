package fr.paragoumba.mastermind.objects;

import fr.paragoumba.mastermind.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum Token {

    MARIO(0),
    LUIGI(1),
    WARIO(2),
    WALUIGI(3),
    BOWSER(4),
    YOSHI(5);

    Token(int type){

        this.type = type;
        image = ResourceLoader.getImage("type" + type);

    }

    private int type;
    public BufferedImage image;

    public int getType() {

        return type;

    }
}
