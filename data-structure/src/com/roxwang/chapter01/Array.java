package com.roxwang.chapter01;

/**
 * @author wangsen@qgutech.com
 * @since 2019/2/25 18:00
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 带参构造函数
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return int
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     *
     * @return int
     */
    public int getCapacity() {
        return data.length;
    }

    public Boolean isEmpty() {
        return 0 == this.size;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在 index 的位置插入一个新的元素 e
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("向数组中添加元素失败，索引非法");
        }

        // 扩容
        if (size == data.length) {
            resize(2 * data.length);
        }


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 对数组进行扩容
     *
     * @param newCapacity 数组新的 capacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }

        res.append(']');
        return res.toString();
    }

    public E get(int index) {
        if (0 > index || size <= index) {
            throw new IllegalArgumentException("获取数组元素失败，索引非法");
        }

        return data[index];
    }

    public E getLast() {
        return get(this.size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (0 > index || size <= index) {
            throw new IllegalArgumentException("设置元素失败，索引非法");
        }

        data[index] = e;
    }

    public Boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中的元素，如果不存在元素 e，返回 -1
     *
     * @param e 查找的目标元素
     * @return 元素所在位置的坐标
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    public E remove(int index) {
        if (0 > index || index >= size) {
            throw new IllegalArgumentException("删除失败，非法的索引");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        // 清空引用，使GC回收掉，loitering objects != memory leak
        data[size] = null;
        size--;

        if (size == data.length / 4 && 0 != data.length / 2) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
        }
    }
}
