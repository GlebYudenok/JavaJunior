package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.validator.UserIndexValidator;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.dao.impl.FileUserDAO;
import by.gyudenok.domain.User;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UserDeleteByIndexCommand implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private final static Logger LOGGER = LogManager.getLogger(UserReadCommand.class);
    private final UserIndexValidator validator = new UserIndexValidator();

    @Override
    public String executeTask(CommandName request) throws IOException, DAOException {
        int index;

        while (true) {
            LOGGER.info("Enter index of user which need delete: ");
            index = DataEntry.enterInt();
            if (validator.validateIndex(index, (FileUserDAO)userDAO)){
                userDAO.deleteByIndex(index);
                break;
            }else {
                LOGGER.error("No user with this id!");
            }
        }
        return "User with " + index + " index was deleted successfully!";
    }
}
