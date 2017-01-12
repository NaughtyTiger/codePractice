package lzhang.leetcode;

public class ThirtyTwo {
  public int longestValidParentheses(String s) {
    return methodDP(s);
  }
  
  private int methodDP(String s){
    if (s.length()<2){
      return 0;
    }
    int max=0;
    int[] longest=new int[s.length()+1];
    
    for (int i=1; i<s.length(); i++){
      int j=i+1;
      if (s.charAt(i)==')'){
        if (s.charAt(i-1)=='('){
          longest[j]=longest[j-2]+2;
          max=Math.max(longest[j], max);
        } else if (s.charAt(i-1)==')'){
          if (i-longest[j-1]-1>=0){
            if (s.charAt(i-longest[j-1]-1)=='('){
              longest[j]=longest[j-1]+2+longest[j-longest[j-1]-2];
              max=Math.max(longest[j], max);
            }
          }
        }
      }
    }
    return max;
  }
}
