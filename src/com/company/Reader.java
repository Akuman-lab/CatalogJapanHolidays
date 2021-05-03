package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/*
Класс для считывания переменных-параметров из txt файлов
 */
public class Reader {
    private static Scanner scannerXBC; // x кнопок каталога
    static {
        try {
            scannerXBC = new Scanner(new File("parameters/xBC.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerYBC; // y кнопок каталога
    static {
        try {
            scannerYBC = new Scanner(new File("parameters/yBC.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerSemi; // размеры кнопок каталога
    static {
        try {
            scannerSemi = new Scanner(new File("parameters/semi.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerName; // названия праздников
    static {
        try {
            scannerName = new Scanner(new File("parameters/name.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerLink; // ссылки на сайты про праздники
    static {
        try {
            scannerLink = new Scanner(new File("parameters/link.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerReligion; // параметр религии
    static {
        try {
            scannerReligion = new Scanner(new File("parameters/religion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerOfficiality; // параметр официальности
    static {
        try {
            scannerOfficiality = new Scanner(new File("parameters/officiality.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerXBS; // x кнопок сортировки
    static {
        try {
            scannerXBS = new Scanner(new File("parameters/xBS.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerYBS; // y кнопок сортировки
    static {
        try {
            scannerYBS = new Scanner(new File("parameters/yBS.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scannerType; // типы кнопок сортировки
    static {
        try {
            scannerType = new Scanner(new File("parameters/type.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Scanner getScannerXBC() {
        return scannerXBC;
    }

    public static Scanner getScannerYBC() {
        return scannerYBC;
    }

    public static Scanner getScannerSemi() {
        return scannerSemi;
    }

    public static Scanner getScannerName() {
        return scannerName;
    }

    public static Scanner getScannerLink() {
        return scannerLink;
    }

    public static Scanner getScannerReligion() {
        return scannerReligion;
    }

    public static Scanner getScannerOfficiality() {
        return scannerOfficiality;
    }

    public static Scanner getScannerXBS() {
        return scannerXBS;
    }

    public static Scanner getScannerYBS() {
        return scannerYBS;
    }

    public static Scanner getScannerType() {
        return scannerType;
    }
}
