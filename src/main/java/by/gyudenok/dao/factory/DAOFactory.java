package by.gyudenok.dao.factory;

import by.gyudenok.dao.DAO;
import by.gyudenok.dao.impl.FileUserDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final DAO fileUserImpl = new FileUserDAO();

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return instance;
    }

    public DAO getFileUserDAO(){
        return fileUserImpl;
    }
}
