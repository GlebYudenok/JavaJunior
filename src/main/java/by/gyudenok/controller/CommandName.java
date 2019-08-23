package by.gyudenok.controller;

public enum CommandName {
    CREATE,
    READ,
    UPDATE,
    READ_ALL,
    DELETE_BY_ID,
    DELETE_BY_INDEX,
    EXIT;

    public static CommandName getById(final int id){
        return CommandName.values()[id];
    }
}
