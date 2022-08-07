package com.icecocoeci.util.apache.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/06/15:37
 * @Description:
 */
public class StringUtilsTest {

    /**
     * StringUtils.isBlank
     *  判断null/""/"   "
     */
    @Test
    public void testBlank(){
        String str = "  ";
        // true
        System.out.println(StringUtils.isBlank(str));
        // 反过来
        System.out.println(StringUtils.isNotBlank(str));
    }

    /**
     * StringUtils.isEmpty
     *  判断null/""
     */
    @Test
    public void testEmpty(){
        String str = "   ";
        // false
        System.out.println(StringUtils.isEmpty(str));
        // 反过来
        System.out.println(StringUtils.isNotEmpty(str));
    }

    /**
     * StringUtils.left
     * 18700007072
     * 返回前端脱敏
     * 187****7072
     */
    @Test
    public void testLeftRight(){
        String str = "18700007072";
        // 返回某个字符串左边的几个字符
        String left = StringUtils.left(str, 3);
        // 返回某个字符串右边的几个字符
        String right = StringUtils.right(str, 4);
        // 实现1
        System.out.println(left + "****" + right);
        // 实现2
        // rightPad 如果left长度<7，那么就在右边用*填充到7个长度
        String rightPad = StringUtils.rightPad(left, 7, '*');
        System.out.println(rightPad+right);

    }
}
