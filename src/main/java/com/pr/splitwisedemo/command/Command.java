package com.pr.splitwisedemo.command;

public interface Command {
    boolean matches(String cmd);
    void execute(String cmd);
}
