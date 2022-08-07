package com.icecocoeci.util.apache.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/06/16:45
 * @Description:
 */
public class ArrayUtilsTest {
    /**
     * ArrayUtils.isEmpty
     * 判断一个数组是不是空的，null/长度为0
     */
    @Test
    public void test(){
        Integer[] ints = new Integer[0];
        // true
        System.out.println(ArrayUtils.isEmpty(ints));

        ints = null;
        // true
        System.out.println(ArrayUtils.isEmpty(ints));
    }

    /**
     * 给已有数组添加元素
     */
    @Test
    public void testIsEmpty(){
        Integer[] ints = new Integer[1];
        ints[0] = 3;
        // toString打印数组内容 {3}
        System.out.println(ArrayUtils.toString(ints));
        // add会自动创建新数组 {3,7}
        Integer[] add = ArrayUtils.add(ints, 7);
        System.out.println(ArrayUtils.toString(add));
    }
}
