package by.gyudenok.dao;

import by.gyudenok.domain.User;

import java.io.IOException;

public interface DAO <T> {
    void create(T user) throws IOException;
    T read(int id) throws IOException;
    T read(T user);
    T readAll();
    void update(T user, int id) throws IOException;
    void delete(int id);
    void delete(User user);
}
