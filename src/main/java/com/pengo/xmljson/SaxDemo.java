package com.pengo.xmljson;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author pengo
 * @description:
 * @date 2022/2/17 10:58
 */
public class SaxDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    static void test2() throws Exception{
        InputStream input = new FileInputStream("src/main/resources/xml/book.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(input,new MyHandler());
    }

}

class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        print("start document");
    }

    @Override
    public void endDocument() throws SAXException {
        print("end document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start element:", localName, qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        print("end element:", localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        print("characters:", new String(ch, start, length));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        print("error:", e);
    }

    void print(Object... objects) {
        for (Object obj : objects) {
            System.out.print(obj);
            System.out.print("   ");
        }
        System.out.println();
    }
}