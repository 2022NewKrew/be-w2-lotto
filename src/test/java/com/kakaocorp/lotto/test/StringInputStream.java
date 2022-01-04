package com.kakaocorp.lotto.test;

import java.io.InputStream;

// https://stackoverflow.com/a/36286373
public class StringInputStream extends InputStream {

    byte[] bytes;
    int index = 0;

    public StringInputStream(byte[] bytes) {
        this.bytes = bytes;
    }

    public int read() {
        return bytes[index];
    }

    public int read(byte[] b, int off, int len) {
        if(index == bytes.length)
            return 0;
        b[0] = bytes[index++];
        return 1;
    }
}
