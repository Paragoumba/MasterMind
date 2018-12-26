package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.objects.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static fr.paragoumba.mastermind.panels.GamePanel.*;

public class TokenView extends JComponent implements MouseListener {

    public TokenView(Token token){

        this.token = token;

        setPreferredSize(new Dimension(token.image.getWidth(), token.image.getHeight()));
        addMouseListener(this);

    }

    private Token token;

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(token.image, 0, 0, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (playing) {

            tray[lastLine].tokens[lastPosition] = token;
            lastPosition++;

            if (lastPosition > 3){

                tray[lastLine].analyse(secretCombination);

                if (tray[lastLine].goodPlacements == 4){

                    won = true;
                    playing = false;
                    return;

                }

                lastPosition = 0;
                lastLine++;

            }

            if (lastLine >= lineNumber) playing = false;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
