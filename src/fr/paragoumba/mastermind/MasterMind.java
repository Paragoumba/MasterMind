package fr.paragoumba.mastermind;

import fr.paragoumba.mastermind.objects.Token;
import fr.paragoumba.mastermind.panels.GamePanel;
import fr.paragoumba.mastermind.panels.MenuPanel;
import fr.paragoumba.mastermind.panels.OptionsPanel;
import fr.paragoumba.mastermind.panels.StartingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Objects;

public class MasterMind implements Runnable {

    private static boolean running = true;

    private static JPanel[] panels = new JPanel[0];
    public static int displayedPanel;
    private static int targetFPS = 60;
    private static int lastFPSDisplay = 0;

    private static final String title = "MasterMind";
    private static final String version = "v1.5.1";
    public static int resolution = 10;

    private static final int STARTING_PANEL = registerPanel(new StartingPanel());
    public static final int MENU_PANEL = registerPanel(new MenuPanel());
    public static final int OPTIONS_PANEL = registerPanel(new OptionsPanel());
    public static final int GAME_PANEL = registerPanel(new GamePanel());

    private static final Thread displayThread = new Thread(new MasterMind(), "Thread - Display");
    private static final JFrame window = new JFrame();

    public static void main(String[] args) throws InterruptedException {

        //Initializing display's components and resources
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addWindowStateListener(e -> {

            if (e.getNewState() == WindowEvent.WINDOW_CLOSED) stop(0);

        });
        window.addKeyListener((KeyListener) panels[GAME_PANEL]);
        window.addKeyListener((KeyListener) panels[OPTIONS_PANEL]);
        window.setPreferredSize(dimension);
        window.setSize(dimension);
        window.setIconImage(ResourceLoader.getImage("e-penser-icon"));
        window.setLocationRelativeTo(null);
        window.setTitle(title);

        /* StartingPanel */
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDisplayedPanel(STARTING_PANEL);
        window.setVisible(true);

        long sleepStart = System.currentTimeMillis();

        while (System.currentTimeMillis() - sleepStart < 2000) Thread.sleep(10);

        /* MenuPanel */
        setDisplayedPanel(MENU_PANEL);
        displayThread.start();

    }

    @Override
    public void run() {

        int i = 0;

        while (running) {

            double targetTime = (1e3 / targetFPS);
            long start = System.currentTimeMillis();

            // Drawing
            panels[displayedPanel].repaint();

            long elapsed = System.currentTimeMillis() - start;
            long wait = Math.round(targetTime - elapsed);

            if (wait < 0) wait = (long) targetTime;

            try {

                Thread.sleep(wait);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            ++i;

            lastFPSDisplay += System.currentTimeMillis() - start;

            if (i > 59) {

                Point mouse = MouseInfo.getPointerInfo().getLocation();
                MasterMind.window.setTitle(MasterMind.title + " - " + version + " " + Math.round(1d / lastFPSDisplay * 1E3 * 60) + "FPS" + " (" + lastFPSDisplay + "ms) " + mouse.x + ":" + mouse.y);

                i = 0;
                lastFPSDisplay = 0;

            }
        }

    }

    private static int registerPanel(JPanel panel){

        for (int i = 0; i < Objects.requireNonNull(panels).length; ++i) if (panels[i].equals(panel)) return i;

        panels = Arrays.copyOf(panels, panels.length + 1);
        panels[panels.length - 1] = panel;
        return panels.length - 1;

    }

    public static void setDisplayedPanel(int index){

        window.setContentPane(panels[displayedPanel = index]);
        window.pack();

    }

    public static void stop(int status){

        running = false;
        System.exit(status);

    }

    public static void drawTokens(Token[] tokens, Graphics g, int height){

        height /= 2;

        for (int i = 0; i < tokens.length; ++i){

            if (tokens[i] != null){

                g.drawImage(tokens[i].image, i * (tokens[i].image.getWidth() + 10) + 20,  height - tokens[i].image.getHeight() / 2, null);

            }
        }
    }
}
