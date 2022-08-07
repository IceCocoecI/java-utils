package com.icecocoeci.util.apache.io;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/07/10:05
 * @Description:
 */
public class IoTest {
    /**
     * 读取指定的文本内容为一个字符串、List
     * FileUtils.readFileToString
     * FileUtils.readLines
     *
     * 获取文件名称 获取文件后缀
     * FilenameUtils.getBaseName
     * FilenameUtils.getExtension
     */
    @Test
    public void test() throws IOException {
        String path = "src/main/resources/1.test";

        // 读取指定的文本内容为一个字符串
        String string = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        System.out.println(string);

        // 读取指定的文本内容为一个List
        List<String> list = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
        System.out.println(list.size());

        //获取文件名称 1
        String baseName = FilenameUtils.getBaseName(path);
        System.out.println(baseName);

        //获取文件后缀 test
        String extension = FilenameUtils.getExtension(path);
        System.out.println(extension);
    }
}
