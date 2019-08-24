package by.gyudenok.controller.scanner.impl;

import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.domain.User;

import java.util.List;

public class UserListDataFormatter implements DataFormatter<List<User>> {

    @Override
    public String formatUser(List<User> userList) {
        DataFormatter<User> userFormatter = new UserDataFormatter();
        String response = new String("+=============================" +
                "=================+\nUsers: \n");
        for(User user : userList){
            response += userFormatter.formatUser(user);
        }
        response += "+============================================+";
        return response;
    }
}
