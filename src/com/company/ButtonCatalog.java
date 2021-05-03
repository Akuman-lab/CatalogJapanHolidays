package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
/*
класс кнопки каталога
 */
public class ButtonCatalog {
    private final JButton buttonCatalog;
    private ImageIcon buttonIn = new ImageIcon("image/buttonIn.png");
    private ImageIcon buttonOut = new ImageIcon("image/buttonOut.png");
    private static final ImageIcon buttonInSL = new ImageIcon("image/buttonInSemiLeft.png");
    private static final ImageIcon buttonOutSL = new ImageIcon("image/buttonOutSemiLeft.png");
    private static final ImageIcon buttonInSR = new ImageIcon("image/buttonInSemiRight.png");
    private static final ImageIcon buttonOutSR = new ImageIcon("image/buttonOutSemiRight.png");
    private static final ImageIcon light = new ImageIcon("image/light.png");
    private static final ImageIcon lightSL = new ImageIcon("image/lightSemiLeft.png");
    private static final ImageIcon lightSR = new ImageIcon("image/lightSemiRight.png");
    private static final ImageIcon buttonOutRepaint = new ImageIcon("image/buttonOut.png");
    private int account;
    private int semi;

    ButtonCatalog(int semi , int x, int y, String name, String link)  {
        buttonCatalog = new JButton(buttonOut);
        buttonCatalog.setBounds(x, y, 27, 23);

        if (semi == 1) {
            repaintSL();
        } else if (semi == 2) {
            repaintSR();
        }

        setSemi(semi);

        buttonCatalog.setContentAreaFilled(false);
        buttonCatalog.setBorder(null);
        buttonCatalog.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCatalog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                buttonCatalog.setIcon(buttonIn);
                Main.getName().setText(name);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                buttonCatalog.setIcon(buttonOut);
                Main.getName().setText(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().browse(URI.create(link));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        Main.getPanelCatalog().add(buttonCatalog);
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setSemi(int semi) {
        this.semi = semi;
    }

    private void repaint() {
        buttonOut = buttonOutRepaint;
        buttonCatalog.setIcon(buttonOut);
    }

    private void repaintSL() {
        buttonIn = buttonInSL;
        buttonOut = buttonOutSL;
        buttonCatalog.setIcon(buttonOut);
        buttonCatalog.setSize(12, 23);
    }

    private void repaintSR() {
        buttonIn = buttonInSR;
        buttonOut = buttonOutSR;
        buttonCatalog.setIcon(buttonOut);
        buttonCatalog.setSize(12, 23);
    }

    private void highlighting () {
        buttonOut = light;
        buttonCatalog.setIcon(buttonOut);
    }

    private void highlightingSL () {
        buttonOut = lightSL;
        buttonCatalog.setIcon(buttonOut);
    }

    private void highlightingSR () {
        buttonOut = lightSR;
        buttonCatalog.setIcon(buttonOut);
    }

    protected void redraw() {
        if (account==ButtonSort.getMaxAccount()&&ButtonSort.getMaxAccount()!=0) {
            switch (semi) {
                case 0:
                    highlighting();
                    break;

                case 1:
                    highlightingSL();
                    break;

                case 2:
                    highlightingSR();
                    break;
            }
        } else {
            switch (semi) {
                case 0:
                    repaint();
                    break;

                case 1:
                    repaintSL();
                    break;

                case 2:
                    repaintSR();
                    break;
            }
        }
    }
}


