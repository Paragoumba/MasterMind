package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.ResourceLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Objects;

public class StartingPanel extends JPanel {

    public StartingPanel(){

        epenser = ResourceLoader.getImage("e-penser");

    }

    private BufferedImage epenser = null;

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(Objects.requireNonNull(epenser), getWidth() / 2 - epenser.getWidth() / 2, getHeight() / 2 - epenser.getHeight() / 2, null);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 60));
        g.drawString("Mastermind", getWidth() / 2 - g.getFontMetrics().stringWidth("Mastermind") / 2, getHeight() / 3);
        g.setFont(new Font("Press Start 2P", Font.PLAIN, 30));
        g.drawString("Prenez le temps de le résoudre.", getWidth() / 2 - g.getFontMetrics().stringWidth("Prenez le temps de le résoudre.") / 2, Math.round(getHeight() / 1.5f));
        g.drawString("by Paragoumba", getWidth() / 2, getHeight() / 3 + 30);

    }
}
