package by.gyudenok.presentation;

import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.Controller;
import by.gyudenok.controller.scanner.DataEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException {

        Controller controller = new Controller();

        while (true) {
            LOGGER.info("1. Create user");
            LOGGER.info("2. Edit user");
            LOGGER.info("3. Delete user by id");
            LOGGER.info("4. Delete user by index");
            LOGGER.info("5. Get user by index");
            LOGGER.info("6. Get all users");
            LOGGER.info("0. Exit");
            int c = DataEntry.enterInt();
            switch (c){
                case 1:
                    LOGGER.info("User creation...");
                    LOGGER.info(controller.executeTask(CommandName.CREATE.toString()));
                    break;
                case 2:
                    LOGGER.info("EDITING User");
                    break;
                case 3:
                    LOGGER.info("DElete by id");
                    break;
                case 4:
                    LOGGER.info("DElete by index");
                    break;
                case 5:
                    LOGGER.info("get by index");
                    break;
                case 6:
                    LOGGER.info("get all users");
                    break;
                case 0:
                    LOGGER.info("Exiting...");
                    System.exit(0);
                    break;
                    default:
                        LOGGER.error("Wrong command. Try again!");
            }
        }
    }
}
