package by.gyudenok.controller;

import by.gyudenok.exception.DAOException;
import by.gyudenok.exception.ValidatorExcepiton;

import java.io.IOException;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(CommandName request) throws IOException, DAOException {
        Command executionCommand;

        executionCommand = provider.getCommand(request);
        String response = executionCommand.executeTask(request);
        return response;
    }
}
