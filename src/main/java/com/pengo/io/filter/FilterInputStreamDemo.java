package com.pengo.io.filter;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author pengo
 * @description:
 * @date 2021/12/6 10:45 下午
 */
public class FilterInputStreamDemo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    static void test1() throws IOException{
        byte[] bytes = "Hello".getBytes(StandardCharsets.UTF_8);
        try (CountInputStream is = new CountInputStream(
                new ByteArrayInputStream(bytes))) {
            int n;
            while ((n = is.readBytes()) != -1) {
                System.out.println((char)n);
            }
            System.out.println("total count:"+is.getN());
        }
    }
}

class CountInputStream extends FilterInputStream{
    private int count = 0;
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected CountInputStream(InputStream in) {
        super(in);
    }

    public int readBytes() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count++;
        }
        return n;
    }

    public int getN() {
        return this.count;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}
