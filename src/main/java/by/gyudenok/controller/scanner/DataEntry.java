package by.gyudenok.controller.scanner;

import java.util.Scanner;

public class DataEntry {

    public static int enterInt(){
        int num = 0;

        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            }
        }
        return num;
    }

    public static String enterString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
