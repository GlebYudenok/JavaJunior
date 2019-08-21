package by.gyudenok.dao;

import by.gyudenok.domain.User;

import java.io.IOException;
import java.util.List;

public interface DAO <T> {
    void create(T user) throws IOException;
    T read(int id) throws IOException;
    List<T> readAll() throws IOException;
    void update(T user, int id) throws IOException;
    void deleteByIndex(int index) throws IOException;
    void deleteById(int id);
}
