package com.pengo.design.composite;

import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 20:43
 */
public class CommentNode implements Node{
    private String text;

    public CommentNode(String text) {
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
        return "<!--" + text + "-->";
    }
}
