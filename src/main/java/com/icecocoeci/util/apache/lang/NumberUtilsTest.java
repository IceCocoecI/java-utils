package com.icecocoeci.util.apache.lang;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/06/16:02
 * @Description:
 */
public class NumberUtilsTest {
    /**
     *  NumberUtils.isDigits
     * 判断String类型的参数是不是整数 当做十进制处理
     */
    @Test
    public void testDigits(){
        String str = "123.3abc";
        String str2 = "123.3";
        String str3 = "123";

        // 只能判断整数
        // false
        boolean digits1 = NumberUtils.isDigits(str);
        System.out.println(digits1);
        // false
        boolean digits2 = NumberUtils.isDigits(str2);
        System.out.println(digits2);
        // true
        boolean digits3 = NumberUtils.isDigits(str3);
        System.out.println(digits3);
    }

    /**
     *  NumberUtils.isParsable
     * 判断String类型的参数是不是数字（整数、浮点数） 注意不能识别正 貌似可以识别负
     */
    @Test
    public void testParsable(){
        String str = "123.3abc";
        String str2 = "123.3";
        String str3 = "+123";

        // false
        boolean digits1 = NumberUtils.isParsable(str);
        System.out.println(digits1);
        // true
        boolean digits2 = NumberUtils.isParsable(str2);
        System.out.println(digits2);
        // false
        boolean digits3 = NumberUtils.isParsable(str3);
        System.out.println(digits3);
    }

    /**
     *  NumberUtils.isCreatable
     * 判断String类型的参数是不是数字（整数、浮点数） 可以识别正、负、进制
     */
    @Test
    public void testCreatable(){
        String str = "123.3abc";
        String str2 = "123.3";
        String str3 = "+123";
        String str4 = "012";
        String str5 = "09";

        // false
        boolean digits1 = NumberUtils.isCreatable(str);
        System.out.println(digits1);
        // true
        boolean digits2 = NumberUtils.isCreatable(str2);
        System.out.println(digits2);
        // true
        boolean digits3 = NumberUtils.isCreatable(str3);
        System.out.println(digits3);
        // true 0开头认为是八进制
        System.out.println(NumberUtils.isCreatable(str4));
        // false
        System.out.println(NumberUtils.isCreatable(str5));
    }
}
