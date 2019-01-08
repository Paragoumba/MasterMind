package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.components.RetroButton;
import fr.paragoumba.mastermind.components.TextRetroButton;

import javax.swing.*;
import java.awt.*;

import static fr.paragoumba.mastermind.MasterMind.GAME_PANEL;
import static fr.paragoumba.mastermind.MasterMind.OPTIONS_PANEL;

public class MenuPanel extends JPanel {

    public MenuPanel(){

        JLabel label = new JLabel("Menu");
        RetroButton startButton = new TextRetroButton("Start", () -> MasterMind.setDisplayedPanel(GAME_PANEL));
        RetroButton optionsButton = new TextRetroButton("Options", () -> MasterMind.setDisplayedPanel(OPTIONS_PANEL));
        RetroButton quitButton = new TextRetroButton("Quit", () -> MasterMind.stop(0));
        Font font = new Font("Press Start 2P", Font.PLAIN, 50);

        label.setFont(font);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(label);
        add(Box.createVerticalGlue());
        add(startButton);
        add(Box.createVerticalGlue());
        add(optionsButton);
        add(Box.createVerticalGlue());
        add(quitButton);
        add(Box.createVerticalGlue());

    }
}
