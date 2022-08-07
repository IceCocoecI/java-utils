package com.icecocoeci.util.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/07/10:50
 * @Description:
 */
public class GuavaTest {
    /**
     * Joiner 把集合（或数组或可变参数）通过指定的分隔符连接成字符串
     * Joiner.on
     */
    @Test
    public void testGuava(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(null);

        // 方式一
        Joiner joiner = Joiner.on(",")
                // 忽略null
                // .skipNulls();
                // 替代null默认值
                  .useForNull("这是替代null的默认值");
        String join = joiner.join(list);
        // a,b,c,这是替代null的默认值
        System.out.println(join);

        // 方式二 java 8
        String collect = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(","));
        // java 8: a,b,c
        System.out.println("java 8: "+collect);
    }

    /**
     * 通过指定的分隔符把字符串转为集合
     * Splitter.on
     */
    @Test
    public void testSplitter(){
        String str = " a ,b,\"\",c,,";
        // on 设定字符串的分隔符
        Splitter splitter = Splitter.on(",")
                // 去除每个元素的前后空格
                .trimResults()
                // 过滤掉空字符串（不包括“”）
                .omitEmptyStrings();
        Iterable<String> iterable = splitter.split(str);
        // [a, b, "", c]
        System.out.println(iterable);

        List<String> list = splitter.splitToList(str);
        // [a, b, "", c]
        System.out.println(list);
    }

    /**
     * 下划线与驼峰互相转化
     *  eg: student_name studentName
     */
    @Test
    public void testCaseFormat(){
        String str = "student_name";
        // 下划线转驼峰
        // 首字母小写 studentName
        String s1 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
        System.out.println(s1);
        // 首字母大写 StudentName
        String s2 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
        System.out.println(s2);

        // 驼峰转下划线
        String str2 = "studentName";
        String s3 = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str2);
        System.out.println(s3);
    }

    /**
     * Lists的用法 ，另有Sets、Maps。
     */
    @Test
    public void testLists(){
        // 常规方式
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Guava 简化
        List<String> list2 = Lists.newArrayList("a", "b", "c");

        // 集合分组，例如要求传ids，一次最多传n个
        List<List<String>> partition = Lists.partition(list2, 2);
        System.out.println(partition);

        for (List<String> ids : partition){
            // api(ids);
        }
    }


    /**
     * Ints
     * Longs
     * Floats
     * ...
     */
    @Test
    public void testInts(){
        List<Integer> integers = Ints.asList(1, 2, 3);
    }


    /**
     * Multiset
     * 需求：可重复，无序
     * jdk list 元素可重复的有序集合
     * jdk set 元素不可重复的无序集合
     */
    @Test
    public void testMultiset(){
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("a");
        System.out.println(multiset);
        Set<Multiset.Entry<String>> entries = multiset.entrySet();
        for (Multiset.Entry<String> entry:entries){
            System.out.println("元素:"+entry.getElement()+"个数："+entry.getCount());
        }

        Set<String> set = multiset.elementSet();
        for (String str : set){
            System.out.println(str);
        }
    }

    /**
     * HashMultimap用来替代jdk原生的Map<String,Collection<String>> map;
     */
    @Test
    public void testHashMultimap(){
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("a","1");
        multimap.put("a","2");
        multimap.put("a","3");
        // {a=[1, 2, 3]}
        System.out.println(multimap);

        // [1, 2, 3]
        Collection<String> collection = multimap.get("a");
        System.out.println(collection);

        // false
        System.out.println(multimap.containsEntry("a","4"));

        // 转化成jdk原生api的数据结构 {a=[1, 2, 3]}
        Map<String, Collection<String>> jdkMap = multimap.asMap();
        System.out.println(jdkMap);
    }


    /**
     * 不可变集合
     * ImmutableList
     */
    @Test
    public void testImmutableList(){
        List<String> list = new ArrayList<>();
        list.add("aa");

        // 案例：如果把list放到了缓存里，如何强制约束别人不能改我的list
        ImmutableList<Object> immutableList = ImmutableList.builder().add("aa").build();
        // 可以把immutableList放到缓存中
        // 添加会报错 UnsupportedOperationException
        // immutableList.add("bbb");

        //jdk原生 源头改变了依然能添加
        list.add("pre-add");
        List<String> jdkUnmodifiableList = Collections.unmodifiableList(list);
        // 添加会报错 UnsupportedOperationException
        //jdkUnmodifiableList.add("jdkUnmodifiableList");
        System.out.println(jdkUnmodifiableList);
    }

    /**
     *
     */
    @Test
    public void test(){
        String param = null;
//        if (param == null){
//            throw new RuntimeException("参数不能为空");
//        }

        // 简洁写法 java.lang.NullPointerException: 参数不能为空
        // Preconditions.checkNotNull(param,"参数不能为空");

        // expression 布尔值的表达式，true则校验通过，不抛出异常，false则抛出异常
        // java.lang.IllegalArgumentException: 参数不能为空
        Preconditions.checkArgument(param != null,"参数不能为空");
    }
}
