package by.gyudenok.controller;

import by.gyudenok.exception.DAOException;

import java.io.IOException;

public interface Command {
    String executeTask(String request) throws IOException, DAOException;
}
