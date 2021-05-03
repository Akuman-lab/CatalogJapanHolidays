package com.company;

import javax.swing.*;
import java.awt.*;
/*
@author Савва Пилипас Александрович
 */
public class Main {
    private static JFrame frameCatalog;
    private static JPanel panelCatalog;
    private static JLabel name;
    private static final ButtonCatalog[] buttonsCatalog = new ButtonCatalog[76];
    private static final ButtonSort[] buttonsSort = new ButtonSort[6];
    private static final int[] [] indicator = new int[2][76]; // 0-религия, 1-официальность

    Main()  {
        frameCatalog = new JFrame("Japan Holidays");
        panelCatalog = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon("image/calendar.jpg").getImage(), 0, 0, null);
            }
        };
        panelCatalog.setLayout(null);
        frameCatalog.setSize(1920, 1080);
        frameCatalog.setLocation(0, 0);
        frameCatalog.add(panelCatalog);

        name = new JLabel("",SwingConstants.CENTER);
        name.setLocation(0, 50);
        name.setSize(1920, 50);
        name.setForeground(Color.PINK);
        name.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        panelCatalog.add(name);

        createButtonsCatalog();
        createButtonsSort();

        frameCatalog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCatalog.setVisible(true);
    }

    // создание кнопок каталога
    private static void createButtonsCatalog() {
        for (int i = 0; i < buttonsCatalog.length; i++) {
            buttonsCatalog[i] = new ButtonCatalog(Reader.getScannerSemi().nextInt(), Reader.getScannerXBC().nextInt(), Reader.getScannerYBC().nextInt(),
                    Reader.getScannerName().nextLine(), Reader.getScannerLink().nextLine());
        }
        for (int i = 0; i < indicator[1].length; i++){
            indicator[0][i] =  Reader.getScannerReligion().nextInt();
            indicator[1][i] =  Reader.getScannerOfficiality().nextInt();
        }
        Reader.getScannerSemi().close();
        Reader.getScannerXBC().close();
        Reader.getScannerYBC().close();
        Reader.getScannerName().close();
        Reader.getScannerLink().close();
        Reader.getScannerReligion().close();
        Reader.getScannerOfficiality().close();
    }

    //создание кнопок сортировки
    private static void createButtonsSort() {
        for (int i = 0; i < buttonsSort.length; i++) {
            buttonsSort[i] = new ButtonSort(Reader.getScannerXBS().nextInt(), Reader.getScannerYBS().nextInt(), Reader.getScannerType().nextInt());
        }
        Reader.getScannerXBS().close();
        Reader.getScannerYBS().close();
        Reader.getScannerType().close();
    }

    public static JPanel getPanelCatalog() {
        return panelCatalog;
    }

    public static JLabel getName() {
        return name;
    }

    public static ButtonCatalog[] getButtonsCatalog() {
        return buttonsCatalog;
    }

    public static ButtonSort[] getButtonsSort() {
        return buttonsSort;
    }

    public static int[][] getIndicator() {
        return indicator;
    }

    public static void main (String[] args)  {
        new Main();
    }
}