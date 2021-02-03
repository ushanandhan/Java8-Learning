package com.ioStream;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import javax.annotation.processing.Filer;
import java.io.*;

public class IOStreamExample {

    @Test
    public void byteStreamTest() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File file = ResourceUtils.getFile("classpath:iostream/byte/input.txt");
            in = new FileInputStream(file);
            out = new FileOutputStream("../Learning/src/main/resources/iostream/byte/output.txt");
            int c = 0;
            while((c=in.read())!=-1){
                System.out.print((char) c);
                out.write(c);
            }
        }finally {
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
        }
    }

    @Test
    public void charStreamTest() throws IOException{
        FileOutputStream f1 = new FileOutputStream("../Learning/src/main/resources/iostream/byte/output.txt");
        f1.write(65);
        f1.close();
        System.out.println("Please check the document : ");
    }

    @Test
    public void byteOutStreamTest() throws IOException{
        try {
            FileOutputStream fos = new FileOutputStream("../Learning/src/main/resources/iostream/byte/output.txt");
            String s = "Welcome to Java";
            byte[] b = s.getBytes();
            System.out.println("Byte value is : ");
            fos.write(b);
            fos.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void fileWriterTest() throws IOException{
        FileWriter out = null;
        try {
            out = new FileWriter("../Learning/src/main/resources/iostream/char/output.txt");
            String s = "Welcome to Java CHAR";
            out.write(s);
        }finally {
            out.close();
        }
    }

    @Test
    public void fileReaderTest() throws IOException{
        FileReader in = null;
        try {
            in = new FileReader("../Learning/src/main/resources/iostream/char/output.txt");
            int i = 0;
            while((i=in.read())!=-1){
                System.out.print((char)i);
            }
        }finally {
            in.close();
        }
    }
}
