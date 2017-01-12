package lzhang.leetcode;

public class Fifty {
  public double myPow(double x, int n) {
    double result=1.0;
    boolean flag=n>0;
    boolean minValue=false;
    if (n==Integer.MIN_VALUE){
      n=Integer.MAX_VALUE;
      minValue=true;
    } else {
      n=n<0?-n:n;
    }
    
    if (n==1){
      return flag?x:1.0/x;
    }
    int[] pow=new int[31];
    double[] tmpNum=new double[31];
    
    pow[0]=1;
    tmpNum[0]=x;
    int i=1;
    for (i=1; i<31; i++){
      pow[i]=pow[i-1]*2;
      if (pow[i]>n){
        break;
      }
      tmpNum[i]=tmpNum[i-1]*tmpNum[i-1];
    }
    if (i==31){
      i--;
    }
    
    for (; i>=0; i--){
      if (n>=pow[i]){
        n-=pow[i];
        if (flag){
          result*=tmpNum[i];
        } else {
          result/=tmpNum[i];
        }
      }
    }
    return minValue?result/x:result;
  }
}