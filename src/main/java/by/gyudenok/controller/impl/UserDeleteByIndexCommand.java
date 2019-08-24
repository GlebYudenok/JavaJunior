package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UserDeleteByIndexCommand implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private final static Logger LOGGER = LogManager.getLogger(UserReadCommand.class);

    @Override
    public String executeTask(String request) throws IOException {
        LOGGER.info("Enter index of user which need delete: ");
        int index = DataEntry.enterInt();//validation
        userDAO.deleteByIndex(index);
        return "User with " + index + " index was deleted successfully!";
    }
}
