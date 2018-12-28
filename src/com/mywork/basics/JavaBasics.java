package com.mywork.basics;

/**
 * @author ManiKanta Kandagatla
 * @version $Id: $
 */

interface I1
{
    final int i = 100;

    final String str = "a";
}

interface I2
{
    final int i = 1000;

    final String str = "b";
}

class A
{
    public int a;

    public void fun1()
    {
        System.out.println("A: Fun1");
    }

    A()
    {
        System.out.println("Im in constructor A");
        this.a = 5;
    }
}

class B extends A
{
    public int a;

    public void fun1()
    {
        System.out.println("B: Fun1");
    }

    B()
    {
        System.out.println("Im in constructor B");
        super.a = 8;
        this.a = 5;
    }
}

class C implements I1, I2
{
    public static void staticfunction1()
    {
        System.out.println("Im in static function of Class C");
    }

    C()
    {
        System.out.println(I1.i);
        System.out.println(I2.str);
    }
}

public class JavaBasics
{

    /**
     * 
     */
    public JavaBasics()
    {
        // TODO Auto-generated constructor stub
    }

    static
    {
        final int a = 4;
        System.out.println("static Block");
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String a = "abc";
        A aobj = new A();
        B bobj = new B();
        A toB = new B();
        C objC = new C();
        a = a + "xyz";
        String bbb = new String("manikanta");
        bbb = bbb + "xyz";
        System.out.println(a);
        System.out.println(toB.a);
        System.out.println(aobj.a);
        System.out.println(bobj.a);
        aobj.fun1();
        bobj.fun1();
        toB.fun1();
        C.staticfunction1();
    }

}
