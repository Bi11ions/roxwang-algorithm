package com.chapter1;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 13:40
 */
public class MemoryCell {
    private Object storedValue;

    public Object read() {
        return storedValue;
    }

    public void write(Object value) {
        this.storedValue = value;
    }
}
