package lzhang.leetcode;

import org.junit.Test;

public class FiftyTest {
  @Test
  public void test(){
    Fifty inst=new Fifty();
    System.out.println(inst.myPow(2.0, -2147483648));
  }
  
//  @Test
  public void test1(){
    int result=2147483647;
    for (int i=2; i*i<result; i++){
      if (result%i==0){
        System.out.println("no");
      }
    }
  }
}
