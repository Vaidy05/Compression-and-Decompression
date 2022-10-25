/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author Intel
 */
public class Decompress {
    
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);//Read the file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Decompressfile.txt");//save the file
        
        GZIPInputStream gis = new GZIPInputStream(fis);//creating obj of gzip to compress the file
        
        byte[] buffer = new byte[2048];//will store asci value in this array after reading the file
        int len;
        while((len = gis.read(buffer)) != -1)//fis.read reads all the lines in file at once, after reading it returns -1
        {
            fos.write(buffer,0,len);
        }
        
        //for(int i=0;i<5;i++)
            //System.err.println(buffer[i]);//it will print the asci value of first 5 characters
            gis.close();
            fos.close();
            fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        File file = new File("F:\\User\\Compreesedfile.gz");
        method(file);
    }
}
