package by.gyudenok.controller;

import by.gyudenok.exception.DAOException;
import by.gyudenok.exception.ValidatorExcepiton;

import java.io.IOException;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) throws IOException, DAOException {
        String commandName;
        Command executionCommand;

        commandName = request;
        executionCommand = provider.getCommand(commandName);
        String response = executionCommand.executeTask(request);
        return response;
    }
}
