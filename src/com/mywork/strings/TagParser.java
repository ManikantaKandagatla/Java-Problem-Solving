
package com.mywork.strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */
public class TagParser
{

    public void parse() throws IOException
    {
        File file = new File("Input.txt");
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
            {
                System.out.println(st);
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        TagParser testObj = new TagParser();
        testObj.parse();
    }

}
