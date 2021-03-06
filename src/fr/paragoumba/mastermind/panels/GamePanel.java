package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.components.TokenView;
import fr.paragoumba.mastermind.objects.Line;
import fr.paragoumba.mastermind.objects.Token;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static fr.paragoumba.mastermind.MasterMind.initTray;

public class GamePanel extends JPanel {

    public GamePanel(){

        Token[] tokens = Token.values();
        Random random = new Random();

        for (int i = 0; i < secretCombination.length; ++i) secretCombination[i] = tokens[random.nextInt(tokens.length)];

        initTray();
        setLayout(new BorderLayout());

        JPanel tray = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {

                g.setColor(new Color(29, 35, 140));
                g.fillRect(0, 0, getWidth(), getHeight());

            }
        };

        JPanel selection = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {

                g.setColor(Color.ORANGE);
                g.fillRect(0, 0, getWidth(), getHeight());

            }
        };

        tray.setLayout(new BoxLayout(tray, BoxLayout.PAGE_AXIS));
        selection.setLayout(new BoxLayout(selection, BoxLayout.PAGE_AXIS));

        TokenView[] tokenViews = {
                new TokenView(Token.MARIO),
                new TokenView(Token.LUIGI),
                new TokenView(Token.WARIO),
                new TokenView(Token.WALUIGI),
                new TokenView(Token.BOWSER),
                new TokenView(Token.YOSHI)
        };

        for (TokenView tokenView : tokenViews) selection.add(tokenView);
        for (Line line : GamePanel.tray) tray.add(line);

        add(tray, BorderLayout.LINE_START);
        add(selection, BorderLayout.LINE_END);

    }

    public static final int lineNumber = 10;
    public static Line[] tray = new Line[lineNumber];
    public static Token[] secretCombination = new Token[4];

    public static int lastLine = 0;
    public static int lastPosition = 0;

    public static boolean playing = true;
    public static boolean won = false;

    private static Font font = new Font("Press Start 2P", Font.PLAIN, 60);

    @Override
    protected void paintComponent(Graphics g) {

        if (won || !playing) {

            FontMetrics fontMetrics = g.getFontMetrics();

            g.setFont(font);

            for (int i = 0; i < secretCombination.length; ++i){

                if (secretCombination[i] != null){

                    g.drawImage(secretCombination[i].image, i * (secretCombination[i].image.getWidth() + 10) + 20,  getHeight() / 2 - secretCombination[i].image.getHeight() / 2, null);

                }
            }

            if (won) {

                g.drawString("You've won !", getWidth() / 2 - fontMetrics.stringWidth("You've won !") / 2, getHeight() / 2 + fontMetrics.getHeight() / 2);

            } else if (!playing) {

                g.drawString("You died !", getWidth() / 2 - fontMetrics.stringWidth("You died !") / 2, getHeight() / 2 + fontMetrics.getHeight() / 2);

            }
        }
    }
}
