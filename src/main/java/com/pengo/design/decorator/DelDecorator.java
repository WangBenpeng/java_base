package com.pengo.design.decorator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 09:55
 */
public class DelDecorator extends NodeDecorator{
    public DelDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<del>"+target.getText()+"</del>";
    }
}
