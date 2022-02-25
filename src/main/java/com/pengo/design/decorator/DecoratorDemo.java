package com.pengo.design.decorator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 09:48
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        TextNode node1 = new SpanNode("span node");
        TextNode node2 = new BoldDecorator(new SpanNode("Bold Span node"));
        TextNode node3 = new DelDecorator(new BoldDecorator(new SpanNode("del bold span node")));
        System.out.println(node1.getText());
        System.out.println(node2.getText());
        System.out.println(node3.getText());
    }
}
