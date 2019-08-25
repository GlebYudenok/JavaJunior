package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.controller.scanner.impl.UserDataFormatter;
import by.gyudenok.controller.validator.UserIndexValidator;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.dao.impl.FileUserDAO;
import by.gyudenok.domain.User;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.crypto.Data;
import java.io.IOException;

public class UserReadCommand implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private final static Logger LOGGER = LogManager.getLogger(UserReadCommand.class);
    private final UserIndexValidator validator = new UserIndexValidator();

    @Override
    public String executeTask(String request) throws IOException, DAOException {

        int id;
        while (true) {
            LOGGER.info("Enter index of user: ");
            id = DataEntry.enterInt();
            if (validator.validateIndex(id, (FileUserDAO) userDAO)) {
                break;
            }else {
                LOGGER.error("Wrong index of user!!!");
            }
        }

        User u = null;
        try {
            u = userDAO.read(id);
        } catch (DAOException e) {
            throw new DAOException();
        }

        DataFormatter<User> formatter = new UserDataFormatter();
        return formatter.formatUser(u);
    }
}
