package lzhang.leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Nine {
  public boolean isPalindrome(int x) {
    if (x==0){
      return true;
    } else if (x<0){
      return false;
    }
    int m=x;
    int length=0;
    while (m>0){
      length++;
      m/=10;
    }
    
    m=x;
    for (int i=0;i<length/2;i++){
      if (m%10==m/(int)Math.pow(10, length-i*2-1)){
        m=m%(int)Math.pow(10, length-i*2-1);
        m/=10;
        continue;
      } return false;
    }
    return true;
  }
}
