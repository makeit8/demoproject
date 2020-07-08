package com.example.trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 所有实现 Closeable 接口的“资源”，均可采用 try-with-resource 进行简化
 */
public class TryWithSource {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\test.txt"))){
            String line ;
            while ((line =bufferedReader.readLine()) !=null ){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
