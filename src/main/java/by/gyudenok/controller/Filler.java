package by.gyudenok.controller;

import by.gyudenok.controller.scanner.DataEntry;
import by.gyudenok.controller.scanner.DataFormatter;
import by.gyudenok.controller.validator.EmailValidator;
import by.gyudenok.controller.validator.PhoneNumberValidator;
import by.gyudenok.controller.validator.RolesValidator;
import by.gyudenok.domain.Role;
import by.gyudenok.domain.User;
import by.gyudenok.exception.ValidatorExcepiton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Filler {

    private static final Logger LOGGER = LogManager.getLogger(Filler.class);
    private final EmailValidator emailValidator = new EmailValidator();
    private final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
    private final RolesValidator rolesValidator = new RolesValidator();

    public User fillFields() {
        String name, surname, email;
        List<String> phones = new ArrayList<>();
        List<Role> roles = new ArrayList<>();

        LOGGER.info("Enter name: ");
        name = DataEntry.enterString();
        LOGGER.info("Enter surname");
        surname = DataEntry.enterString();

        while (true){
            LOGGER.info("Enter email");
            email = DataEntry.enterString();
            if(emailValidator.validate(email) == true){
                break;
            }else {
                LOGGER.error("Wrong email input. In email need \'@\' and \'.\' symbol!");
            }
        }

        LOGGER.info("How much phones number you have?");

        int c = 0;
        while (true) {
            c = DataEntry.enterInt();
            if(phoneNumberValidator.validateAmountOfPhones(c)){
                break;
            }else {
                LOGGER.error("Amount of phones can be 1-3 only!");
            }
        }

        for (int i = 0; i < c; i++){
            while (true) {
                String number = new String();
                LOGGER.info("Enter ur " + (i + 1) + " number: ");
                number = DataEntry.enterString();
                try {
                    if(phoneNumberValidator.validateNumber(number)){
                        phones.add(number);
                        break;
                    }else {
                        LOGGER.error("Wrong phone number. Number should start with \'375\' prefix" +
                                "and have 12 digits!!!");
                    }
                } catch (ValidatorExcepiton validatorExcepiton) {
                    LOGGER.error("Wrong data input. Only numbers!!!");
                }
            }
        }

        LOGGER.info("How much roles you have?");

        while (true) {
            c = DataEntry.enterInt();
            if(rolesValidator.validateAmountOfRoles(c)){
                break;
            }else {
                LOGGER.error("Amount of roles can be 1-3 only!");
            }
        }

        for(int i = 0; i < c; i++){
            while (true) {
                String role;
                LOGGER.info("Enter ur " + (i + 1) + " role(ADMIN, USER, MANAGER): ");
                role = DataEntry.enterString();
                if(rolesValidator.validateRole(role) == true){
                    role = role.toUpperCase();
                    roles.add(Role.valueOf(role));
                    break;
                }else {
                    LOGGER.error("Wrong role. Role can be only this values: \'USER\', \'ADMIN\', \'MANAGER\'!!!");
                }
            }
        }

        User user = new User(name, surname, email, phones, roles);
        return user;
    }
}
