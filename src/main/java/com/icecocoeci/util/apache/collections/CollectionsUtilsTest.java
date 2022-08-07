package com.icecocoeci.util.apache.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/06/16:59
 * @Description:
 */
public class CollectionsUtilsTest {
    /**
     * CollectionUtils.isEmpty
     * MapUtils.isEmpty
     * 判断list、set不为空（null/size=0）
     */
    @Test
    public void testCollectionsUtils(){
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        // true
        System.out.println(CollectionUtils.isEmpty(list));
        // 反过来 false
        System.out.println(CollectionUtils.isNotEmpty(list));

        // true
        System.out.println(MapUtils.isEmpty(map));
        // 反过来 false
        System.out.println(MapUtils.isNotEmpty(map));

        // true
        System.out.println(CollectionUtils.isEmpty(set));
        // 反过来 false
        System.out.println(MapUtils.isNotEmpty(map));
    }

    /**
     * CollectionUtils.intersection
     * CollectionUtils.union
     * CollectionUtils.subtract
     * 交集、并集、差集
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> list2 = new ArrayList<>();
        list2.add("c");
        list2.add("2");
        list2.add("3");
        // 取交集 [c]
        Collection<String> intersection = CollectionUtils.intersection(list, list2);
        System.out.println(intersection);

        // 取并集 [a, b, 2, c, 3]
        Collection<String> union = CollectionUtils.union(list, list2);
        System.out.println(union);

        // 取差集 [a, b]
        Collection<String> subtract = CollectionUtils.subtract(list, list2);
        System.out.println(subtract);
    }
}
