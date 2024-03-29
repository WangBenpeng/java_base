package com.pengo.xmljson;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pengo
 * @description:
 * @date 2022/2/17 10:23
 */
public class DomDemo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    static void test1() throws ParserConfigurationException, IOException, SAXException {
        InputStream input = new FileInputStream("src/main/resources/xml/book.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);
        printNode(doc, 0);
    }

    static void printNode(Node n, int indent) {
//        for (int i = 0; i < indent; i++) {
//            System.out.print("  ");
//        }
//        switch (n.getNodeType()) {
//            case Node.DOCUMENT_NODE:
//                System.out.println("Document:" + n.getNodeName());
//                break;
//            case Node.ELEMENT_NODE:
//                System.out.println("Element:" + n.getNodeName());
//                break;
//            case Node.TEXT_NODE:
//                System.out.println("Text:" + n.getNodeName() + "=" + n.getNodeValue());
//                break;
//            case Node.ATTRIBUTE_NODE:
//                System.out.println("Attr:" + n.getNodeName() + "=" + n.getNodeValue());
//                break;
//            default:
//                System.out.println("NodeType:" + n.getNodeType() + ",NodeName" + n.getNodeName());
//        }
//        for (Node child = n.getFirstChild(); child != null; child = n.getNextSibling()) {
//            printNode(child, indent + 1);
//        }
        for (int i = 0; i < indent; i++) {
            System.out.print(' ');
        }
        switch (n.getNodeType()) {
            case Node.DOCUMENT_NODE:
                System.out.println("Document: " + n.getNodeName());
                break;
            case Node.ELEMENT_NODE:
                System.out.println("Element: " + n.getNodeName());
                break;
            case Node.TEXT_NODE:
                System.out.println("Text: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.println("Attr: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.CDATA_SECTION_NODE:
                System.out.println("CDATA: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.COMMENT_NODE:
                System.out.println("Comment: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            default:
                System.out.println("NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName());
        }
        for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
            printNode(child, indent + 1);
        }
    }
}
