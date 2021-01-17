package com.mashibing.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChainCommand {

    public static List<CommandI> commandIList = new ArrayList<>();

    public boolean addCommand(CommandI commandI){
        try {
            commandIList.add(commandI);
            System.out.println("成功：向责任链添加Command" + convert(commandI));
            return true;
        }catch (Exception e){
            System.out.println("失败：向责任链添加Command" + convert(commandI));
            return false;
        }
    }

    public boolean used(){
        int chainSize = commandIList.size();
        if (chainSize <= 0) {
            System.out.println("没有可回退的步骤了");
            return false;
        }
        CommandI commandIRemove = commandIList.remove(chainSize-1);
        System.out.println("ctrl + z:"+commandIRemove);
        System.out.println("回退成功");
        return true;
    }
    public void sout(){
        Iterator iterator = commandIList.iterator();
        while(iterator.hasNext()) {
            CommandI commandI = (CommandI) iterator.next();
            System.out.println(convert(commandI));
        }

    }

     public String convert(CommandI commandI){
        if(commandI instanceof CutCommand){
            CutCommand cutCommand= (CutCommand)commandI;
            return cutCommand.getContend();
        }
         if(commandI instanceof PasteCommand){
             PasteCommand pasteCommand= (PasteCommand)commandI;
             return pasteCommand.getContend();
         }
         if(commandI instanceof CopyCommand){
             CopyCommand copyCommand= (CopyCommand)commandI;
             return copyCommand.getContend();
         }
            return null;

        }


}
