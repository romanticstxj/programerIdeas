package com.disney.wdpro.service.mockpis.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {

    /**
     * 读取classpath下面的文件
     *
     * @param classpathFile
     * @return
     */
    public static String readClasspathFile(String classpathFile) {
        StringBuilder sb = new StringBuilder();
        //java7开始引入的try-with-resource写法
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(classpathFile).toURI()), StandardCharsets.UTF_8)) {
            //给每一行末尾加上换行符
            stream.forEach(s -> sb.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException syntaxEx) {
            syntaxEx.printStackTrace();
        }

        return sb.toString();
    }
}
