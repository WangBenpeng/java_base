package com.pengo.design.composite;

import java.util.List;

public interface Node {
    Node add(Node node);
    List<Node> children();
    String toXml();
}
