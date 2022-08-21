package com.icecocoeci.util.spring;

import org.junit.Test;
import org.springframework.util.ClassUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/07/17:44
 * @Description:
 */
public class ClassUtilsTest {
    /**
     * 当某个类存在时，再去做某件事。类似于Condition注解
     * ClassUtils.isPresent
     */
    @Test
    public void test1(){
        String className = "com.icecocoeci.util.spring.ClassUtilsTest";

/*        try {
            //常规方式一 不存在则报java.lang.ClassNotFoundException: com.icecocoeci.spring.ClassUtilsTest
            //Class<?> aClass = Class.forName(className);

            // 常规方式二
            ClassUtilsTest.class.getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        // 工具类方式 classLoader可传可不传，null则默认 true
        boolean present = ClassUtils.isPresent(className, null);
        System.out.println(present);
    }
}
