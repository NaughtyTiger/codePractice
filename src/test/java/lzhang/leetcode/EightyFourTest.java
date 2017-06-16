package lzhang.leetcode;

import org.junit.Test;

public class EightyFourTest {
  @Test
  public void test(){
    int TIMES=100;
//    int[] heights={2,1,5,6,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,4,12,23,233,1,1,1,2,3
//        ,2,1,5,6,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,4,12,23,233,1,1,1,2,3
//        ,2,1,5,6,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,4,12,23,233,1,1,1,2,3
//        ,2,1,5,6,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,4,12,23,233,1,1,1,2,3};
    int[] heights={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,
        25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44};
    EightyFour inst=new EightyFour();
    {
      long start=System.nanoTime();
      for (int i=0; i<TIMES; i++){ 
        inst.method1(heights);
      }
      long end=System.nanoTime();
      System.out.println("Method1:"+(end-start));
    }
    {
      long start=System.nanoTime();
      for (int i=0; i<TIMES; i++){ 
        inst.method2(heights);
      }
      long end=System.nanoTime();
      System.out.println("Method2:"+(end-start));
    }
  }
}