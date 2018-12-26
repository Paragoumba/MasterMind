package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RetroButton extends JComponent implements MouseListener {

    public RetroButton(String text) {

        bgColor = new Color(29, 35, 140);
        brightShadow = new Color(255, 255, 255, 20);
        darkShadow = new Color(0, 0, 0, 50);
        textColor = new Color(255, 255, 255, 150);
        textPressedColor = new Color(0, 0, 0, 100);
        font = new Font("Press Start 2P", Font.PLAIN, Math.round(1.5f * MasterMind.resolution));
        this.text = text;

        Dimension size = new Dimension(220, 90);

        addMouseListener(this);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        setFocusable(true);

    }

    private boolean pressed = false;
    private String text;
    private Color bgColor;
    private Color brightShadow;
    private Color darkShadow;
    private Color textColor;
    private Color textPressedColor;
    private Font font;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(bgColor);
        g.fillRect(MasterMind.resolution, 0, getWidth() - MasterMind.resolution * 2, getHeight());
        g.fillRect(0, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);
        g.fillRect(getWidth() - MasterMind.resolution, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

        if (pressed) g.setColor(darkShadow);
        else g.setColor(brightShadow);

        g.fillRect(MasterMind.resolution, 0, getWidth() - MasterMind.resolution * 2, MasterMind.resolution);
        g.fillRect(getWidth() - MasterMind.resolution * 2, MasterMind.resolution, MasterMind.resolution, MasterMind.resolution);
        g.fillRect(getWidth() - MasterMind.resolution, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

        if (pressed) g.setColor(brightShadow);
        else g.setColor(darkShadow);

        g.fillRect(MasterMind.resolution, getHeight() - MasterMind.resolution, getWidth() - MasterMind.resolution * 2, MasterMind.resolution);
        g.fillRect(MasterMind.resolution, getHeight() - MasterMind.resolution * 2, MasterMind.resolution, MasterMind.resolution);
        g.fillRect(0, MasterMind.resolution, MasterMind.resolution, getHeight() - MasterMind.resolution * 2);

        g.setFont(font);
        g.setColor(pressed ? textPressedColor : textColor);
        g.drawString(text, getWidth() / 2 - g.getFontMetrics().stringWidth(text) / 2, getHeight() / 2 + g.getFontMetrics().getHeight() / 2);

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

        pressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        pressed = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
