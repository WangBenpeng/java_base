package com.pengo.xmljson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengo
 * @description:
 * @date 2022/2/17 11:33
 */
public class JacksonDemo {
    public static void main(String[] args) throws Exception{
        test4();
    }

    static void test4() throws Exception{
        InputStream input = new FileInputStream("src/main/resources/xml/book.json");
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.toString());
    }

    static void test3() throws JsonProcessingException {
        Book book = new Book();
        book.id = 2;
        Map<String, String> map = new HashMap<>();
        map.put("a", "b ");
        book.author = map;
        book.isbn = new BigInteger("100");
        book.pubDate = LocalDate.now();
        book.name = "name";
        List<String> list = new ArrayList<>();
        list.add("1");
        book.tags = list;
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(book);
        System.out.println(s);
    }

    static void test2() throws Exception {
        InputStream input = new FileInputStream("src/main/resources/xml/book.json");
        ObjectMapper mapper = new ObjectMapper();
        // 反序列化时忽略不存在的JavaBean属性:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.toString());
    }

    static void test1() throws Exception{
        InputStream input = new FileInputStream("src/main/resources/xml/book.xml");
        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        XmlMapper xmlMapper = new XmlMapper(jacksonXmlModule);
        Book book = xmlMapper.readValue(input, Book.class);
        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);
    }
}

class Book{
    public long id;
    public String name;
    public Map<String,String> author;
    @JsonDeserialize(using = IsBnDeserializer.class)
    public BigInteger isbn;
    public List<String> tags;
    public LocalDate pubDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}

class IsBnDeserializer extends JsonDeserializer<BigInteger> {

    @Override
    public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String s = jsonParser.getValueAsString();
        if (s != null) {
            try {
                return new BigInteger(s.replaceAll("-", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}