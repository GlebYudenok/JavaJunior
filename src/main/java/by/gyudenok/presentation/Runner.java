package by.gyudenok.presentation;

import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.Controller;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

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
                    try {
                        LOGGER.info(controller.executeTask(CommandName.CREATE.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
                    break;
                case 2:
                    LOGGER.info("User editing by index...");
                    try {
                        LOGGER.info(controller.executeTask(CommandName.UPDATE.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
                    break;
                case 3:
                    LOGGER.info("Deleton by id...");
                    try {
                        LOGGER.info(controller.executeTask(CommandName.DELETE_BY_ID.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
                    break;
                case 4:
                    LOGGER.info("Deletion by index...");
                    try {
                        LOGGER.info(controller.executeTask(CommandName.DELETE_BY_INDEX.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
                    break;
                case 5:
                    LOGGER.info("Get user by index...");
                    try {
                        LOGGER.info(controller.executeTask(CommandName.READ.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
                    break;
                case 6:
                    LOGGER.info("Get all users...");
                    try {
                        LOGGER.info(controller.executeTask(CommandName.READ_ALL.toString()));
                    } catch (DAOException | IOException e) {
                        LOGGER.error("The file does not exist or it contains incorrect data!");
                    }
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
