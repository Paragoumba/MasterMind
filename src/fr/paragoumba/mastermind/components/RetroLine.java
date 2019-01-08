package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;
import fr.paragoumba.mastermind.objects.Token;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RetroLine extends RetroComponent {

    public RetroLine(){

        Dimension size = new Dimension(49 * MasterMind.resolution, 9 * MasterMind.resolution);

        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    private final int TOKENS_NUMBER = 4;
    Token[] tokens = new Token[TOKENS_NUMBER];
    int goodPlacements = 0;
    private int badPlacements = 0;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(ResourceLoader.brightShadow);

        int i;

        for (i = 0; i < 4; ++i){

            g.fillRect(MasterMind.resolution * (i + 2) + i * MasterMind.resolution * 5, MasterMind.resolution * 2, 5 * MasterMind.resolution, 5 * MasterMind.resolution);

        }

        int offset = MasterMind.resolution * 26;

        for (i = 0; i < 4; ++i){

            g.fillRect(offset + i * MasterMind.resolution * 4, MasterMind.resolution * 3, 3 * MasterMind.resolution, 3 * MasterMind.resolution);

        }

        MasterMind.drawTokens(tokens, g, getHeight());

        int halfHeight = getHeight() / 2;
        BufferedImage image = ResourceLoader.getImage("goodp");
        i = 0;

        for (; i < goodPlacements; ++i) g.drawImage(image, 260 + 15 - image.getWidth() / 2 + i * 40, halfHeight - image.getHeight() / 2, null);

        image = ResourceLoader.getImage("badp");

        for (; i < badPlacements + goodPlacements; ++i) g.drawImage(image, 260 + 15 - image.getWidth() / 2 + i * 40, halfHeight - image.getHeight() / 2, null);

    }

    void analyse(Token[] ref){

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
