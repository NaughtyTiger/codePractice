package lzhang.leetcode;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends A implements B {
  @Test
  public void test(){
    Class[] interfaces=new Class[]{AppTest.class};
    System.out.println(A.class.isAssignableFrom(AppTest.class));
  }
}

class A {
  public void test(){}
};

interface B {
  public void test();
};
