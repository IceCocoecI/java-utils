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
}
