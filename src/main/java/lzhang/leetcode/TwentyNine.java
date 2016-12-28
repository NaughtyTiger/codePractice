package lzhang.leetcode;

/*
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT. 
 */
public class TwentyNine {
  public int divide(int dividend, int divisor) {
    if (divisor==0){
      return Integer.MAX_VALUE;
    } else if (dividend==0){
      return 0;
    } else if (divisor==1){
      return dividend;
    } else if (divisor==-1){
      if (dividend==Integer.MIN_VALUE){
        return Integer.MAX_VALUE;
      }
      return -dividend;
    }

    boolean flag=true;
    boolean min_value=false;
    if (divisor<0){
      if (divisor==Integer.MIN_VALUE){
        return dividend==Integer.MIN_VALUE?1:0;
      }
      divisor=-divisor;
      flag=!flag;
    }

    if (dividend<0){
      if (dividend==Integer.MIN_VALUE){
        min_value=true;
        dividend=Integer.MAX_VALUE;
      } else {
        dividend=-dividend;
      }
      flag=!flag;
    }
    
    int result=0;
    int stepIndex=1;
    int step=divisor;
    while (dividend>=divisor){
      if (dividend>=step){
        dividend-=step;
        step+=divisor;
        result+=stepIndex;
        stepIndex++;
      } else {
        stepIndex--;
        step-=divisor;
      }
    }
    if (min_value){
      if (dividend+1==divisor){
        result++;
      }
    }
    
    return flag?result:-result;
  }
}
