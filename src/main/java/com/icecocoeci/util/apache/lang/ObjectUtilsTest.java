package com.icecocoeci.util.apache.lang;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/06/16:33
 * @Description:
 */
public class ObjectUtilsTest {
    /**
     *  ObjectUtils.firstNonNull
     * str,str2,str3... 取第一个不为空的作为结果使用
     */
    @Test
    public void testFirstNonNull(){
        String str1 = null;
        String str2 = null;
        String str3 = "str333";
        System.out.println(ObjectUtils.firstNonNull(str1,str2,str3));
    }

    /**
     * ObjectUtils.identityToString
     * 源码调用了System.identityHashCode 可以当地址使用，不太可能重复，spring源码中几处用作bean的ID
     */
    @Test
    public void testIdentityToString(){
        // java.lang.String@e73f9ac
        System.out.println(ObjectUtils.identityToString("abc"));
    }
}
