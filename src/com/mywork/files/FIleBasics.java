package com.mywork.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ManiKanta Kandagatla
 */
public class FIleBasics
{

    public static void readFile(String path) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<List<String>> details = new ArrayList<>();
        while ((line = br.readLine()) != null)
        {
            String[] data = line.trim().split(" ");
            System.out.println(data.length);
            if (data != null && data.length == 2)
            {
                List<String> detail = new ArrayList<>();
                detail.add(data[0]);
                detail.add(data[1]);
                details.add(detail);
            }
        }
        System.out.println(details);
    }
    
    public static void main(String args[]) throws IOException 
    {
        readFile("C:\\Users\\ManiKanta Kandagatla\\git\\Java-Problem-Solving\\src\\com\\mywork\\files\\data.txt");
    }

}
