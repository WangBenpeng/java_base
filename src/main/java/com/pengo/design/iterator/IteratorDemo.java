package com.pengo.design.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 16:06
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ReverseArrayCollection<String> collection = new ReverseArrayCollection<>("a", "b", "c", "d");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class ReverseArrayCollection<T> implements Iterable<T> {
    private T[] array;

    public ReverseArrayCollection(T...objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        public ReverseIterator() {
            this.index = ReverseArrayCollection.this.array.length;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return array[index];
        }
    }
}
