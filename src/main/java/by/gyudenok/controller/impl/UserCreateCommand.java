package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.Filler;
import by.gyudenok.controller.scanner.impl.UserDataFormatter;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UserCreateCommand extends Filler implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private static final Logger LOGGER = LogManager.getLogger(UserCreateCommand.class);

    @Override
    public String executeTask(CommandName request) throws IOException {
        User user = fillFields();
        userDAO.create(user);
        UserDataFormatter dataFormatter = new UserDataFormatter();
        String response = dataFormatter.formatUser(user);
        return response;
    }
}
