package com.pengo.design.command;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 15:41
 */
public class CommandDemo {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
        editor.copy();
        editor.paste();
        System.out.println(editor.getState());
        System.out.println("----command----");
        TextEditor editor2 = new TextEditor();
        editor.add("Command pattern in text editor.\n");
        CopyCommand copyCommand = new CopyCommand(editor2);
        copyCommand.execute();
        PasteCommand pasteCommand = new PasteCommand(editor2);
        pasteCommand.execute();

    }
}
