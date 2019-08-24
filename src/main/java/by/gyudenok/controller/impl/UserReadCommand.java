package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.controller.scanner.impl.UserDataFormatter;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
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

    @Override
    public String executeTask(String request) throws IOException, DAOException {
        LOGGER.info("Enter index of user: ");
        int id = DataEntry.enterInt();//validation
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
