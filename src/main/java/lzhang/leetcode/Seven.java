package lzhang.leetcode;

public class Seven {
  public int reverse(int x) {
    return methodOne(x);
  }

  public int methodOne(int x) {
    int result=0;
    boolean flag=false;
    if (x<0){
      x=-x;
      flag=true;
    }
    while (x>0){
      if (result>Integer.MAX_VALUE/10){
        return 0;
      }
      result=result*10+x%10;
      x=x/10;
    }
    return flag?-result:result;
  }
}
