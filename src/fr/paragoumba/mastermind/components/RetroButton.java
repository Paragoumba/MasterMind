package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class RetroButton extends RetroComponent implements MouseListener {

    RetroButton() {

        Dimension size = new Dimension(22 * MasterMind.resolution, 9 * MasterMind.resolution);

        addMouseListener(this);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        setFocusable(true);

    }

    RetroButton(Runnable action){

        this();
        this.action = action;

    }

    boolean pressed = false;
    boolean disabled = false;
    private Runnable action = null;

    public boolean isDisabled() {

        return disabled;

    }

    public void setDisabled(boolean b){

        disabled = b;

    }

    @Override
    Color getBGColor() {

        return disabled ? ResourceLoader.bgDisabledColor : ResourceLoader.bgColor;

    }

    @Override
    Color getPrimaryShadow() {

        return pressed ? ResourceLoader.darkShadow : ResourceLoader.brightShadow;

    }

    @Override
    Color getSecondaryShadow() {

        return pressed ? ResourceLoader.brightShadow : ResourceLoader.darkShadow;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!disabled && action != null) action.run();

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (!disabled) pressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (!disabled) pressed = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
