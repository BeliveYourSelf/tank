package com.mashibing.command;

public class CopyCommand implements CommandI{
    public String contend = "CopyCommand:";
    @Override
    public CommandI doit(String c) {
        contend += c;
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
