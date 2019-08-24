package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.Filler;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.impl.UserDataFormatter;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UserUpdateCommand extends Filler implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private static final Logger LOGGER = LogManager.getLogger(UserUpdateCommand.class);

    @Override
    public String executeTask(String request) throws IOException {
        int index = choose();
        User user = fillFields();
        userDAO.update(user, index);
        UserDataFormatter dataFormatter = new UserDataFormatter();
        String response = dataFormatter.formatUser(user);
        return response;
    }

    private int choose(){
        LOGGER.info("Enter index of raw, which need update: ");
        int index = DataEntry.enterInt();//validation
        return index;
    }
}