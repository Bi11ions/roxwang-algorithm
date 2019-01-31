package com.chapter1;

import org.junit.Test;

/**
 * @author wangsen@qgutech.com
 * @since 2019/1/31 13:43
 */
public class Test1 {

    @Test
    public void test01(){
        MemoryCell memoryCell = new MemoryCell();
        memoryCell.write("47");
        String value = (String) memoryCell.read();
        System.out.println("Content are : " + value);
    }

    @Test
    public void testGenericMemoryCell() {
        GenericMemoryCell<String> memoryCell = new GenericMemoryCell<>();
        memoryCell.write("String");
        String read = memoryCell.read();
        System.out.println(read);
    }
}
