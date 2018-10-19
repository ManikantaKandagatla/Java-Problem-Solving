package com.mywork.basics;

import java.util.Collections;

/**
 * @author ManiKanta Kandagatla
 */
class MyException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String message;

    public MyException(String message)
    {
        this.message = message;
    }
}

interface CustomInterface
{
    public void fun4() throws MyException;
    public void fun5() throws Exception;
    public void fun6() ;
}

public class CustomException implements CustomInterface
{
    
    
    
    public void fun5() throws MyException
    {
        
    }
    
    public void fun3()
    {
        try
        {
            fun1();
        }
        catch (MyException e)
        {
            System.out.println(e.message);
        }
    }

    public void fun1() throws MyException
    {
        fun2();
    }

    public void fun2() throws MyException
    {
        throw new MyException("my exception is thrown");
    }

    public static void main(String[] args)
    {
        CustomException testObj = new CustomException();
        testObj.fun3();
    }

    @Override
    public void fun4() throws MyException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fun6()
    {
        // TODO Auto-generated method stub
        
    }
}
