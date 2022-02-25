package com.pengo.design.composite;

/**
 * @author pengo
 * @description:
 * @date 2022/2/23 20:33
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Node root = new ElementNode("School");
        root.add(new ElementNode("ClassA")
                .add(new TextNode("Tom"))
                .add(new TextNode("Alice")));
        root.add(new ElementNode("ClassB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Alice"))
                .add(new CommentNode("comment...")));
        System.out.println(root.toXml());
    }
}
