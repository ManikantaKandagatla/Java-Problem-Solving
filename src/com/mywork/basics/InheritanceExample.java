package com.mywork.basics;

class Ap {
  public static void fun1() {
    System.out.println("Class A: Static fun 1");
  }

  private void fun1(String a) {
    System.out.println("Class A: Overload non-static");
  }
}

class Bp  extends  Ap{

  public static void fun1() {
    System.out.println("Class B: Static fun1 override");
  }

  private void fun1(String s) {
    System.out.println("Class B: non-static fun1 ");
  }
}

public class InheritanceExample {
  public static void main(String args[]) {
    Bp b = new Bp();
    b.fun1();
    Bp.fun1();

  }
}
