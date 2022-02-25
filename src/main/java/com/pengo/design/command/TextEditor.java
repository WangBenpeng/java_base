package com.pengo.design.command;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 15:42
 */
public class TextEditor {
    private StringBuilder buffer = new StringBuilder();
    public void copy() {
//        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable text = new StringSelection(buffer.toString());
//        clip.setContents(text, null);
        buffer.append("copy");
        System.out.println("copy method...");
    }

    public void paste() {
//        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable clipTf = sysClip.getContents(null);
//        if (clipTf != null) {
//            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
//                try {
//                    String text = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
//                    add(text);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        buffer.toString();
        System.out.println("paste method...");
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public String getState() {
        return buffer.toString();
    }

    public void print() {
        System.out.println(this.buffer.toString());
    }
}
