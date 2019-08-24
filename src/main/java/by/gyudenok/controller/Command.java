package by.gyudenok.controller;

import java.io.IOException;

public interface Command {
    String executeTask(String request) throws IOException;
}
