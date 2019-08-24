package by.gyudenok.controller.scanner.impl;

import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.domain.User;

public class UserDataFormatter implements DataFormatter<User> {

    @Override
    public String formatUser(User user){
        String formattedString = new String("User: \n");
        formattedString += "id: " + user.getUserId()
                + '\n' + "Name: " + user.getName()
                + '\n' + "Surname: " + user.getSurname()
                + '\n' + "Email: " + user.getEmail() + '\n' + "Phones: \n";
        for(int i = 0; i < user.getPhones().size(); i++){
            formattedString += '\t' + user.getPhones().get(i) + '\n';
        }
        formattedString += "Roles: \n";
        for(int i = 0; i < user.getRoles().size(); i++){
            formattedString += '\t' + user.getRoles().get(i).toString() + '\n';
        }
        return formattedString + '\n';
    }
}
