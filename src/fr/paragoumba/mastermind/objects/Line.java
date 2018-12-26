package fr.paragoumba.mastermind.objects;

import fr.paragoumba.mastermind.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Line extends JComponent {

    public Line(){

        setPreferredSize(new Dimension(bg.getWidth(), bg.getHeight()));

    }

    private final int TOKENS_NUMBER = 4;

    public Token[] tokens = new Token[TOKENS_NUMBER];

    public int goodPlacements = 0;
    private int badPlacements = 0;

    private BufferedImage bg = ResourceLoader.getImage("row-bg");

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(bg, 0, 0, null);

        for (int i = 0; i < tokens.length; ++i){

            if (tokens[i] != null){

                g.drawImage(tokens[i].image, i * (tokens[i].image.getWidth() + 10) + 20,  getHeight() / 2 - tokens[i].image.getHeight() / 2, null);

            }
        }

        int halfBGHeight = bg.getHeight() / 2;
        int i = 0;
        BufferedImage image = ResourceLoader.getImage("goodp");

        for (; i < goodPlacements; ++i) g.drawImage(image, 260 + 15 - image.getHeight() / 2 + i * 40, halfBGHeight - image.getHeight() / 2, null);

        image = ResourceLoader.getImage("badp");

        for (; i < badPlacements + goodPlacements; ++i) g.drawImage(image, 260 + 15 - image.getHeight() / 2 + i * 40, halfBGHeight - image.getHeight() / 2, null);

    }

    public void analyse(Token[] ref){

        int[] iIds = new int[]{-1, -1, -1, -1};
        int iId = 0;
        int[] jIds = new int[]{-1, -1, -1, -1};
        int jId = 0;

        for (int i = 0; i < TOKENS_NUMBER; ++i) {
            if (ref[i] == tokens[i]){

                goodPlacements++;
                iIds[iId] = i;
                iId++;
                jIds[jId] = i;
                jId++;

            }
        }

        for (int i = 0; i < TOKENS_NUMBER; ++i) {
            for (int j = 0; j < TOKENS_NUMBER; ++j) {

                if (ref[i] == tokens[j]){

                    boolean flag = false;

                    for (int k = 0; k <= Math.max(iId, jId); ++k) if (iIds[k] == i || jIds[k] == j){

                        flag = true;
                        break;

                    }

                    if (!flag) {

                        badPlacements++;
                        iIds[iId] = i;
                        iId++;
                        jIds[jId] = j;
                        jId++;

                        break;

                    }
                }
            }
        }
    }
}
