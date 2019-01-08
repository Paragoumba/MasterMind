package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;

import javax.swing.*;
import java.awt.*;

public abstract class RetroComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {

        drawBackground(g);
        drawShadows(g);

    }

    void drawBackground(Graphics g){

        g.setColor(getBGColor());
        g.fillRect(MasterMind.resolution, 0, getWidth() - MasterMind.resolution * 2, getHeight());
        g.fillRect(0, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);
        g.fillRect(getWidth() - MasterMind.resolution, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

    }

    void drawShadows(Graphics g){

        g.setColor(getPrimaryShadow());

        g.fillRect(MasterMind.resolution, 0, getWidth() - MasterMind.resolution * 2, MasterMind.resolution);
        g.fillRect(getWidth() - MasterMind.resolution * 2, MasterMind.resolution, MasterMind.resolution, MasterMind.resolution);
        g.fillRect(getWidth() - MasterMind.resolution, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

        g.setColor(getSecondaryShadow());

        g.fillRect(MasterMind.resolution, getHeight() - MasterMind.resolution, getWidth() - MasterMind.resolution * 2, MasterMind.resolution);
        g.fillRect(MasterMind.resolution, getHeight() - MasterMind.resolution * 2, MasterMind.resolution, MasterMind.resolution);
        g.fillRect(0, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

    }

    Color getBGColor(){

        return ResourceLoader.bgColor;

    }

    Color getPrimaryShadow(){

        return ResourceLoader.brightShadow;

    }

    Color getSecondaryShadow(){

        return ResourceLoader.darkShadow;

    }
}
