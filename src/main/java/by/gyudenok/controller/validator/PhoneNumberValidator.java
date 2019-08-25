package by.gyudenok.controller.validator;

import by.gyudenok.exception.ValidatorExcepiton;

import javax.xml.bind.ValidationException;

public class PhoneNumberValidator {

    private static final short amountOfDigitsInNumber = 12;

    public boolean validateNumber(final String hex) throws ValidatorExcepiton {
        Long num;
        try {
            num = Long.valueOf(hex);
        }catch (NumberFormatException e){
            throw new ValidatorExcepiton();
        }
        return ((hex.startsWith("375")) && (hex.length() == amountOfDigitsInNumber) ? true : false);
    }

    public boolean validateAmountOfPhones(final int amount) {
        return (amount > 0 && amount <= 3) ? true : false;
    }
}
