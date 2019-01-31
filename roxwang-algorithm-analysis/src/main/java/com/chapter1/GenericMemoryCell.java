package com.chapter1;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 13:54
 */
public class GenericMemoryCell<T> {
    private T storedValue;

    public T read() {
        return storedValue;
    }

    public void write(T value) {
        this.storedValue = value;
    }
}
