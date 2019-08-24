package by.gyudenok.controller.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DataEntry {

    private static final Logger LOGGER = LogManager.getLogger(DataEntry.class);

    public static int enterInt(){
        int num = 0;

        while (true) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            }
            LOGGER.error("Wrong command. Input only numbers!");
        }
        return num;
    }

    public static String enterString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
