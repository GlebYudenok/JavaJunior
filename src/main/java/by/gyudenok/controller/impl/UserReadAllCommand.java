package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.controller.scanner.impl.UserListDataFormatter;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.User;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.Format;
import java.util.Formatter;
import java.util.List;

public class UserReadAllCommand implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private final static Logger LOGGER = LogManager.getLogger(UserReadCommand.class);

    @Override
    public String executeTask(CommandName request) throws IOException, DAOException {
        List<User> userList = null;
        try {
            userList = userDAO.readAll();
        } catch (DAOException e) {
            throw new DAOException();
        }
        DataFormatter<List<User>> formatter = new UserListDataFormatter();
        String response = formatter.formatUser(userList);
        return response;
    }
}
