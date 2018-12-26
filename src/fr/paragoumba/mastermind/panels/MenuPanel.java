package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.components.RetroButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static fr.paragoumba.mastermind.MasterMind.*;

public class MenuPanel extends JPanel {

    private JLabel label;
    private RetroButton continueButton;
    private RetroButton optionsButton;
    private RetroButton quitButton;
    private Font font;

    public MenuPanel(){

        label = new JLabel("Menu");
        continueButton = new RetroButton("Continue");
        optionsButton = new RetroButton("Options");
        quitButton = new RetroButton("Quit");
        font = new Font("Press Start 2P", Font.PLAIN, 50);

        continueButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                MasterMind.setDisplayedPanel(GAME_PANEL);

            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });
        optionsButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                MasterMind.setDisplayedPanel(OPTIONS_PANEL);

            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });
        quitButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                MasterMind.stop(0);

            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });

        label.setFont(font);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(label);
        add(Box.createVerticalGlue());
        add(continueButton);
        add(Box.createVerticalGlue());
        add(optionsButton);
        add(Box.createVerticalGlue());
        add(quitButton);
        add(Box.createVerticalGlue());

    }
}
