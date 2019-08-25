package by.gyudenok.controller.validator;

import by.gyudenok.dao.impl.FileUserDAO;
import by.gyudenok.exception.DAOException;

import java.io.IOException;
import java.util.logging.Logger;

public class UserIndexValidator {

    public boolean validateIndex(final int index, FileUserDAO dao) throws IOException, DAOException {
        try {
            dao.read(index);
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
