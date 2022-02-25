package com.pengo.design.decorator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 09:50
 */
public abstract class NodeDecorator implements TextNode{
    protected final TextNode target;

    public NodeDecorator(TextNode target) {
        this.target = target;
    }

    @Override
    public void setText(String text) {
        this.target.setText(text);
    }
}
