package by.gyudenok.controller.impl;

import by.gyudenok.controller.Command;
import by.gyudenok.controller.CommandName;
import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.dao.DAO;
import by.gyudenok.dao.factory.DAOFactory;
import by.gyudenok.domain.Role;
import by.gyudenok.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCreateCommand implements Command {

    private final DAO<User> userDAO = DAOFactory.getInstance()
            .getFileUserDAO();
    private static final Logger LOGGER = LogManager.getLogger(UserCreateCommand.class);

    @Override
    public String executeTask(String request) throws IOException {
        User user = fillFields();
        userDAO.create(user);
        return user.toString();
    }

    private User fillFields(){
        String name, surname, email;
        List<String> phones = new ArrayList<>();
        List<Role> roles = new ArrayList<>();

        LOGGER.info("Enter name: ");
        name = DataEntry.enterString();
        LOGGER.info("Enter surname");
        surname = DataEntry.enterString();
        LOGGER.info("Enter email");
        email = DataEntry.enterString();
        LOGGER.info("How much phones number you have?");
        int c = DataEntry.enterInt();//Тут должна быть валидация
        for (int i = 0; i < c; i++){
            LOGGER.info("Enter ur " + i + " number: ");
            phones.add(DataEntry.enterString());//Тут тоже валидация
        }
        LOGGER.info("How much roles you have?");
        c = DataEntry.enterInt();//Валидация
        for(int i = 0; i < c; i++){
            LOGGER.info("Enter ur " + i + " role(ADMIN, USER, MANAGER): ");
            roles.add(Role.valueOf(DataEntry.enterString()));//Валидация
        }

        User user = new User(name, surname, email, phones, roles);
        return user;
    }
}
