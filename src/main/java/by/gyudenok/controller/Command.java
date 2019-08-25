package by.gyudenok.controller;

import by.gyudenok.exception.DAOException;

import java.io.IOException;

public interface Command {
    String executeTask(CommandName request) throws IOException, DAOException;
}
