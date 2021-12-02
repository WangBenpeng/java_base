package com.pengo.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 10:26 下午
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ReserveList<String> list = new ReserveList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class ReserveList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReserveIterator(list.size());
    }

    class ReserveIterator implements Iterator<T> {
        int index;

        public ReserveIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReserveList.this.list.get(index);
        }
    }
}
