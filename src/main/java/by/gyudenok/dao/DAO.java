package by.gyudenok.dao;

import by.gyudenok.exception.DAOException;
import by.gyudenok.exception.ValidatorExcepiton;
import java.io.IOException;
import java.util.List;

public interface DAO <T> {
    void create(T user) throws IOException;
    T read(int id) throws IOException, DAOException;
    List<T> readAll() throws IOException, DAOException;
    void update(T user, int id) throws IOException, DAOException;
    void deleteByIndex(int index) throws IOException;
    void deleteById(int id) throws IOException, ValidatorExcepiton;
}
