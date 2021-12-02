package com.pengo.collection.set;

import java.util.*;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 10:08 上午
 */
public class SetDemo {

    public static void main(String[] args) {
        testMessage();
    }

    public static void testMessage() {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message displayMessage : displayMessages) {
            System.out.println(displayMessage.text);
        }
    }

    public static List<Message> process(List<Message> received) {
        Set<Message> messages = new HashSet<>();
        for (Message message : received) {
            messages.add(message);
        }
        List<Message> returned = new ArrayList<>();
        for (Message message : messages) {
            returned.add(message);
        }
        return returned;
    }


    public static void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("banana");
        System.out.println(set.add("apple"));
        System.out.println(set.contains("apple"));
        System.out.println(set.remove("banana"));
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void testTreeSet() {
        Set<String> set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
 class Message{
     public final int sequence;
     public final String text;
     public Message(int sequence, String text) {
         this.sequence = sequence;
         this.text = text;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Message message = (Message) o;
         return sequence == message.sequence && Objects.equals(text, message.text);
     }

     @Override
     public int hashCode() {
         return Objects.hash(sequence, text);
     }
 }