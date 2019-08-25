package by.gyudenok.controller;

import by.gyudenok.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.CREATE, new UserCreateCommand());
        repository.put(CommandName.READ, new UserReadCommand());
        repository.put(CommandName.UPDATE, new UserUpdateCommand());
        repository.put(CommandName.READ_ALL, new UserReadAllCommand());
        repository.put(CommandName.DELETE_BY_ID, new UserDeleteByIdCommand());
        repository.put(CommandName.DELETE_BY_INDEX, new UserDeleteByIndexCommand());
    }

    public Command getCommand(CommandName name){
        Command command = null;
        command = repository.get(name);
        return command;
    }
}
