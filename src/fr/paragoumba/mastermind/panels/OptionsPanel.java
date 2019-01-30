package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;
import fr.paragoumba.mastermind.components.CheckRetroButton;
import fr.paragoumba.mastermind.components.TextRetroButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static fr.paragoumba.mastermind.MasterMind.MENU_PANEL;

public class OptionsPanel extends JPanel implements KeyListener {

    TextRetroButton acceptButton;
    TextRetroButton cancelButton;
    CheckRetroButton checkRetroButton;
    
    public OptionsPanel(){

        super(new BorderLayout());

        int r = (int) (System.currentTimeMillis() % 256);
        
        acceptButton = new TextRetroButton("Accept", null/* TODO */);
        cancelButton = new TextRetroButton("Cancel", () -> MasterMind.setDisplayedPanel(MENU_PANEL));
        checkRetroButton = new CheckRetroButton(() -> ResourceLoader.bgColor = new Color((int) (r * Math.random()), (int) (r * Math.random()), (int) (r * Math.random())));

        String text = "Options Panel, welcome home soldier.";
        Font font = new Font("Press Start 2P", Font.PLAIN, 40);
        String[] array = new String[]{"One option", "One another", "And one last"};

        JScrollPane listScroller = new JScrollPane(new JList<>(array));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel(text);

        label.setFont(font);

        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(acceptButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(cancelButton);
        buttonPane.add(checkRetroButton);

        add(listPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE){

            System.out.println("toggling");

            acceptButton.setDisabled(!acceptButton.isDisabled());
            cancelButton.setDisabled(!cancelButton.isDisabled());
            checkRetroButton.setDisabled(!checkRetroButton.isDisabled());
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
