package com.mashibing.command;

public class CutCommand implements CommandI{
    public String contend = "CutCommand:";
    @Override
    public CommandI doit(String c) {
        contend+=c;
        return this;
    }

    @Override
    public void undo() {

    }

    @Override
    public String getContend() {
        return this.contend;
    }
}
