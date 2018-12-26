package fr.paragoumba.mastermind.panels;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.components.RetroButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static fr.paragoumba.mastermind.MasterMind.MENU_PANEL;

public class OptionsPanel extends JPanel {

    public OptionsPanel(){

        RetroButton acceptButton = new RetroButton("Accept");
        RetroButton cancelButton = new RetroButton("Cancel");

        cancelButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                MasterMind.setDisplayedPanel(MENU_PANEL);

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

        String text = "Options Panel, welcome home soldier.";
        Font font = new Font("Press Start 2P", Font.PLAIN, 40);
        String[] array = new String[]{"Jensen", "Rhoades", "Granger"};

        JScrollPane listScroller = new JScrollPane(new JList<>(array));
        //listScroller.setPreferredSize(new Dimension(250, 80));
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

        add(listPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth(), getHeight());

    }
}
