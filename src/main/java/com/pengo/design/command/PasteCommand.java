package com.pengo.design.command;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 15:49
 */
public class PasteCommand implements Command{
    private TextEditor editor;

    public PasteCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        this.editor.paste();
    }
}
