package com.mashibing.command;

public interface CommandI {
    public String contend = null;
    public CommandI doit(String c);
    public void undo();

    public String getContend();
}
