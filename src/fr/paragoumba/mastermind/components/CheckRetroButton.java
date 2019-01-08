package fr.paragoumba.mastermind.components;

import fr.paragoumba.mastermind.MasterMind;
import fr.paragoumba.mastermind.ResourceLoader;

import java.awt.*;

public class CheckRetroButton extends RetroButton {

    private int res = MasterMind.resolution / 2;
    private int res2 = res / 2;

    public CheckRetroButton(){

        this(null);

    }

    public CheckRetroButton(Runnable action){

        super(action);

        Dimension size = new Dimension(25 * res2, 25 * res2);

        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(disabled ? Color.GRAY : Color.YELLOW);
        g.fillRect(res2 * 18, res2 * 6, res2 * 3, res2 * 3);
        g.fillRect(res2 * 15, res2 * 9, res2 * 3, res2 * 3);
        g.fillRect(res2 * 13, res2 * 12, res2 * 3, res2 * 4);
        g.fillRect(res2 * 8, res2 * 16, res2 * 6, res2 * 3);
        g.fillRect(res2 * 4, res2 * 14, res2 * 4, res2 * 3);
        g.fillRect(res2 * 4, res2 * 13, res2 * 2, res2);
        g.fillRect(res2 * 3, res2 * 14, res2, res2 * 2);
        g.fillRect(res2 * 8, res2 * 15, res2, res2);
        g.fillRect(res2 * 6, res2 * 17, res2 * 2, res2);
        g.fillRect(res2 * 9, res2 * 19, res2 * 2, res2);
        g.fillRect(res2 * 11, res2 * 19, res2 * 2, res2 * 2);
        g.fillRect(res2 * 11, res2 * 15, res2, res2);
        g.fillRect(res2 * 12, res2 * 13, res2, res2 * 3);
        g.fillRect(res2 * 14, res2 * 16, res2, res2 * 2);
        g.fillRect(res2 * 16, res2 * 12, res2, res2 * 2);
        g.fillRect(res2 * 14, res2 * 10, res2, res2 * 2);
        g.fillRect(res2 * 18, res2 * 10, res2, res2);
        g.fillRect(res2 * 18, res2 * 9, res2 * 2, res2);
        g.fillRect(res2 * 16, res2 * 8, res2, res2);
        g.fillRect(res2 * 17, res2 * 7, res2, res2 * 2);
        g.fillRect(res2 * 21, res2 * 7, res2, res2 * 2);

    }

    @Override
    void drawBackground(Graphics g){
        
        g.setColor(getBGColor());
        g.fillRect(res, 0, getWidth() - res * 2, getHeight());
        g.fillRect(0, res, res, getHeight() - res * 2);
        g.fillRect(getWidth() - res, res, res, getHeight() - res * 2);

    }
    
    @Override
    void drawShadows(Graphics g) {

        g.setColor(getPrimaryShadow());

        g.fillRect(res, 0, getWidth() - res * 2, res);
        g.fillRect(getWidth() - res * 2, res, res, res);
        g.fillRect(getWidth() - res, res, res, getHeight() - res * 2);

        g.setColor(getSecondaryShadow());

        g.fillRect(res, getHeight() - res, getWidth() - res * 2, res);
        g.fillRect(res, getHeight() - res * 2, res, res);
        g.fillRect(0, res, res, getHeight() - res * 2);
        
    }
}
