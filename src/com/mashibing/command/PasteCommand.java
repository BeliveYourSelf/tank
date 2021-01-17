package com.mashibing.command;

public class PasteCommand implements CommandI{
    public String contend = "PasteCommand:";
    @Override
    public PasteCommand doit(String c) {
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
