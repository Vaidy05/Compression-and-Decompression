/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Intel
 */
public class Compress {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);//Read the file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compreesedfile.gz");//save the file
        
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);//creating obj of gzip to compress the file
        
        byte[] buffer = new byte[2048];//will store asci value in this array after reading the file
        int len;
        while((len = fis.read(buffer)) != -1)//fis.read reads all the lines in file at once, after reading it returns -1
        {
            gzipOS.write(buffer,0,len);
        }
        
        //for(int i=0;i<5;i++)
            //System.err.println(buffer[i]);//it will print the asci value of first 5 characters
            gzipOS.close();
            fos.close();
            fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        File path = new File("F:\\User\\Selenium Assignment 2.txt");//location were file is saved
        method(path);
    }
}
