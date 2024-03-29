package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;
import fr.paragoumba.mastermind.components.RetroLine;
import fr.paragoumba.mastermind.components.TextRetroButton;
import fr.paragoumba.mastermind.components.TokenView;
import fr.paragoumba.mastermind.objects.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static fr.paragoumba.mastermind.MasterMind.*;

public class GamePanel extends JPanel implements KeyListener {

    public GamePanel(){

        launchGame();
        setLayout(new BorderLayout());

        JPanel trayPanel = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {

                g.setColor(new Color(150, 255, 0));
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

        trayPanel.setLayout(new BoxLayout(trayPanel, BoxLayout.PAGE_AXIS));
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
        for (RetroLine line : tray) trayPanel.add(line);

        add(trayPanel, BorderLayout.LINE_START);
        add(selection, BorderLayout.LINE_END);

    }

    public static final int lineNumber = 10;
    public static RetroLine[] tray = new RetroLine[lineNumber];
    public static Token[] secretCombination = new Token[4];

    public static int lastLine;
    public static int lastPosition;

    public static boolean playing;
    public static boolean won;

    private static Font font = new Font("Press Start 2P", Font.PLAIN, 60);

    private void launchGame(){

        lastLine = 0;
        lastPosition = 0;
        playing = true;
        won = false;

        setSecretCombinaison();
        initTray();

    }

    private void initTray(){

        for (int i = 0; i < tray.length; ++i){

            if (tray[i] == null) tray[i] = new RetroLine();
            else tray[i].clear();

        }
    }

    private void setSecretCombinaison(){

        Token[] tokens = Token.values();
        Random random = new Random();

        for (int i = 0; i < secretCombination.length; ++i) secretCombination[i] = tokens[random.nextInt(tokens.length)];

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (won || !playing) {

            FontMetrics fontMetrics = g.getFontMetrics();

            g.setFont(font);
            g.setColor(ResourceLoader.textColor);

            if (won) {

                g.drawString("You've won !", getWidth() / 2 - fontMetrics.stringWidth("You've won !") / 2, getHeight() / 2 + fontMetrics.getHeight() / 2);

            } else if (!playing) {

                g.drawString("You died !", getWidth() / 2 - fontMetrics.stringWidth("You died !") / 2, getHeight() / 2 + fontMetrics.getHeight() / 2);

            }

            int height = getHeight() / 2;

            for (int i = 0; i < secretCombination.length; ++i){

                if (secretCombination[i] != null){

                    g.drawImage(secretCombination[i].image, getWidth() / 2 + i * (secretCombination[i].image.getWidth() + 10) + 20,  height - secretCombination[i].image.getHeight() / 2 + 50, null);

                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {

        if (MasterMind.displayedPanel == GAME_PANEL){
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE){

                JPanel panel = new JPanel(){

                    @Override
                    protected void paintComponent(Graphics g) {

                        g.setColor(new Color(255, 255, 0, 150));
                        g.fillRect(0, 0, getWidth(), getHeight());

                    }
                };

                //panel.setOpaque(false);
                panel.setPreferredSize(new Dimension(100, 100));
                panel.add(new TextRetroButton("Test"));

                add(panel, 0);

            } else if (e.getKeyCode() == KeyEvent.VK_R){

                launchGame();

            }
        }
    }
}
