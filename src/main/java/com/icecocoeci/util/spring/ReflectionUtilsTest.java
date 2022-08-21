package com.icecocoeci.util.spring;

import org.junit.Test;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/07/18:00
 * @Description:
 */
public class ReflectionUtilsTest {
    /**
     * 获取到本类以及所有的父类（包含父类的父类···）的所有属性、方法
     */
    @Test
    public void testReflectionUtils(){
        ReflectionUtils.doWithFields(ZhangSan.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                // 获取到本类以及所有的父类（包含父类的父类···）的所有属性
                System.out.println(field.getName());
            }
        });

        ReflectionUtils.doWithMethods(ZhangSan.class, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                // 获取到本类以及所有的父类（包含父类的父类···）的所有方法
                System.out.println(method.getDeclaringClass().getName()+"的"+method.getName());
            }
        });

        // 或者
        Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(ZhangSan.class);

        //获取单个属性
        ZhangSan zhangSan = new ZhangSan();
        zhangSan.setId(1L);
        ReflectionUtils.doWithFields(ZhangSan.class,field->{
            field.setAccessible(true);
            final Object fieldValue = ReflectionUtils.getField(field, zhangSan);
            System.out.println(fieldValue);
        });
    }
}
