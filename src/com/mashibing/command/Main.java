package com.mashibing.command;

public class Main {
    public static void main(String[] args) {
        ChainCommand chainCommand = new ChainCommand();
        chainCommand.addCommand(new CopyCommand().doit("我是copyComand"));
        chainCommand.addCommand(new CutCommand().doit("我是cutCommand"));
        chainCommand.addCommand(new PasteCommand().doit("我是pasteCommand"));
        chainCommand.sout();

        chainCommand.used();
        chainCommand.used();
        chainCommand.used();
        chainCommand.used();


    }
}
