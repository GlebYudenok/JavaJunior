package by.gyudenok.controller.scanner.impl;

import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.domain.User;

public class UserDataFormatter implements DataFormatter<User> {

    @Override
    public String formatUser(User user){

        String formattedString = new String("+==============================+" +
                "\t\n   User: \n");
        formattedString += "\t|\tid: " + user.getUserId()
                + '\n' + "\t|\tName: " + user.getName()
                + '\n' + "\t|\tSurname: " + user.getSurname()
                + '\n' + "\t|\tEmail: " + user.getEmail() + '\n'
                + "\t|\tPhones: \n";
        for(int i = 0; i < user.getPhones().size(); i++){
            formattedString += "\t|\t\t" + user.getPhones().get(i) + '\n';
        }
        formattedString += "\t|\tRoles: \n";
        for(int i = 0; i < user.getRoles().size(); i++){
            formattedString += "\t|\t\t" + user.getRoles().get(i).toString() + '\n';
        }
        return formattedString;
    }
}
