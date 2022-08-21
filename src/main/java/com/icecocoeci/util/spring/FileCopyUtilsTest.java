package com.icecocoeci.util.spring;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/09/0:25
 * @Description:
 */
public class FileCopyUtilsTest {
    @Test
    public void test() throws IOException {
        ClassPathResource resource = new ClassPathResource("1.test");
        EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
        String targetPath = "D://2.txt";
        FileCopyUtils.copy(encodedResource.getInputStream(),new FileOutputStream(targetPath));


    }
}
