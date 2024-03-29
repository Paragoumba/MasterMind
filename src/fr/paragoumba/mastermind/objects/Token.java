package fr.paragoumba.mastermind.objects;

import fr.paragoumba.mastermind.ResourceLoader;

import java.awt.image.BufferedImage;

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

}
