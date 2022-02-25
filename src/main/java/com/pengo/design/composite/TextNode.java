package com.pengo.design.composite;

import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 20:41
 */
public class TextNode implements Node{
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return List.of();
    }

    @Override
    public String toXml() {
        return text;
    }
}
