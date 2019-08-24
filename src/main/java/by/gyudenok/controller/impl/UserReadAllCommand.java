package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.controller.scanner.impl.UserListDataFormatter;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.User;
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
    public String executeTask(String request) throws IOException {
        List<User> userList = userDAO.readAll();
        DataFormatter<List<User>> formatter = new UserListDataFormatter();
        String response = formatter.formatUser(userList);
        return response;
    }
}
