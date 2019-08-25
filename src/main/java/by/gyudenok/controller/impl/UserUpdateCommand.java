package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.Filler;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.impl.UserDataFormatter;
import by.gyudenok.controller.validator.UserIndexValidator;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.dao.impl.FileUserDAO;
import by.gyudenok.domain.User;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UserUpdateCommand extends Filler implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private static final Logger LOGGER = LogManager.getLogger(UserUpdateCommand.class);
    private final UserIndexValidator validator = new UserIndexValidator();

    @Override
    public String executeTask(CommandName request) throws IOException, DAOException {
        int index = choose();
        User user = fillFields();
        userDAO.update(user, index);
        UserDataFormatter dataFormatter = new UserDataFormatter();
        String response = dataFormatter.formatUser(user);
        return response;
    }

    private int choose() throws IOException, DAOException {
        LOGGER.info("Enter index of raw, which need update: ");
        int index;

        while (true) {
            index = DataEntry.enterInt();
            if (validator.validateIndex(index, (FileUserDAO)userDAO)) {
                break;
            } else {
                LOGGER.error("Wrong index of user!!!");
            }
        }
        return index;
    }
}