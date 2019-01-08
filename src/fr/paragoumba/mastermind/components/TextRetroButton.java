package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;

import java.awt.*;

public class TextRetroButton extends RetroButton {

    public TextRetroButton(String text){

        this(text, null);

    }

    public TextRetroButton(String text, Runnable action){

        super(action);

        textColor = new Color(255, 255, 255, 150);
        textPressedColor = new Color(0, 0, 0, 100);
        font = new Font("Press Start 2P", Font.PLAIN, Math.round(1.5f * MasterMind.resolution));
        this.text = text;

    }

    private String text;
    private Color textColor;
    private Color textPressedColor;
    private Font font;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setFont(font);
        g.setColor(pressed ? textPressedColor : textColor);
        g.drawString(text, getWidth() / 2 - g.getFontMetrics().stringWidth(text) / 2, getHeight() / 2 + g.getFontMetrics().getHeight() / 2);

    }
}
