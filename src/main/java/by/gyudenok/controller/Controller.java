package by.gyudenok.controller;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request){
        String commandName;
        Command executionCommand;

        commandName = request;
        executionCommand = provider.getCommand(commandName);
        String response = executionCommand.executeTask(request);
        return response;
    }
}
