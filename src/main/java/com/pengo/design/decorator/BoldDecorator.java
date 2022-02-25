package com.pengo.design.decorator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 09:52
 */
public class BoldDecorator extends NodeDecorator{

    public BoldDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<b>"+target.getText()+"</b>";
    }
}
