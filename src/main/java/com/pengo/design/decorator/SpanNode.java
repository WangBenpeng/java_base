package com.pengo.design.decorator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 09:49
 */
public class SpanNode implements TextNode{
    private String text;

    public SpanNode(String text) {
        this.text = text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return "<span>" + this.text + "</span>";
    }
}
