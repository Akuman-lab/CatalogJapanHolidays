package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
Класс кнопки сортировки
 */
public class ButtonSort {
    private final JButton buttonSort;
    private boolean switching = true;
    private static final ImageIcon buttonOn = new ImageIcon("image/buttonSortOn.png");
    private static final ImageIcon buttonOff = new ImageIcon("image/buttonSortOff.png");
    private static int maxAccount; // переменная для наложения фильтров сортировки
    private int type;

    ButtonSort(int x, int y, int type) {
        buttonSort = new JButton(buttonOff);
        buttonSort.setBounds(x, y, 19, 19);
        setType(type);

        buttonSort.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Main.getButtonsSort()[type - 1].getType() <= 4 && Main.getButtonsSort()[type - 1].isSwitching()) {
                    for (int i = 0; i < 4; i++) {
                        if (!Main.getButtonsSort()[i].isSwitching()) {
                            Main.getButtonsSort()[i].getButtonSort().setIcon(buttonOff);
                            Main.getButtonsSort()[i].setSwitching(true);
                            maxAccount--;
                            for (int j = 0; j < Main.getIndicator()[1].length; j++) {
                                switch (Main.getButtonsSort()[i].getType()) {
                                    case 1:
                                        if (Main.getIndicator()[0][j] == 0) // буддизм
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;

                                    case 2:
                                        if (Main.getIndicator()[0][j] == 1) // синтоизм
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;

                                    case 3:
                                        if (Main.getIndicator()[0][j] == 2) // христианство
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;

                                    case 4:
                                        if (Main.getIndicator()[0][j] == 3) // нерелигиозность
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;
                                }
                                Main.getButtonsCatalog()[j].redraw();
                            }
                        }
                    }
                }
                if (Main.getButtonsSort()[type - 1].getType() > 4 && Main.getButtonsSort()[type - 1].getType() <= 6 && Main.getButtonsSort()[type - 1].isSwitching()) {
                    for (int i = 4; i < 6; i++) {
                        if (!Main.getButtonsSort()[i].isSwitching()) {
                            Main.getButtonsSort()[i].getButtonSort().setIcon(buttonOff);
                            Main.getButtonsSort()[i].setSwitching(true);
                            maxAccount--;
                            for (int j = 0; j < Main.getIndicator()[1].length; j++) {
                                switch (Main.getButtonsSort()[i].getType()) {
                                    case 5:
                                        if (Main.getIndicator()[1][j] == 1) // официальный
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;

                                    case 6:
                                        if (Main.getIndicator()[1][j] == 0) // неофициальный
                                            Main.getButtonsCatalog()[j].setAccount(Main.getButtonsCatalog()[j].getAccount() - 1);
                                        break;
                                }
                                Main.getButtonsCatalog()[j].redraw();
                            }
                        }
                    }
                }
                if (switching) {
                    maxAccount++;
                    for (int i = 0; i < Main.getIndicator()[1].length; i++) {
                        switch (type) {
                            case 1:
                                if (Main.getIndicator()[0][i] == 0) // буддизм
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;

                            case 2:
                                if (Main.getIndicator()[0][i] == 1) // синтоизм
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;

                            case 3:
                                if (Main.getIndicator()[0][i] == 2) // христианство
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;

                            case 4:
                                if (Main.getIndicator()[0][i] == 3) // нерелигиозность
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;

                            case 5:
                                if (Main.getIndicator()[1][i] == 1) // официальный
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;

                            case 6:
                                if (Main.getIndicator()[1][i] == 0) // неофициальный
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() + 1);
                                break;
                        }
                        Main.getButtonsCatalog()[i].redraw();
                    }
                    buttonSort.setIcon(buttonOn);
                    switching = false;
                } else {
                    maxAccount--;
                    for (int i = 0; i < Main.getIndicator()[1].length; i++) {
                        switch (type) {
                            case 1:
                                if (Main.getIndicator()[0][i] == 0)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;

                            case 2:
                                if (Main.getIndicator()[0][i] == 1)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;

                            case 3:
                                if (Main.getIndicator()[0][i] == 2)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;

                            case 4:
                                if (Main.getIndicator()[0][i] == 3)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;

                            case 5:
                                if (Main.getIndicator()[1][i] == 1)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;

                            case 6:
                                if (Main.getIndicator()[1][i] == 0)
                                    Main.getButtonsCatalog()[i].setAccount(Main.getButtonsCatalog()[i].getAccount() - 1);
                                break;
                        }
                        Main.getButtonsCatalog()[i].redraw();
                    }
                    buttonSort.setIcon(buttonOff);
                    switching = true;
                }
            }
        });
        buttonSort.setContentAreaFilled(false);
        buttonSort.setBorder(null);
        buttonSort.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Main.getPanelCatalog().add(buttonSort);
    }

    public static int getMaxAccount() {
        return maxAccount;
    }

    public boolean isSwitching() {
        return switching;
    }

    public int getType() {
        return type;
    }

    public JButton getButtonSort() {
        return buttonSort;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSwitching(boolean switching) {
        this.switching = switching;
    }
}


